package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;

public class sortOthers {
	DishesDao dd=new DishesDao();
	Combine cc=new Combine();
	public List<Dishes> getLiang(){
		List<Dishes> liangDishes=dd.getLiang();
		List<List<Dishes>> ll= cc.sort(liangDishes);
		List<Dishes> ld=new ArrayList<Dishes>();
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				ld.add(ll.get(i).get(j));
			}
		}
		return ld;
	}
	public List<Dishes> getOthes(){
		List<Dishes> others=dd.getOthes();
		List<List<Dishes>> ll= cc.sort(others);
		List<Dishes> ld=new ArrayList<Dishes>();
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				ld.add(ll.get(i).get(j));
			}
		}
		return ld;
	}
}
