package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.AuthDao;
import com.yang.dao.AuthDaoImpl;
import com.yang.model.Auth;
import com.yang.model.YUser;
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
	public String save(){
		at.setAuthId(aut.getAuthId());
		at.setAuthName(aut.getAuthName());
		at.setAuthPath(aut.getAuthPath());
		at.setParentId(aut.getParentId());
		at.setAuthDescription(aut.getAuthDescription());
		ad.addAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sa";		
	}
	public String delete(){
		HttpServletRequest resp=ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		at.setAuthId(a);
		ad.deleteAuth(at);
		List<Auth>lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv",lv);
		return "sx";
	}
	public String update(){
		at.setAuthName(aut.getAuthName());
		at.setAuthPath(aut.getAuthPath());
		at.setParentId(aut.getParentId());
		at.setAuthDescription(aut.getAuthDescription());
		at.setAuthId(aut.getAuthId());
		ad.updateAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sd";
	}
	public String select(){
		
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
	
		return "sw";
	}
}
