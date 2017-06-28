package com.who.struts;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.who.getdata.DishesDao;

public class qtloginAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=request.getSession();
	private String phone;
	private String name;
	private String password;
	DishesDao dd=new DishesDao();
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login(){
		String sql="insert into qiantai (name,phone,psw) values(?,?,?)";
		Object params[]={name,phone,password};
		dd.updateData(sql, params);
		System.out.println(name+";"+phone+";"+password);
		return "ok";
	}
	public String logindenglu(){
		String sql="select * from qiantai";
		ResultSet rs=dd.getData(sql, null);
		try {
			if(rs.next()&&rs.getString("psw").equals(password)){
				session.setAttribute("mimacuowu", "1");
				session.setAttribute("username", rs.getString("name"));
			}else{
				session.setAttribute("mimacuowu", "2");
			}
		} catch (Exception e) {
		}

		return "no";
	}
	public String jiaoyan(){
		String phone=request.getParameter("name");
		System.out.println(phone);
		String sql="select * from qiantai where phone='"+phone+"'";
		ResultSet rs=dd.getData(sql, null);
		try {
			if(rs.next()){
				response.getWriter().print(true);
			}else{
				response.getWriter().print(false);
			}
		} catch (Exception e) {}
		return null;
	}
	
	public String selectzhuohao(){
		
		
		
		return "ok";
	}
	public String selectzhuozi(){
		String sql="select * from zhuo where seatStatusId =3";
		ResultSet rs=dd.getData(sql, null);		
		List<String> ll=new ArrayList<String>();
		try {
			while (rs.next()) {
				ll.add(rs.getString("seatid"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			response.getWriter().print(ll);
		} catch (Exception e) {
		}
		return null;
	}
	
	public String zhuoyixuanze(){
		String zhuo=request.getParameter("sselectseat");
		String sql="update zhuo set seatStatusId=1 where seatid="+zhuo;
		dd.updateData(sql, null);
		String sql1="select * from zhuo where seatid="+zhuo;
		ResultSet rs=dd.getData(sql1, null);
		session.setAttribute("zhuo", zhuo);
		session.setAttribute("who_qiantai", "qtlogin_selectzhuohao.action");
		try {
			rs.next();
			String staffid=rs.getString("staffId");
			session.setAttribute("staffid", staffid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.setAttribute("who_select1", "1");
		session.setAttribute("who_select2", "1");
		return "no";
	}
	
}
