package com.caoqi.strutsaction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.caoqi.deskimg.Deskimg;
import com.caoqi.deskimg.Impl;
import com.caoqi.deskimg.dao;
import com.caoqi.deskimg.jiezhuo;

public class strutsQianImgAction {
	dao dd=new Impl();
	Deskimg dg=new Deskimg();
	jiezhuo jz;
	public jiezhuo getJz() {
		return jz;
	}
	public void setJz(jiezhuo jz) {
		this.jz = jz;
	}
	//�������ӵĲ�ѯ
	public String select(){
		List<Deskimg> ld=dd.select();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("ld", ld);
		return "pk";
	}
	//�������ӵĲ�ѯ
	public String selecd(){
		List<Deskimg> ld=dd.select1();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("ld", ld);
		return "py";
	}
	//�������ӵĲ�ѯ
	public String selecb(){
		List<Deskimg> ld=dd.select2();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("ld", ld);
		return "pm";
	}
	public String update(){
		dg.setSeatid(jz.getSeatid());
		dg.setStaticName(jz.getStaticName());
		dd.update(dg);
		List<Deskimg> ld=dd.select();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("ld", ld);
		return "po";
	}
	
}
