package com.zf.action;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.entity.util.ShopCartUtil;

public class shopOkAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session =request.getSession();
	public String setParams(){
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		int menuId=Integer.parseInt(id);
		List<ShopCartUtil> shopCartList = (List<ShopCartUtil>)session.getAttribute("shopCartList");
		for (int i = 0; i < shopCartList.size(); i++) {
			ShopCartUtil ss=shopCartList.get(i);
			if(menuId==ss.getMenuId()){
				ss.setNum(Integer.parseInt(num));
			}
		}
		return null;
	}
}
