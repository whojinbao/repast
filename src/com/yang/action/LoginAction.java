package com.yang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.LoginDao;
import com.yang.dao.LoginDaoImpl;
import com.yang.model.Login;
import com.yang.util.LoginUtil;

public class LoginAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=request.getSession();
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
		String id=request.getParameter("lu.user_id");
		List<String> ll=ld.list(id);
		String pwd=request.getParameter("lu.user_pwd");
		if(ll.get(0)!=null&&pwd.equals(ll.get(0))){
			session.setAttribute("username", ll.get(1));
			session.setAttribute("role_name", ll.get(2));
			try {
				request.getRequestDispatcher("/houtai/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.sendRedirect("/repast/houtai/login_ht.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ow";
	}
}
