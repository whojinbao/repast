package com.caoqi.strutsaction;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.caoqi.waiter.Impl;
import com.caoqi.waiter.dao;
import com.caoqi.waiter.peihe;
import com.caoqi.waiter.waiter;

public class waiterAction {
	waiter ww=new waiter();
	dao dd=new Impl();
	peihe pp;
	
	public peihe getPp() {
		return pp;
	}

	public void setPp(peihe pp) {
		this.pp = pp;
	}
	/*
	 * 调用根据桌子的id改桌子状态
	 * 清扫,结账,开台
	 */
	public String updateStatus(){
		ww.setSeatid(pp.getSeatid());
		ww.setSeatStatusId(pp.getSeatStatusId());
		ww.setOrderStatus(pp.getOrderStatus());
		dd.update(ww);
		dd.update1(ww);
		List<waiter> lw=dd.orderSeat();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		select();
		return "status";
	}
	/*
	 * 查询的桌子显示在服务员页面
	 */
	public String select(){
		List<waiter> lw=dd.select();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "img";
	}
	/*
	 * 根据桌子的所座人数和桌子状态查询桌子
	 */
	public String select1(){
		ww.setMaxPerson(pp.getMaxPerson());
		ww.setStatusName(pp.getStatusName());
		List<waiter> lw=dd.select1(ww);
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "hh";
	}
	/*
	 * 查询的桌子显示在服务员中的大厅页面
	 */
	public String select3(){
		List<waiter> lw=dd.selectRoom();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "dating";
	}
	/*
	 * 查询的桌子显示在服务员中的包厢页面
	 */
	public String select4(){
		List<waiter> lw=dd.selectBox();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "baoxiang";
	}
	
}
