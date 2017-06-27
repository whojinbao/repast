package com.who.struts;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.who.algorithm.GetOven;
import com.who.algorithm.Sort1;
import com.who.algorithm.Sort2;
import com.who.algorithm.sortOthers;
import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;
import com.who.getdata.Ovening;
import com.who.getdata.Total;
import com.who.hearth.HearthDao;
import com.who.util.SeatIDTime;
import com.who.util.TotalUtil;

public class ArrangeAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	DishesDao dd=new DishesDao();
	
	/*
	 * 根据桌台号找最近的等待时间
	 */
	public List<TotalUtil> getMinTime(List<TotalUtil> tt,List<Dishes> ds,List<Ovening> dg){
		
		List<SeatIDTime> ll=new ArrayList<SeatIDTime>();
		for (int i = 0; i < tt.size(); i++) {
			SeatIDTime ss=new SeatIDTime();
			ss.setId(tt.get(i).getSeatId());
			ll.add(ss);
		}
		for (int i = 0; i < dg.size(); i++) {
			Ovening ding=dg.get(i);
			for (int j = 0; j < ding.getSeatId().length; j++) {
				for (int k = 0; k < ll.size(); k++) {
					String a=ll.get(k).getId();
					String b=ding.getSeatId()[j];
					if(a.equals(b)){
						int aInt=ll.get(k).getTime();
						int bInt=ding.getEWT();
						if(aInt==-1){
							ll.get(k).setTime(bInt);
						}else{
							if(aInt>bInt){
								ll.get(k).setTime(bInt);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < ds.size(); i++) {
			Dishes ding=ds.get(i);
			for (int j = 0; j < ding.getSeatId().size(); j++) {
				for (int k = 0; k < ll.size(); k++) {
					String a=ll.get(k).getId();
					String b=ding.getSeatId().get(j);
					if(a.equals(b)){
						int aInt=ll.get(k).getTime();
						int bInt=ding.getWaiting();
						if(aInt==-1){
							ll.get(k).setTime(bInt);
						}else{
							if(aInt>bInt){
								ll.get(k).setTime(bInt);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < tt.size(); i++) {
			TotalUtil taTotal=tt.get(i);
			for (int j = 0; j < ll.size(); j++) {
				if(taTotal.getSeatId()==ll.get(j).getId()){
					Date data=new Date();
					long bb=ll.get(j).getTime();
					if(bb<0){bb=1;}
					long aa=data.getTime()+(bb*60000);
					Date date=new Date(aa);
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:00");
					String time=sdf.format(date);
					taTotal.setWaitTime(time);
					
				}
			}
			
			
		}
		return tt;
	}
	
	
	
	/*
	 * 界面总数据获取
	 */
	public String show(){
		sortOthers cc=new sortOthers();
		HearthDao hh=new HearthDao();
		int hearth=hh.getHearth();
		List<Total> ll=dd.getTotals();
		List<TotalUtil> llist=new ArrayList<TotalUtil>();
		for (int i = 0; i < ll.size(); i++) {
			Total tt=ll.get(i);
			String seatId=tt.getSeatId();
			int countNum =tt.getCountNum();
			int have = tt.getHave();
			Date lastTime = tt.getLastTime();
			TotalUtil tu=new TotalUtil();
			tu.setCountNum(countNum);
			tu.setHave(have);
			tu.setLastTime(lastTime);
			tu.setSeatId(seatId);
			llist.add(tu);
		}
		GetOven oo=new GetOven();
		List<Ovening> dishesingList=oo.getOveningTime();
		List<Dishes> dishesList=null;
		String sql="select id from hearth";
		ResultSet rs=dd.getData(sql, null);
		int flag=1;
		try {
			rs.next();
			flag=rs.getInt("id");
		} catch (Exception e) {
		}
		if(flag==1){
			Sort1 ss=new Sort1();
			dishesList=ss.outPuttimes();
			session.setAttribute("sortColor1", "1");
			session.setAttribute("sortColor2", "2");
		}else{
			Sort2 ss=new Sort2();
			dishesList=ss.outPuttimes();
			session.setAttribute("sortColor1", "2");
			session.setAttribute("sortColor2", "1");
		}
		List<TotalUtil> ttlist=getMinTime(llist,dishesList,dishesingList);
		List<Dishes> cool=cc.getLiang();
		List<Dishes> othes=cc.getOthes();
		session.setAttribute("cool", cool);
		session.setAttribute("othes", othes);
		session.setAttribute("total", ttlist);
		session.setAttribute("dishes", dishesList);
		session.setAttribute("dishesing", dishesingList);
		session.setAttribute("hearth", hearth);
		session.setAttribute("hearthNum", hearth-dishesingList.size());
		session.setAttribute("hearthxiugai", "hearthxiugai_hidden");
		session.setAttribute("updateDsihes_error", "updateDsihes_error_hidden");
		return "arrange";
	}
	
	/*
	 * 上菜按钮实现
	 */
	public String updateStatus(){
		String menuId=request.getParameter("menuId");
		String [] detailedId=request.getParameterValues("detailedId");
		String [] detailednum=request.getParameterValues("detailednum");
		dd.updateOven(menuId, detailedId);
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		String sql2="select ovening from detailed where menuId="+menuId+" and detailedId=?";
		for (int i = 0; i < detailedId.length; i++) {
			String sql="update detailed set dishesStatus='2',outTime='"+time+"',ovening=? where menuId='"+menuId+"' and detailedId=?";
			String de=detailedId[i];
			Object params[]={de};
			ResultSet rs1=dd.getData(sql2,params);
			int d=0;
			try {
				if(rs1.next()){
					d=rs1.getInt("ovening");
				}
			} catch (Exception e){}
			d=d-Integer.parseInt(detailednum[i]);
			Object params1[]={d,de};
			dd.updateData(sql, params1);
		}
		
		show();
		return "updateStatus";
	}
	/*
	 * 烹饪按钮功能实现
	 */
	public String updateData(){
		GetOven oo=new GetOven();
		List<Ovening> dishesingList=oo.getOveningTime();
		int flag=dishesingList.size();
		HearthDao hh=new HearthDao();
		int hearth=hh.getHearth();
		if(flag==hearth){
			show();
			session.setAttribute("updateDsihes_error", "updateDsihes_error_show");
		}else{
			String menuId=request.getParameter("menuId");
			String [] dishesNum=request.getParameterValues("dishesNum");
			String [] detailedId=request.getParameterValues("detailedId");
			String [] seatId=request.getParameterValues("seatId");
			dd.setOven(detailedId, menuId, seatId, dishesNum);
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=sdf.format(date);
			String sql="select ovenSum from detailed where menuId="+menuId+" and detailedId=?";
			String sql2="select ovening from detailed where menuId="+menuId+" and detailedId=?";
			for (int i = 0; i < detailedId.length; i++){
				int c=Integer.parseInt(dishesNum[i]);
				Object params[]={detailedId[i]};
				ResultSet rs=dd.getData(sql, params);
				ResultSet rs1=dd.getData(sql2, params);
				int a=0;int d=0;
				try {
					if(rs.next()){
						a=rs.getInt("ovenSum");
					}
					if(rs1.next()){
						d=rs1.getInt("ovening");
					}
				} catch (Exception e) {}
				int b=a+c;
				int e=Integer.parseInt(dishesNum[i]);
				d+=e;
				String sql1="update detailed set ovenSum="+b+",dishesStatus=1,ovening="+d+",startTime='"+time+"' where menuId="+menuId+" and detailedId="+detailedId[i];
				dd.updateData(sql1, null);
			}
			show();
		}
		return "updateStatus";
	}
	/*
	 * 灶台数量
	 */
	private String hearthNum;
	public String getHearthNum() {
		return hearthNum;
	}
	public void setHearthNum(String hearthNum) {
		this.hearthNum = hearthNum;
	}
	/*
	 * 控制灶台数量修改
	 */
	public String updateHearth(){
		int num=Integer.parseInt(hearthNum);
		GetOven oo=new GetOven();
		List<Ovening> dishesingList=oo.getOveningTime();
		int flag=dishesingList.size();
		if(num<flag){
			show();
			session.setAttribute("hearthxiugai", "hearthxiugai_show");
		}else{
			String sql="update hearth set num="+num;
			dd.updateData(sql, null);
			show();
		}
		return "updateStatus";
	}
	/*
	 *凉菜和非炒菜进行上菜
	 */
	public String setOthes(){
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		String menuId=request.getParameter("menuId");
		String [] detailedId=request.getParameterValues("detailedId");
		String [] detailednum=request.getParameterValues("detailednum");
		String sql2="select ovening from detailed where menuId="+menuId+" and detailedId=?";
		for (int i = 0; i < detailedId.length; i++) {
			String sql="update detailed set dishesStatus='2',outTime='"+time+"',ovenSum=? where menuId='"+menuId+"' and detailedId=?";
			String de=detailedId[i];
			Object params[]={de};
			ResultSet rs1=dd.getData(sql2,params);
			int d=0;
			try {
				if(rs1.next()){
					d=rs1.getInt("ovening");
				}
			} catch (Exception e){}
			d=d+Integer.parseInt(detailednum[i]);
			Object params1[]={d,de};
			dd.updateData(sql, params1);
		}
		show();
		return "updateStatus";
	}
	/*
	 * 更换排序；
	 */
	public String updateSort(){
		String sortid=request.getParameter("sortid");
		String sql="update hearth set id="+sortid;
		dd.updateData(sql, null);
		show();
		return "updateStatus";
	}
	
}