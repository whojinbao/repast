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

import com.sun.org.apache.bcel.internal.generic.Select;
import com.who.getdata.DishesDao;
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
				list.add(ok);
			}
		} catch (Exception e) {}
		session.setAttribute("dingdan", list);
		return "geren";
	}
}
