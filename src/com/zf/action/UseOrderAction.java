package com.zf.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseOrderDao;
import com.zf.entity.Order;


/**
 *     �Զ�������ɾ�Ĳ�Ĳ��� order
 *     ����ҳ�� ����ҳ��������ݣ�.jsp������ӵ����ݿ�
 *     ����dao���̣��������ݿ�
 *     ��������
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
	 * addOrder()���������
	 * 
	 * 
	 */
	public String addOrder(){
		useOrderDao.addOrder(order1);
		selOrder();
		return "ok";
	}





	/**
	 * delOrder()������ɾ��
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
	 * selOrder()�����Ĳ�ѯ
	 * 
	 * 
	 */
	public String  selOrder(){
       List<Order> orderList = useOrderDao.selOrder();
       session.setAttribute("orderList", orderList);
       return "ok";
	}
}
