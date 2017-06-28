package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.role_dao;
import com.yang.dao.role_daoImpl;
import com.yang.model.Role;
import com.yang.util.roleUtil;

public class roleAction {
	private roleUtil ru;

	public roleUtil getRu() {
		return ru;
	}

	public void setRu(roleUtil ru) {
		this.ru = ru;
	}
	role_dao rd=new role_daoImpl();
	Role rr=new Role();
	/**
	 * ��ɫ������
	 * @return
	 */
	public String save(){
		rr.setRole_id(ru.getRole_id());
		rr.setRole_name(ru.getRole_name());
		List<Role> list=rd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "rq";
	}
	/**
	 * ��ɫ��ɾ��
	 * @return
	 */
	public String delete(){
		HttpServletRequest req=ServletActionContext.getRequest();
		int a=Integer.parseInt(req.getParameter("a"));
		rr.setRole_id(a);
		rd.deleteRole(rr);
		List<Role> list=rd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "rw";
	}
	/**
	 * ��ɫ�ĸ���
	 * @return
	 */
	public String update(){
		System.out.println("��ѯ");
		rr.setRole_name(ru.getRole_name());
		rr.setRole_id(ru.getRole_id());
		List<Role> list=rd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "re";
	}
	public String select(){
		List<Role> list=rd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "rr";
	}
	
}
