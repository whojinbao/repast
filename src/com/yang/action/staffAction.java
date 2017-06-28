package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.Request;
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
		yy.setUser_sex(pp.getUser_sex());
		yy.setUser_age(pp.getUser_age());
		yy.setUser_addr(pp.getUser_addr());
		yy.setUser_power(pp.getUser_power());
		yy.setUser_pwd(pp.getUser_pwd());
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
		yy.setUser_age(pp.getUser_age());
		yy.setUser_addr(pp.getUser_addr());
		yy.setUser_pwd(pp.getUser_pwd());
		yy.setUser_id(pp.getUser_id());
		dd.updateYUser(yy);
		select();
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
	/**
	 * ģ����ѯ�������ֽ���
	 * @return
	 */
	public String select1(){
		yy.setUser_name(pp.getUser_name());
		List<YUser> lq=dd.select1(yy);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "mohu";
	}
}
