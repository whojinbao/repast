package com.zf.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseOrderDao;
import com.zf.entity.Order;


/**
 *     对订单的增删改查的操作 order
 *     上启页面 ，从页面坚守数据（.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseOrderAction {
	private UseOrderDao useOrderDao = new UseOrderDao();
	private Order order1 = new Order();

	HttpServletRequest request = ServletActionContext.getRequest();
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
	public String addOrder(){
		useOrderDao.addOrder(order1);
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
		System.out.println(orderId);
        useOrderDao.delOrder(orderId);
        selOrder();
        return "ok";
        
	}


	/**
	 * selOrder()订单的查询
	 * 
	 * 
	 */
	public String  selOrder(){
       List<Order> orderList = useOrderDao.selOrder();
       session.setAttribute("orderList", orderList);
       return "ok";
	}
}
