package com.yang.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.publics.dao.DaoFactory;
import com.yang.model.Login;
public class Role_authImpl {
	Login la;
	public Login getLa() {
		return la;
	}
	public void setLa(Login la) {
		this.la = la;
	}
	/*
	 * 根据员工的编号查询对应的角色；
	 */
	public String select(String name){
		String sql="select user_power from employee where user_id=?";
		Object[]ob=new Object[]{name};
		ResultSet rs=DaoFactory.executeQuery(sql, ob);
		HttpServletRequest req=ServletActionContext.getRequest();
		String pd=null;
		try {
			while(rs.next()){
			pd=rs.getString(1);}
			//System.out.println(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pd;
	}
}
