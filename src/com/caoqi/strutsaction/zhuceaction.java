package com.caoqi.strutsaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.caoqi.zhuce.Impl;
import com.caoqi.zhuce.dao;
import com.caoqi.zhuce.jieShou;
import com.caoqi.zhuce.zhuce;

public class zhuceaction {
	zhuce zc=new zhuce();
	dao dd=new Impl();
	jieShou js;
	public jieShou getJs() {
		return js;
	}
	public void setJs(jieShou js) {
		this.js = js;
	}
	public String add(){
		zc.setId(js.getId());
		zc.setName(js.getName());
		zc.setPwd(js.getPwd());
		zc.setTel(js.getTel());
		zc.setIdcard(js.getIdcard());
		dd.add(zc);
		return "zhuce";
	}
	public String select(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		zc.setId(js.getId());
		String pswd=dd.list(zc);
		String pwd=request.getParameter("js.pwd");
		if(pswd!=null&&pwd.equals(pswd)){
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
		}else{
			
			try {
				response.sendRedirect("/qiantai/qiantaizhuce/zhuce.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		System.out.println("sell");
		return "sell1";
	}
}
