package com.who.getdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.publics.dao.DaoFactory;
	
public class DishesDao{
	DaoFactory dd=new DaoFactory();
	/*
	 * 获取所有未结账的桌号
	 */
	public List<String> getDetailed(){
		String sql="select d.detailedId from detailed d ,orderList o where d.orderId=o.orderId and o.orderStatus=0 group by d.detailedId";
		ResultSet rs=dd.executeQuery(sql, null);
		List<String> ll=new ArrayList<String>();
		try {
			while(rs.next()){
				ll.add(rs.getString(1));
			}
		} catch (SQLException e) {}
		return ll;
	}
	/*
	 * 按照下单时间排序把所有的已点未炒的菜品提取到List中
	 */
	public List<Dishes> getDishes(){
		String sql="select d.ovenSum,d.ovening,o.seatId,d.menuId,m.menuName,(d.detailednum-d.ovenSum) sumnum,m.maxNum,m.doTime,d.detailedId,q.await,q.urge,q.support from detailed d,menu m, orderList o,quanzhong q where d.orderId=o.orderId and menuType=1 and d.menuId=m.menuId and d.detailedId=q.detailedId and o.orderStatus=0 and d.detailednum>d.ovenSum order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishes> list=new ArrayList<Dishes>();
		try {
			while(rs.next()){
				Dishes dishes=new Dishes();
				dishes.setDetailedId(rs.getString("detailedId"));
				dishes.setDoTime(rs.getInt("doTime"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				List<String> seatList=new ArrayList<String>();
				seatList.add(rs.getString("seatId"));
				dishes.setSeatId(seatList);
				dishes.setQuantity(rs.getString("sumnum"));
				List<Integer> li=new ArrayList<Integer>();
				li.add(rs.getInt("await"));
				li.add(rs.getInt("urge"));
				li.add(rs.getInt("support"));
				dishes.setSeat(li);
				list.add(dishes);
			}
		} catch (Exception e) {
		};
		return list;
	}
	/*
	 * 按照下单时间排序把所有的正在炒的菜品提取到List中
	 */
	public List<Ovening> getOvening(){
		String sql="select * from oven where ovenstatus=0 order by starTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Ovening> list=new ArrayList<Ovening>();
		try {
			while(rs.next()){
				Ovening oo=new Ovening();
				String a=rs.getString("detailedId");
				String [] detailedId = a.split(",");
				oo.setDetailedId(detailedId);
				String b=rs.getString("seatId");
				String [] seatId = b.split(",");
				oo.setSeatId(seatId);
				String c=rs.getString("detailednum");
				String [] detailednum = c.split(",");
				oo.setDetailednum(detailednum);
				String menuid=rs.getString("menuId");
				String sql1="select menuName,doTime from menu where menuId="+menuid;
				ResultSet rs1=dd.executeQuery(sql1, null);
				rs1.next();
				String menuName=rs1.getString("menuName");
				int doTime=rs1.getInt("doTime");
				oo.setMenuName(menuName);
				oo.setDoTime(doTime);
				oo.setMenuId(menuid);
				oo.setStartTime(rs.getString("starTime"));
				list.add(oo);
			}
		} catch (Exception e) {
		};
		return list;
	}
	public List<Dishesing> getDishesing(){
		String sql="select o.seatId,d.menuId,m.menuName,d.ovening,m.maxNum,m.doTime,d.detailedId,d.startTime ,d.ovenSum,d.ovening from detailed d,menu m, orderList o where d.orderId=o.orderId  and menuType=1 and d.menuId=m.menuId and  d.dishesStatus=1 and o.orderStatus=0 and ovening not in(0) order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishesing> list=new ArrayList<Dishesing>();
		try {
			while(rs.next()){
				Dishesing dishes=new Dishesing();
				dishes.setDetailedId(rs.getString("detailedId"));
				dishes.setDoTime(rs.getInt("doTime"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				dishes.setSeatId(rs.getString("seatId"));
				dishes.setDetailednum(rs.getInt("ovening"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s=rs.getString("startTime");
				Date date = sdf.parse(s);
				dishes.setStartTime(date);
				list.add(dishes);
			}
		} catch (Exception e) {
		};
		return list;
	}
	/*
	 * 派餐界面
	 * 获取  桌号、总数量	、已上、最后上餐时间
	 */
	public List<Total> getTotals(){
		String sql="select seatId ,SUM(detailednum) countNum from orderList o,detailed d where o.orderId=d.orderId and o.orderStatus=0 group by seatId";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Total> list=new ArrayList<Total>();
		try {
			while(rs.next()){
				Total tt=new Total();
				tt.setCountNum(rs.getInt("countNum"));
				tt.setSeatId(rs.getString("seatId"));
				list.add(tt);
			}
			for (int i = 0; i < list.size(); i++) {
				String sql1="select  SUM(ovenSum)-SUM(ovening) have from orderList o,detailed d where o.orderId=d.orderId and o.seatId=? group by seatId";
				Object[] para={list.get(i).getSeatId()};
				ResultSet rs1=dd.executeQuery(sql1, para);
				if(!rs1.next()){
					list.get(i).setHave(0);
				}else{
					list.get(i).setHave(rs1.getInt(1));
				}
				String sql2="select top 1 outTime have from orderList o,detailed d where o.orderId=d.orderId and o.seatId=? and outTime is not null and dishesStatus=2 order by outTime desc";
				Object[] para2={list.get(i).getSeatId()};
				ResultSet rs2=dd.executeQuery(sql2, para2);
				if(rs2.next()){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String s=rs2.getString(1);
					Date date = sdf.parse(s);
					list.get(i).setLastTime(date);
				}
			}
		} catch (Exception e) {
			System.out.println("数据库读取正在炒菜品"+e.getMessage());
		};
		return list;
	}
	/*
	 * 更新数据
	 */
	public int updateData(String sql,Object[] params){
		return dd.executeUpdate(sql, params);
	}
	/*
	 * 查询数据
	 */
	public ResultSet getData(String sql,Object[]params){
		return dd.executeQuery(sql, params);
	}
	/*
	 * 插入正在炒菜的数据
	 * 详情Id、菜品id、桌子编号、菜品数量、开始时间
	 */
	public void setOven(String []detailedId,String menuId,String [] seatId,String []detailednum){
		String sql="insert into oven(detailedId,menuId,seatId,detailednum,starTime)values(?,"+menuId+",?,?,?)";
		String a="";
		String b="";
		String c="";
		for (int i = 0; i < detailednum.length; i++) {
			a=a+detailedId[i]+",";
			b=b+seatId[i]+",";
			c=c+detailednum[i]+",";
		}
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d=sdf.format(date);
		Object []params={a,b,c,d};
		dd.executeUpdate(sql, params);
		
	}
	/*
	 * 更新入正在炒菜的数据
	 */
	public void updateOven(String menuId,String [] detailedId){
		String c="";
		for (int i = 0; i < detailedId.length; i++) {
			c=c+detailedId[i]+",";
		}
		String sql="update oven set ovenstatus=2 where menuId='"+menuId+"' and detailedId='"+c+"'";
		dd.executeUpdate(sql, null);
	}
	
	/*
	 * 获取凉菜类数据
	 */
	
	public List<Dishes> getLiang(){
		String sql="select d.ovenSum,d.ovening,o.seatId,d.menuId,m.menuName,(d.detailednum-d.ovenSum) sumnum,m.maxNum,m.doTime,d.detailedId,q.await,q.urge,q.support from detailed d,menu m, orderList o,quanzhong q where d.orderId=o.orderId and menuType=2 and d.menuId=m.menuId and d.detailedId=q.detailedId and o.orderStatus=0 and d.detailednum>d.ovenSum order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishes> list=new ArrayList<Dishes>();
		try {
			while(rs.next()){
				Dishes dishes=new Dishes();
				dishes.setDetailedId(rs.getString("detailedId"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				List<String> seatList=new ArrayList<String>();
				seatList.add(rs.getString("seatId"));
				dishes.setSeatId(seatList);
				dishes.setQuantity(rs.getString("sumnum"));
				List<Integer> li=new ArrayList<Integer>();
				li.add(rs.getInt("await"));
				li.add(rs.getInt("urge"));
				li.add(rs.getInt("support"));
				dishes.setSeat(li);
				list.add(dishes);
			}
		} catch (Exception e) {
		};
		return list;
	}
	
	/*
	 * 获取其他菜品
	 */
	public List<Dishes> getOthes(){
		String sql="select d.ovenSum,d.ovening,o.seatId,d.menuId,m.menuName,(d.detailednum-d.ovenSum) sumnum,m.maxNum,m.doTime,d.detailedId,q.await,q.urge,q.support from detailed d,menu m, orderList o,quanzhong q where d.orderId=o.orderId and menuType not in(1,2) and d.menuId=m.menuId and d.detailedId=q.detailedId and o.orderStatus=0 and d.detailednum>d.ovenSum order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishes> list=new ArrayList<Dishes>();
		try {
			while(rs.next()){
				Dishes dishes=new Dishes();
				dishes.setDetailedId(rs.getString("detailedId"));
				dishes.setDoTime(rs.getInt("doTime"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				List<String> seatList=new ArrayList<String>();
				seatList.add(rs.getString("seatId"));
				dishes.setSeatId(seatList);
				dishes.setQuantity(rs.getString("sumnum"));
				List<Integer> li=new ArrayList<Integer>();
				li.add(rs.getInt("await"));
				li.add(rs.getInt("urge"));
				li.add(rs.getInt("support"));
				dishes.setSeat(li);
				list.add(dishes);
			}
		} catch (Exception e) {
		};
		return list;
	}
	/*
	 * 获取正在炒菜的的所有桌台号
	 */
	private List<String[]> getOveningSeatList(){
		List<String[]> list=new ArrayList<String[]>();
		String sql="select seatId from oven where ovenstatus=0";
		ResultSet rs=dd.executeQuery(sql, null);
		try {
			while(rs.next()){
				String string=rs.getString("seatId");
				String [] str=string.split(",");
				list.add(str);
			}
		} catch (SQLException e) {}
		return list;
	}
	public List<String> getSeatList(){
		List<String []> ll=getOveningSeatList();
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).length; j++) {
				list.add(ll.get(i)[j]);
			}
		}
		return list;
	}
	
	
}
