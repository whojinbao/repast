package com.caoqi.strutsaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.caoqi.order.ImplOrder;
import com.caoqi.order.order;
import com.caoqi.order.peiOrder;

public class OrderAction {
	order od=new order();
	ImplOrder io=new ImplOrder();
	peiOrder po;
	public peiOrder getPo() {
		return po;
	}

	public void setPo(peiOrder po) {
		this.po = po;
	}
//��Ѯ����
	public String selectOrder(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String str = (String) req.getParameter("name");
		List<order> lo=io.select(str);//�������	
		if(lo.size()!=0){
			//����鵽�Ķ������ѯÿ�������еĲ�Ʒ�Լ�ÿ����Ʒ�ļ�Ǯ		
		String pj=io.ovenSum(lo.get(0).getId());
		List<order> pk=io.select2(lo.get(0).getId());
		HttpSession se=ServletActionContext.getRequest().getSession();
		se.setAttribute("mb", pj);
		se.setAttribute("mn",lo);
		se.setAttribute("mm", pk);
		return "order";
		}else{
			HttpSession se=ServletActionContext.getRequest().getSession();
			se.invalidate();
		}
		return null;
		}
}
