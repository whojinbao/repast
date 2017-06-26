package com.who.struts;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.who.getdata.DishesDao;
import com.who.util.Address;

public class PlaceOrderAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=request.getSession();
	DishesDao dd=new DishesDao();
	public String getAddress(){
		String sql1="select * from clientaddress where id=1001";
		ResultSet rs=dd.getData(sql1, null);
		List<String> addresses=new ArrayList<String>();
		try {
			while(rs.next()){
				addresses.add(rs.getString("clientid"));
				addresses.add(rs.getString("addresss"));
			}
		} catch (Exception e) {
		}
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(addresses);
		} catch (Exception e) {
		}
		return null;
		
	}
	public String saveAddress(){
		String str=request.getParameter("ads");
		String sql="insert into clientaddress(id,addresss) values(1001,'"+str+"')";
		dd.updateData(sql, null);
		return null;
	}
	
	
}
