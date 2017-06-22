package com.who.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.who.getdata.DishesDao;
import com.who.getdata.Dishesing;
import com.who.getdata.Ovening;
import com.who.hearth.HearthDao;


public class GetOven {
	private DishesDao dd=new DishesDao();
	
	/*
	 * 正在炒菜的数据获取
	 * Action调用此方法获取数据
	 * 
	 */
	
	public List<Ovening> getOveningTime(){
		List<Ovening> dishesList=dd.getOvening();
		for (int i = 0; i < dishesList.size(); i++) {
			Ovening ovening=dishesList.get(i);
			String d=ovening.getStartTime();
			Date d1=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d2 = null;
			try {
				d2 = sdf.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int onTime=(int)(d1.getTime()-d2.getTime());
			int doTime=ovening.getDoTime();
			int EWT=((doTime)*60000)-onTime;
			if(EWT<0){EWT=0;}
			ovening.setEWT(EWT);
		}
		
		return dishesList;
	}
	
}
