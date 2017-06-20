package com.caoqi_strutsaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.caoqi_zhuo.Impl;
import com.caoqi_zhuo.dao;
import com.caoqi_zhuo.peihe;
import com.caoqi_zhuo.zhuo;

public class strutsAction {
	private peihe pp;//这是从表单里接受数据的类
	dao dd=new Impl();
	zhuo zz=new zhuo();
	/*
	 * 大厅桌子的增加
	 */
	public String add(){
		zz.setSeatid(pp.getSeatid());
		zz.setMaxPerson(pp.getMaxPerson());
		zz.setSeatStatus(pp.getSeatStatus());
		zz.setStaffId(pp.getStaffId());
		zz.setImgid(pp.getImgid());
		zz.setRid(pp.getRid());
		dd.addZhuo(zz);	
		List<zhuo> lz=dd.select1();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lz", lz);
		return "ok";
	}
	/*
	 * 大厅桌子的删除
	 */
	public String delete(){
		HttpServletRequest resp= ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		zz.setSeatid(a);
		dd.delete(zz);
		List<zhuo> lz=dd.select1();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lz", lz);
		return "oq";
	}
	/*
	 * 大厅桌子的更新
	 */
	public String update(){
		zz.setSeatStatus(pp.getSeatStatus());
		zz.setSeatid(pp.getSeatid());
		dd.update(zz);
		List<zhuo> lz=dd.select1();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lz", lz);
		return "ow";
	}
	/*
	 * 大厅桌子的查询
	 */
	public String select(){
		List<zhuo> lz=dd.select1();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lz", lz);	
		return "ot";
	}
	public peihe getPp() {
		return pp;
	}
	public void setPp(peihe pp) {
		this.pp = pp;
	}
}
