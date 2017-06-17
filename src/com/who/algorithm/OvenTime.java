package com.who.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.who.getdata.DishesDao;
import com.who.getdata.Dishesing;
import com.who.hearth.HearthDao;


public class OvenTime {
	private DishesDao dd=new DishesDao();
	/*
	 * 正在炒菜品，同锅的数据读取到一起
	 */
	private List<Dishesing> sortDishesing(){
		List<Dishesing> dList=dd.getDishesing();
		for (int i = 0; i < dList.size()-1; i++) {
			Dishesing ds=dList.get(i);
			int count=0;
			for (int j = 0; j < ds.getDetailednum().size(); j++) {
				count +=ds.getDetailednum().get(j);
			}
			if(count==ds.getMaxNum()){
				continue;
			}
			for (int j = i+1; j < dList.size(); j++) {
				Dishesing ds1=dList.get(j);
				Date d1=ds.getStartTime();
				Date d2=ds1.getStartTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s1=sdf.format(d1);
				String s2=sdf.format(d2);
				if (ds.getMenuName().equals(ds1.getMenuName())&&s1.equals(s2)&&(count+ds1.getDetailednum().get(0)<=ds.getMaxNum())) {
				
					ds.setSeatId(ds1.getSeatId().get(0));
					ds.setDetailednum(ds1.getDetailednum().get(0));
					dList.remove(j);
					j--;
				}
			}
		}
		return dList;
	}
	/*
	 * 正在炒菜的数据获取
	 * Action调用此方法获取数据
	 * 
	 */
	
	public List<Dishesing> getOveningTime(){
		List<Dishesing> dishesList=sortDishesing();
		for (int i = 0; i < dishesList.size(); i++) {
			Dishesing dishesing=dishesList.get(i);
			Date d2=dishesing.getStartTime();
			Date d1=new Date();
			int onTime=(int)(d1.getTime()-d2.getTime())/(60*1000);
			int doTime=dishesing.getDoTime();
			int EWT=doTime-onTime;
			if(EWT<0){EWT=0;}
			dishesing.setEWT(EWT);
		}
		for (int i = 1; i < dishesList.size(); i++) {
			for (int j = 0; j < dishesList.size()-i; j++) {
				Dishesing d1=dishesList.get(j);
				Dishesing d2=dishesList.get(j+1);
				if(d1.getEWT()>d2.getEWT()){
					Dishesing d3=d1;
					dishesList.set(j, d2);
					dishesList.set(j+1, d3);
				}
			}
		}
		return dishesList;
	}
	/*
	 * 控制可以炒菜的数量
	 */
	public int OvenDishes(){
		List<Dishesing> dishesList=sortDishesing();
		 HearthDao hh=new HearthDao();
		 int num=hh.getHearth();
		 if(num>dishesList.size()){
			 return 1;
		 }
		 return -1;
	}
}
