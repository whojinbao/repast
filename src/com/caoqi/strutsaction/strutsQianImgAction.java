package com.caoqi.strutsaction;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.caoqi.deskimg.Deskimg;
import com.caoqi.deskimg.Impl;
import com.caoqi.deskimg.dao;
import com.caoqi.deskimg.jiezhuo;
import com.who.getdata.DishesDao;

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
	/*
	 *��̨������,��̨���ӵĸ���
	 */
	public String update(){
		HttpSession se=ServletActionContext.getRequest().getSession();
		dg.setSeatid(jz.getSeatid());
		dg.setStaticName(jz.getStaticName());
		String sql="select staffId from zhuo where  zhuo.seatid="+jz.getSeatid();
		DishesDao dd1=new DishesDao();
		ResultSet rs=dd1.getData(sql, null);
		try {
			rs.next();
			String staffid=rs.getString("staffId");
			se.setAttribute("staffId", staffid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dd.update(dg);
		List<Deskimg> ld=dd.select();
		se.setAttribute("seatId", jz.getSeatid());
		se.setAttribute("ld", ld);
		return "po";
	}	
	/*
	 * �������ӱ��id������״̬���name��ѯ��
	 */
	public String select3(){
		dg.setMaxPerson(jz.getMaxPerson());
		dg.setStaticName(jz.getStaticName());
		
		List<Deskimg> ld=dd.select3(dg);
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("ld", ld);
		
		return "mk";
	}	
}
