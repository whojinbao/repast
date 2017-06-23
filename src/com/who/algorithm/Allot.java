package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.Dishesing;
import com.who.hearth.HearthDao;

public class Allot {
	HearthDao hearth=new HearthDao();
	private int num=hearth.getHearth();
	private List<List<Dishes>> list=new ArrayList<List<Dishes>>();
	/*
	 * 按照先入先出进行分灶，灶的数量为num
	 */
	private List<List<Dishes>> realize(List<Dishes> heList){
		/*
		 * 获取锅内正在炒的菜品剩余出锅时间
		 * 放入List中按先后出锅顺序进行分锅
		 */
		OvenTime ovenTime=new OvenTime();
		List<Dishesing> oList=ovenTime.getOveningTime();
		List<List<Integer>> intList =new ArrayList<List<Integer>>();
		for (int i = 0; i < num; i++) {
			List<Integer> list=new ArrayList<Integer>();
			list.add(i);
			int startNum=0;
			if(oList.size()>=i+1)startNum=oList.get(i).getEWT();
			list.add(startNum);
			intList.add(list);
		}
		/*
		 * 开始把菜品分成若干个锅内
		 */
		List<Dishes> ld=heList;
		List<List<Dishes>> lt=new ArrayList<List<Dishes>>(num);
		for (int i = 0; i < num; i++) {
			List<Dishes> listshiyan=new ArrayList<Dishes>();
			lt.add(listshiyan);
		}
		for (int i = 0; i < ld.size(); i++) {
				for (int k = 1; k < intList.size(); k++) {
					for (int l = 0; l < intList.size()-k; l++) {
						List<Integer> d1=intList.get(l);
						List<Integer> d2=intList.get(l+1);
						if(d1.get(1)>d2.get(1)){
							List<Integer> d3=d1;
							intList.set(l, d2);
							intList.set(l+1, d3);
						}
					}
				}
				int flag=intList.get(0).get(0);
				lt.get(flag).add(ld.get(i));
				intList.get(0).set(1, intList.get(0).get(1)+ld.get(i).getDoTime());
			
			}
		/*while(ld.size()>0){
			for (int i = 0; i < num; i++) {
				if (ld.size()>0) {
					lt.get(i).add(ld.get(0));
					ld.remove(0);
				}else{
					break;
				}
			}
		}*/
		return lt;
		
	}
	/*
	 * 获取菜品的等待时间
//	 * 通过调Cooking的start方法获取
	 */
	
	public List<Dishes> outPuttimes(List<Dishes> li){
		OvenTime ovenTime=new OvenTime();
		List<Dishesing> oList=ovenTime.getOveningTime();
		
		List<Dishes> rl=new  ArrayList<Dishes>();
		for (int i = 0; i < li.size(); i++) {
			rl.add(li.get(i));
		}
		List<List<Dishes>> ll=realize(li);
		for (int i = 0; i < num; i++) {
			int startNum=0;
			if(oList.size()>=i+1){
				startNum=oList.get(i).getEWT();
			}
			Cooking ss=new Cooking();
			List<Dishes> pxh=ss.start(i, ll,startNum);
			list.add(pxh);
		}
		return rl;
	}
}
