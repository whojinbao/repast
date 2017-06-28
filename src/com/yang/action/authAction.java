package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.yang.dao.AuthDao;
import com.yang.dao.AuthDaoImpl;
import com.yang.model.Auth;
import com.yang.util.authUtil;
public class authAction {
	private authUtil aut;
	public authUtil getAut() {
		return aut;
	}
	public void setAut(authUtil aut) {
		this.aut = aut;
	}
	AuthDao ad=new AuthDaoImpl();
	Auth at=new Auth();
	/**
	 * ���ø�����������ӷ������ѵõ������ݴ��뵽session�У����ұ����ֳ�
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String save(){
		at.setAuth_id(aut.getAuth_id());
		at.setAuth_name(aut.getAuth_name());
		at.setAuth_info(aut.getAuth_info());
		ad.addAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sa";		
	}
	/**
	 * ���ø��������ɾ��������һ�����������洢ɾ������ֵ
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String delete(){
		
		HttpServletRequest resp=ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		at.setAuth_id(a);
		ad.deleteAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv",lv);
		return "sx";
	}
	/**
	 * �������ݣ�ѡ����Ҫ���µĶ��󣬲��ҵ���select ������ֵ����session��
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String update(){
		at.setAuth_name(aut.getAuth_name());
		at.setAuth_info(aut.getAuth_info());
		at.setAuth_id(aut.getAuth_id());
		ad.updateAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sd";
	}
	/**
	 * ��ѯ���е�����
	 * @return
	 */
	public String select(){
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sw";
	}
}
