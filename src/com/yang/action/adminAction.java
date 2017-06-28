package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.adminDao;
import com.yang.model.admin;
import com.yang.util.adminUtil;

public class adminAction {
	private adminUtil adu;

	public adminUtil getAdu() {
		return adu;
	}

	public void setAdu(adminUtil adu) {
		this.adu = adu;
	}
	adminDao ad=new adminDao();
	admin aa=new admin();
	public String add(){
		aa.setUser_id(adu.getUser_id());
		aa.setUser_pwd(adu.getUser_pwd());
		ad.add(aa);
		List<admin>list=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("list", list);
		return "ok";
	}
	public String  update(){
		aa.setUser_pwd(adu.getUser_pwd());
		aa.setUser_id(adu.getUser_id());
		ad.update(aa);
		List<admin>list=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "oq";
		
	}
	public String select(){
		List<admin>list=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "ob";
	}
}
