package com.who.algorithm;

import java.text.ParseException;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;

public class Test {
	
	public static void main(String[] args) throws ParseException {
		Sort1 ss=new Sort1();
		List<Dishes> ll=ss.outPuttimes();
		for (int i = 0; i < ll.size(); i++) {
			Dishes d=ll.get(i);
			System.out.println(d.getSeatId()+";"+d.getWaiting());
		}
	}
}
