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
	 * ���ø������ӵ�id������״̬
	 * ��ɨ,����,��̨
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
	 * ��ѯ��������ʾ�ڷ���Աҳ��
	 */
	public String select(){
		List<waiter> lw=dd.select();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "img";
	}
	/*
	 * �������ӵ���������������״̬��ѯ����
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
	 * ��ѯ��������ʾ�ڷ���Ա�еĴ���ҳ��
	 */
	public String select3(){
		List<waiter> lw=dd.selectRoom();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "dating";
	}
	/*
	 * ��ѯ��������ʾ�ڷ���Ա�еİ���ҳ��
	 */
	public String select4(){
		List<waiter> lw=dd.selectBox();
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("pl",lw);
		return "baoxiang";
	}
	
}
