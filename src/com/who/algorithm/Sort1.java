package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;

public class Sort1 {
	DishesDao dd=new DishesDao();
	List<Dishes> reDishes=dd.getDishes();
	/*
	 * ���յ��˳���������
	 * ��List<List<Dishes>>�����Ⱥ�˳��ϲ�ΪList<Dishes>
	 * 
	 */
	
	private List<Dishes> heList(){
		Combine pp=new Combine();
		List<List<Dishes>> ll=pp.sort(reDishes);
		List<Dishes> ld=new ArrayList<Dishes>();
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				ld.add(ll.get(i).get(j));
			}
		}
		return ld;
	}
	/*
	 * ������
	 */
	public List<Dishes> outPuttimes(){

		
		Allot cc=new Allot();
		return cc.outPuttimes(heList());
		
	}
}
