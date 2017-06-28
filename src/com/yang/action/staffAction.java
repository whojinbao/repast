package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.dao;
import com.yang.dao.daoImpl;
import com.yang.model.YUser;
import com.yang.model.peihe;

public class staffAction {
	private peihe pp;
	
	public peihe getPp() {
		return pp;
	}

	public void setPp(peihe pp) {
		this.pp = pp;
	}

	dao dd=new daoImpl();
	YUser yy=new YUser();
	/**
	 * ���ø�����������ӷ������ѵõ������ݴ��뵽session�У����ұ����ֳ�
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String save(){
		yy.setUser_id(pp.getUser_id());
		yy.setUser_name(pp.getUser_name());
		yy.setUser_pwd(pp.getUser_pwd());
		yy.setUser_sex(pp.getUser_sex());
		yy.setUser_phone(pp.getUser_phone());
		yy.setUser_age(pp.getUser_age());
		yy.setUser_add(pp.getUser_add());
		yy.setUser_power(pp.getUser_power());
		dd.addYuser(yy);
		List<YUser> lq=dd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ok";
	}
	/**
	 * ���ø��������ɾ��������һ�����������洢ɾ������ֵ
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String delete(){
		HttpServletRequest resp=ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		yy.setUser_id(a);
		dd.delYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "oq";
	}
	/**
	 * �������ݣ�ѡ����Ҫ���µĶ��󣬲��ҵ���select ������ֵ����session��
	 * ����ֵresult��struts������·��
	 * @return
	 */
	public String update(){
		/*yy.setRealName(pp.getRealName());
		yy.setSex(pp.getSex());
		yy.setPhone(pp.getPhone());
		yy.setAddr(pp.getAddr());
		yy.setUserName(pp.getUserName());*/
		yy.setUser_name(pp.getUser_name());
		yy.setUser_pwd(pp.getUser_pwd());
		yy.setUser_sex(pp.getUser_sex());
		yy.setUser_phone(pp.getUser_phone());
		yy.setUser_age(pp.getUser_age());
		yy.setUser_add(pp.getUser_add());
		yy.setUser_power(pp.getUser_power());
		yy.setUser_id(pp.getUser_id());
		dd.updateYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ow";
	}
	/**
	 * ��ѯ���е����ݣ������session�У�����ͨ��������ʾ��ҳ����
	 * @return
	 */
	public String select(){
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ot";
	}
}
