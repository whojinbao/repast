package com.zf.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseDetailedDao;
import com.zf.entity.Detailed;


/**
 *     �� ��������� ����ɾ�Ĳ�Ĳ��� Detailed
 *     ����ҳ�� ����ҳ��������ݣ�.jsp�������ӵ����ݿ�
 *     ����dao���̣��������ݿ�
 *     ��������
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
	 * addDetailed()����������
	 * detailed1
	 * 
	 */
	public String addDetailed(Detailed detailed){
		System.out.println(detailed.getMenuId());
		useDetailedDao.addDetailed(detailed);
		/*selDetailed();  //ˢ��
*/		return "ok";
	}

	/**
	 * delDetailed()������ɾ��
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
	 * selDetailed()�����Ĳ�ѯ��
	 * detailedList detailed �������鵥������ ������session��
	 * ip  ��������ĵ�ַ
	 * orderId���ܵĲ������������Ų�ѯ�����������orderList.jsp�������󣬽����detailed.jspҳ��
	 * ���ip Ϊ�� ��Ϊdetailed.jsp��������
	 */
	public String selDetailed(){

		System.out.println("sel"); 	  		  	 
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		System.out.println(orderId);
		List<Detailed> detailedList = useDetailedDao.selDetailed(orderId);
		session.setAttribute("detailedList", detailedList);

		return "ok";
	}

}