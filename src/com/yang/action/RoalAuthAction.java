package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.RoleAuthDao;
import com.yang.model.Role_Auth;
import com.yang.model.YUser;
import com.yang.util.RoleauthUtil;
public class RoalAuthAction {
	private RoleauthUtil rlu;
	public RoleauthUtil getRlu() {
		return rlu;
	}

	public void setRlu(RoleauthUtil rlu) {
		this.rlu = rlu;
	}
	RoleAuthDao rd=new RoleAuthDao();
	public String update(){
		rd.update(rlu);
		select();
		return "rr";
	}
	public String select(){
		List<Role_Auth> lq=rd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "rw";
	}
}
