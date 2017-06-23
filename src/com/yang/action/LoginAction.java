package com.yang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.LoginDao;
import com.yang.dao.LoginDaoImpl;
import com.yang.model.Login;
import com.yang.util.LoginUtil;

public class LoginAction {
	private LoginUtil lu;
	public LoginUtil getLu() {
		return lu;
	}

	public void setLu(LoginUtil lu) {
		this.lu = lu;
	}

	LoginDao ld=new LoginDaoImpl();
	Login ll=new Login();

	public String select(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse resp=ServletActionContext.getResponse();
		String id=req.getParameter("lu.user_id");
		String pswd=ld.list(id);
		String pwd=req.getParameter("lu.user_pwd");
		if(pswd!=null&&pwd.equals(pswd)){
			
			try {
				req.getRequestDispatcher("/houtai/index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				resp.sendRedirect("/repast/houtai/login_ht.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ow";
	}
}
