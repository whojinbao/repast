package com.yang.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.yang.model.QT;
import com.yang.util.QTUtil;

public class QTAction {
	private QTUtil qtu;

	public QTUtil getQtu() {
		return qtu;
	}

	public void setQtu(QTUtil qtu) {
		this.qtu = qtu;
	}
	
	QTLogin ld=new QTdao();
	QT ll=new QT();
	
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
		return "ow1";
	}
	
}
