package com.who;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.who.getdata.DishesDao;
import com.who.getdata.Ovening;
import com.who.util.OthesDishes;

public class Test {
	
	public static void main(String[] args){
		DishesDao dd=new DishesDao();
		List<OthesDishes> dishes=dd.getOthes();
		for (int i = 0; i < dishes.size(); i++) {
			OthesDishes o=dishes.get(i);
			System.out.println(o.getDetailedId()+";"+o.getDetailednum()+";"+o.getMenuId()+";"+o.getMenuName()+";"+o.getSeatId());
		}
	}

}
