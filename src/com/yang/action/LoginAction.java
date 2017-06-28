package com.yang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.LoginDao;
import com.yang.dao.LoginDaoImpl;
import com.yang.dao.Role_authImpl;
import com.yang.model.Login;

public class LoginAction {
	Login la;
	public Login getLa() {
		return la;
	}
	public void setLa(Login la) {
		this.la = la;
	}
	Role_authImpl ri=new Role_authImpl();
	LoginDao rt=new LoginDaoImpl();
	public String select(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse resp=ServletActionContext.getResponse();
		String id=req.getParameter("la.user_id");
		String pswd=rt.list(id);
		String pwd=req.getParameter("la.user_pwd");
		String role=null;
		if(pswd!=null&&pwd.equals(pswd)){
			role=ri.select(id);
			int role1=Integer.parseInt(role);
			if(role1==1){
				return "p1";
			}else if(role1==2){
				return "p2";
			}
			else if(role1==3){
				return "p3";
			}
			else if(role1==4){
				return "p4";
			}
			else{
				return "success";
			}
		}else{
			return "error";
		}
	}
}
