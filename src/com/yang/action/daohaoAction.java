package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.Impl;
import com.yang.model.daohang;
import com.yang.model.jiecai;

import freemarker.ext.servlet.HttpRequestParametersHashModel;

public class daohaoAction {
	jiecai jc;
	
	public jiecai getJc() {
		return jc;
	}

	public void setJc(jiecai jc) {
		this.jc = jc;
	}

	public String select(){
		Impl ii=new Impl();
		daohang dd=new daohang();
		List<daohang> ld=ii.select();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pp", ld);
		return "daohang";
	}
}
