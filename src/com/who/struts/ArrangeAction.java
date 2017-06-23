package com.who.struts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.who.algorithm.OvenTime;
import com.who.algorithm.Sort1;
import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;
import com.who.getdata.Dishesing;
import com.who.getdata.Total;
import com.who.util.TotalUtil;

public class ArrangeAction {  
	public String show(){
		DishesDao dd=new DishesDao();
		List<Total> ll=dd.getTotals();
		List<TotalUtil> llist=new ArrayList<TotalUtil>();
		for (int i = 0; i < ll.size(); i++) {
			Total tt=ll.get(i);
			String seatId=tt.getSeatId();
			int countNum =tt.getCountNum();
			int have = tt.getHave();
			Date lastTime = tt.getLastTime();
			int waitTime =tt.getWaitTime();
			TotalUtil tu=new TotalUtil();
			tu.setCountNum(countNum);
			tu.setHave(have);
			tu.setLastTime(lastTime);
			tu.setSeatId(seatId);
			tu.setWaitTime(waitTime);
			llist.add(tu);
			
		}
		OvenTime oo=new OvenTime();
		List<Dishesing> dishesingList=oo.getOveningTime();
		Sort1 ss=new Sort1();
		List<Dishes> dishesList=ss.outPuttimes();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("total", llist);
		session.setAttribute("dishes", dishesList);
		session.setAttribute("dishesing", dishesingList);
		return "arrange";
	}
}
