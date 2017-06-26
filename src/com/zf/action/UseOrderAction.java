package com.zf.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseOrderDao;
import com.zf.entity.Order;
import com.zf.entity.util.ShopCartUtil;


/**
 *     对订单的增删改查的操作 order
 *     上启页面 ，从页面坚守数据（.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseOrderAction {
	private static final String DateTime = null;
	private UseOrderDao useOrderDao = new UseOrderDao();
	private Order order1 = new Order();

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();

	public UseOrderDao getUseOrderDao() {
		return useOrderDao;
	}


	public void setUseOrderDao(UseOrderDao useOrderDao) {
		this.useOrderDao = useOrderDao;
	}


	public Order getOrder1() {
		return order1;
	}


	public void setOrder1(Order order1) {
		this.order1 = order1;
	}

	/**
	 * addOrder()订单的添加
	 * 
	 * 
	 */
	public String addOrder(Order order){
		useOrderDao.addOrder(order);
		selOrder();
		return "ok";
	}

	/**
	 * updateOrder()订单的添加
	 * 
	 * 
	 */
	public String updateOrder(String orderId,int totalPrice,int orderStatus){
		useOrderDao.updateOrder(orderId,totalPrice,orderStatus);
		selOrder();
		return "ok";
	}



	/**
	 * delOrder()订单的删除
	 * 
	 * 
	 */
	public String  delOrder(){
		int orderId =Integer.parseInt( request.getParameter("orderId"));	
		useOrderDao.delOrder(orderId);
		selOrder();
		return "ok";

	}

	/**
	 * selOrder()订单的查询 全部
	 * 
	 * 
	 */
	public String  selOrder(){
		List<Order> orderList = useOrderDao.selOrder();
		session.setAttribute("orderList", orderList);
		return "ok";
	}




	/**
	 * selMhOrder()订单的条件查询
	 * 
	 * 
	 */
	public String  selMhOrder(){
		String startTimeStr = null;
		String endTimeStr = null;
		String mhOredrSeatId = null;
		try{
			startTimeStr = request.getParameter("startTime");
			endTimeStr = request.getParameter("endTime");
			mhOredrSeatId = request.getParameter("mhOredrSeatId");
		}catch(Exception e){

		}
		// 将字符串转化为日期类型
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = sdf3.parse(startTimeStr);
			endTime = sdf3.parse(endTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(startTime+  ""+ endTime);
		List<Order> orderList = useOrderDao.selMhOrder(startTime, endTime, mhOredrSeatId);
		session.setAttribute("orderList", orderList);
		return "ok";
	}
	/**
	 * 以 id查订单
	 *
	 */
	/*public String  selIdOrder(){
         String  
		
		
	}
*/

}
