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
	public String save(){
		yy.setUserName(pp.getUserName());
		yy.setUserPwd(pp.getUserPwd());
		yy.setRealName(pp.getRealName());
		yy.setSex(pp.getSex());
		yy.setAge(pp.getAge());
		yy.setPhone(pp.getPhone());
		yy.setAddr(pp.getAddr());
		yy.setPostcode(pp.getPostcode());
		yy.setPower(pp.getPower());
		dd.addYuser(yy);
		List<YUser> lq=dd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ok";
	}
	public String delete(){
		HttpServletRequest resp=ServletActionContext.getRequest();
		String a=resp.getParameter("a");
		yy.setUserName(a);
		dd.delYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "oq";
	}
	public String update(){
		yy.setRealName(pp.getRealName());
		yy.setSex(pp.getSex());
		yy.setPhone(pp.getPhone());
		yy.setAddr(pp.getAddr());
		yy.setUserName(pp.getUserName());
		dd.updateYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ow";
	}
	public String select(){
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ot";
	}
}
