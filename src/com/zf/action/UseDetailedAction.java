package com.zf.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseDetailedDao;
import com.zf.entity.Detailed;


/**
 *     对 订单详情表 的增删改查的操作 Detailed
 *     上启页面 ，从页面坚守数据（.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseDetailedAction {
	private UseDetailedDao useDetailedDao = new UseDetailedDao();
	private Detailed detailed1 = new Detailed();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	public UseDetailedDao getUseDetailedDao() {
		return useDetailedDao;
	}
	public void setUseDetailedDao(UseDetailedDao useDetailedDao) {
		this.useDetailedDao = useDetailedDao;
	}
	public Detailed getDetailed1() {
		return detailed1;
	}
	public void setDetailed1(Detailed detailed1) {
		this.detailed1 = detailed1;
	}


	/**
	 * addDetailed()订单的添加
	 * detailed1
	 * 
	 */
	public String addDetailed(Detailed detailed){
		useDetailedDao.addDetailed(detailed);
		return "ok";
	}

	/**
	 * delDetailed()订单的删除
	 * detailedId
	 * 
	 */
	public String delDetailed(){
		int detailedId = Integer.parseInt(request.getParameter("detailedId"));
		useDetailedDao.delDetailed(detailedId);
		selDetailed();
		return "ok";
	}


	/**
	 * selDetailed()订单的查询，
	 * detailedList detailed 订单详情单的链表 ，放入session中
	 * ip  发出请求的地址
	 * orderId接受的参数，按订单号查询订单详情表，orderList.jsp发的请求，结果到detailed.jsp页面
	 * 如果ip 为空 则为detailed.jsp发的请求
	 */
	public String selDetailed(){
	  	 
		String orderIdStr = request.getParameter("orderId");	

		List<Detailed> detailedList = useDetailedDao.selDetailed(orderIdStr);
		session.setAttribute("detailedListhoutai", detailedList);

		return "ok";
	}
	/**
	 * 全部
	 * @return
	 */
	public String selAllDetailed(){
		List<Detailed> detailedList = useDetailedDao.selDetailed();
		session.setAttribute("detailedListhoutai", detailedList);

		return "ok";
	}

}
