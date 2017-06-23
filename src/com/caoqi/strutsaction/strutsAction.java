package com.caoqi.strutsaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.caoqi.zhuo.Impl;
import com.caoqi.zhuo.dao;
import com.caoqi.zhuo.peihe;
import com.caoqi.zhuo.zhuo;

public class strutsAction {
	private peihe pp;//���Ǵӱ���������ݵ���
	dao dd=new Impl();
	zhuo zz=new zhuo();
	/*
	 * ���ӵ�����
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
	 * ���ӵ�ɾ��
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
	 * ���ӵĸ���
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
	 * ���ӵĲ�ѯ
	 */
	public String select1(){
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
