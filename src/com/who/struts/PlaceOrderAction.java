package com.who.struts;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Result;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.who.getdata.DishesDao;
import com.who.util.YOrderOkUtil;
import com.who.util.orderOkUtil;
import com.zf.entity.util.ShopCartUtil;

public class PlaceOrderAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=request.getSession();
	DishesDao dd=new DishesDao();
	/*
	 * 数据库获取详细地址
	 */
	public String getAddress(){
		String phone=(String) session.getAttribute("phone");
		String sql="select * from qiantai where  phone="+phone;
		ResultSet rs1=dd.getData(sql, null);
		String id="";
		try {
			while(rs1.next()){
				id=rs1.getString("id");
				session.setAttribute("userid", id);
			}
		} catch (Exception e) {}
		String sql1="select * from clientaddress where id="+id;
		ResultSet rs=dd.getData(sql1, null);
		
		List<String> addresses=new ArrayList<String>();
		try {
			while(rs.next()){
				addresses.add(rs.getString("clientid"));
				addresses.add(rs.getString("addresss"));
				addresses.add(rs.getString("name"));
				addresses.add(rs.getString("phone"));
			}
		} catch (Exception e) {}
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(addresses);
		} catch (Exception e) {
		}
		return null;
		
	}
	/*
	 * 地图地址
	 */
	public String saveAddress(){
		String str=request.getParameter("ads");
		session.setAttribute("newdizhi", str);
		session.setAttribute("kongzhiadd", "1");
		return null;
	}
	/*
	 * 添加地址
	 */
	public String addDizhi(){
		String id=(String) session.getAttribute("userid");
		String name=(String) session.getAttribute("newmingzi");
		String phone=(String) session.getAttribute("dianhua");
		String dizhi=(String) session.getAttribute("newdizhi");
		String xiangxidizhi=(String) session.getAttribute("xiangxi");
		String sql="insert into clientaddress(id,name,addresss,phone)values("+id+",'"+name+"','"+dizhi+xiangxidizhi+"',"+phone+")";
		dd.updateData(sql, null);
		session.setAttribute("kongzhiadd", "");
		session.setAttribute("newmingzi", "");
		session.setAttribute("dianhua", "");
		session.setAttribute("newdizhi", "");
		session.setAttribute("xiangxi", "");
		return "back";
	}
	/*
	 * 放详细地址
	 */
	public String saveXiangxi(){
		String str=request.getParameter("xiangxi");
		session.setAttribute("xiangxi", str);
		return null;
	}
	/*
	 * 放名字
	 */
	public String saveName(){
		String str=request.getParameter("mingzi");
		session.setAttribute("newmingzi", str);
		return null;
	}
	/*
	 * 放电话
	 */
	public String saveDianhua(){
		String str=request.getParameter("dianhua");
		session.setAttribute("dianhua", str);
		return null;
	}
	/*
	 * 删除地址
	 */
	public String deleteAddress(){
		String id=request.getParameter("deleteid");
		String sql="delete from clientaddress where clientid="+id;
		dd.updateData(sql, null);
		return null;
	}
	/*
	 * 清空地址
	 */
	public String qingAddress(){
		session.setAttribute("kongzhiadd", "");
		session.setAttribute("newmingzi", "");
		session.setAttribute("dianhua", "");
		session.setAttribute("newdizhi", "");
		session.setAttribute("xiangxi", "");
		return null;
	}
	/*
	 * 外卖确认下单
	*/
	public String orderok(){
		String addressid=request.getParameter("addressid");
		List<ShopCartUtil> list=(List<ShopCartUtil>) session.getAttribute("shopCartList");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newTime = new Date();//当前时间
		String orderid=sdf.format(newTime);
		String id=(String) session.getAttribute("userid");
		float allprice=0;
		for (int i = 0; i < list.size(); i++) {
			ShopCartUtil l=list.get(i);
			allprice +=l.getMenuPrice()*l.getNum();
			String sql="insert into detailed (orderId,detailedId,detailedTime,menuId,detailednum)values(?,?,?,?,?)";
			Object params[]={orderid,orderid+"000",sdf1.format(newTime),l.getMenuId(),l.getNum()};
			dd.updateData(sql, params);
		}
		String sql="insert into orderList(orderId,orderTimes,seatId,orderStatus,orderSort,totalPrice,addresss)values(?,?,?,?,?,?,?)";
		Object params[]={orderid,sdf1.format(newTime),"y"+id,3,2,allprice,addressid};
		dd.updateData(sql, params);
		String sql1="insert into quanzhong(detailedId)values('"+orderid+"000"+"')";
		dd.updateData(sql1, null);
		session.setAttribute("shopCartList",null);
		 gogeren();
		 session.setAttribute("who_okorder", "");
		return null;
	}
	/*
	 * 个人中心
	 */
	public String gogeren(){
		List<orderOkUtil> list=new ArrayList<orderOkUtil>();
		String phone=(String) session.getAttribute("phone");
		String sql="select * from orderList o,qiantai q,clientaddress c where o.addresss=c.clientid and q.id=c.id and o.orderStatus not in(1) and q.phone='"+phone+"'";
		ResultSet rs=dd.getData(sql, null);
		try {
			while(rs.next()){
				orderOkUtil ok=new orderOkUtil();
				ok.setId(rs.getString("orderId"));
				ok.setPrice(rs.getFloat("totalPrice"));
				ok.setStatus(rs.getString("orderStatus"));
				ok.setTime(rs.getString("orderTimes"));
				String sql2="select name,phone,c.addresss addresss from orderList o,clientaddress c where o.addresss = c.clientid and orderId='"+rs.getString("orderId")+"'";
				ResultSet rs2=dd.getData(sql2, null);
				while(rs2.next()){
					ok.setName(rs2.getString("name"));
					ok.setPhone(rs2.getString("phone"));
					ok.setAddress(rs2.getString("addresss"));
				}
				String sql11="select * from detailed d,menu m where m.menuId=d.menuId and orderId='"+rs.getString("orderId")+"'";
				ResultSet rs1=dd.getData(sql11, null);
				List<YOrderOkUtil> yy=new ArrayList<YOrderOkUtil>();
				while (rs1.next()) {
					YOrderOkUtil yo=new YOrderOkUtil();
					yo.setName(rs1.getString("menuName"));
					yo.setNum(rs1.getString("detailednum"));
					yo.setPrices(rs1.getString("menuPrice"));
					yy.add(yo);
				}
				ok.setList(yy);
				list.add(ok);
			}
		} catch (Exception e) {}
		session.setAttribute("dingdan", list);
		 oldOrder();
		return "geren";
	}
	/*
	 * 外卖确认收货
	 */
	public String orderConfirm(){
		String orderId=request.getParameter("wmorderId");
		String sql="update orderList set orderStatus=1 where orderId='"+orderId+"'";
		dd.updateData(sql, null);
		gogeren();
		return "geren";
	}
	/*
	 * 已完成订单数据提取
	 */
	public String oldOrder(){
		String numstr=request.getParameter("yemanum");
		Integer numSession=(Integer) session.getAttribute("numSession");
		String phone=(String) session.getAttribute("phone");
		String sqq="select COUNT(orderId) num from orderList o,qiantai q,clientaddress c where o.addresss=c.clientid and q.id=c.id and o.orderStatus=1 and q.phone='"+phone+"'";
		ResultSet rrs=dd.getData(sqq, null);
		int a=0;
		try {
			rrs.next();
			a=rrs.getInt("num");
		} catch (Exception e) {}
		int b=0;
		if(a!=0){
			b=a/10;
		}
		if(numSession==null){
			numSession=0;
		}	
		if(!(numstr==null)){
			session.setAttribute("who_okorder", "1");
			if(numstr.equals("1")){
				numSession=numSession+1;
			}else if(numstr.equals("-1")){
				numSession=numSession-1;
				if(numSession<0){
					numSession=0;
				}
			}else{
				numSession=0;
			}
		}
		if(numSession>b){
			numSession=b;
		}
		session.setAttribute("numSession", numSession);
		List<orderOkUtil> list=new ArrayList<orderOkUtil>();
		
		String sql="select top 10 * from orderList o,qiantai q,clientaddress c where o.addresss=c.clientid and q.id=c.id and o.orderStatus=1 and q.phone='"+phone+"' and orderId not in(select top "+(10*numSession)+" orderId from orderList o,qiantai q,clientaddress c where o.addresss=c.clientid and q.id=c.id and o.orderStatus=1 and q.phone='"+phone+"')";
		ResultSet rs=dd.getData(sql, null);
		try {
			while(rs.next()){
				orderOkUtil ok=new orderOkUtil();
				ok.setId(rs.getString("orderId"));
				ok.setPrice(rs.getFloat("totalPrice"));
				ok.setStatus(rs.getString("orderStatus"));
				ok.setTime(rs.getString("orderTimes"));
				String sql2="select name,phone,c.addresss addresss from orderList o,clientaddress c where o.addresss = c.clientid and orderId='"+rs.getString("orderId")+"'";
				ResultSet rs2=dd.getData(sql2, null);
				while(rs2.next()){
					ok.setName(rs2.getString("name"));
					ok.setPhone(rs2.getString("phone"));
					ok.setAddress(rs2.getString("addresss"));
				}
				String sql11="select * from detailed d,menu m where m.menuId=d.menuId and orderId='"+rs.getString("orderId")+"'";
				ResultSet rs1=dd.getData(sql11, null);
				List<YOrderOkUtil> yy=new ArrayList<YOrderOkUtil>();
				while (rs1.next()) {
					YOrderOkUtil yo=new YOrderOkUtil();
					yo.setName(rs1.getString("menuName"));
					yo.setNum(rs1.getString("detailednum"));
					yo.setPrices(rs1.getString("menuPrice"));
					yy.add(yo);
				}
				ok.setList(yy);
				list.add(ok);
			}
		} catch (Exception e) {}
		session.setAttribute("oldorder_who", list);	
		if(b!=0){
			session.setAttribute("oldorder_who_num", numSession+1);
		}else{
			session.setAttribute("oldorder_who_num", 1);
		}
		session.setAttribute("oldorder_who_num_sun", b+1);
		return null;
	}
	public String zhuxiao(){
		session.setAttribute("username",null);
		session.setAttribute("phone",null);
		return "diancan";
	}
}
