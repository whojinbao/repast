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
	public List<Integer> getDetailed(){
		String sql="select d.detailedId from detailed d ,orderList o where d.orderId=o.orderId and o.orderStatus=0 group by d.detailedId";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Integer> ll=new ArrayList<Integer>();
		try {
			while(rs.next()){
				ll.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}
	/*
	 * 按照下单时间排序把所有的已点未炒的菜品提取到List中
	 */
	public List<Dishes> getDishes(){
		String sql="select o.seatId,d.menuId,m.menuName,d.detailednum,m.maxNum,m.doTime,d.detailedId,q.await,q.urge,q.support from detailed d,menu m, orderList o,quanzhong q where d.orderId=o.orderId and d.menuId=m.menuId and d.detailedId=q.detailedId and d.dishesStatus=0 and o.orderStatus=0 order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishes> list=new ArrayList<Dishes>();
		try {
			while(rs.next()){
				Dishes dishes=new Dishes();
				dishes.setDetailedId(rs.getInt("detailedId"));
				dishes.setDoTime(rs.getInt("doTime"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				List<String> seatList=new ArrayList<String>();
				seatList.add(rs.getString("seatId"));
				dishes.setSeatId(seatList);
				List<Integer> ssnum=new ArrayList<Integer>();
				ssnum.add(rs.getInt("detailednum"));
				dishes.setQuantity(ssnum);
				List<Integer> li=new ArrayList<Integer>();
				li.add(rs.getInt("await"));
				li.add(rs.getInt("urge"));
				li.add(rs.getInt("support"));
				dishes.setSeat(li);
				list.add(dishes);
			}
		} catch (Exception e) {
			System.out.println("数据库读取未炒菜品"+e.getMessage());
		};
		return list;
	}
	/*
	 * 按照下单时间排序把所有的正在炒的菜品提取到List中
	 */
	public List<Dishesing> getDishesing(){
		String sql="select o.seatId,d.menuId,m.menuName,d.detailednum,m.maxNum,m.doTime,d.detailedId,d.startTime from detailed d,menu m, orderList o where d.orderId=o.orderId and d.menuId=m.menuId and  d.dishesStatus=1 and o.orderStatus=0 order by d.detailedTime";
		ResultSet rs=dd.executeQuery(sql, null);
		List<Dishesing> list=new ArrayList<Dishesing>();
		try {
			while(rs.next()){
				Dishesing dishes=new Dishesing();
				dishes.setDetailedId(rs.getInt("detailedId"));
				dishes.setDoTime(rs.getInt("doTime"));
				dishes.setMaxNum(rs.getInt("maxNum"));
				dishes.setMenuId(rs.getInt("menuId"));
				dishes.setMenuName(rs.getString("menuName"));
				dishes.setSeatId(rs.getInt("seatId"));
				dishes.setDetailednum(rs.getInt("detailedNum"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s=rs.getString("startTime");
				Date date = sdf.parse(s);
				dishes.setStartTime(date);
				list.add(dishes);
			}
		} catch (Exception e) {
			System.out.println("数据库读取正在炒菜品"+e.getMessage());
		};
		return list;
	}
	/*
	 * 派餐界面
	 * 获取  桌号、总数量	、已上、最后上餐时间
	 */
	public List<Total> getTotals(){
		String sql="select seatId ,count(detailednum) countNum from orderList o,detailed d where o.orderId=d.orderId group by seatId";
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
				String sql1="select count(dishesStatus) have from orderList o,detailed d where o.orderId=d.orderId and o.seatId=? and dishesStatus=2 group by seatId";
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
}
