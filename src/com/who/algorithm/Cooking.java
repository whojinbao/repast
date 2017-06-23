package com.who.algorithm;

import java.util.List;

import com.who.getdata.Dishes;


public class Cooking extends Thread{
	/*
	 * 计算等待的时间
	 * num为灶台的数量，List为分好锅的菜品，startNum为当前锅内需等几分种出菜
	 */
	private List<Dishes> run(int num,List<List<Dishes>> dishesList,int startNum) {
		List<Dishes> dList=dishesList.get(num);
		int b=startNum;
		for (int i = 0; i < dList.size(); i++) {
			try {
				Thread.sleep(dList.get(i).getDoTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b+=dList.get(i).getDoTime();
			dList.get(i).setWaiting(b);
		}
		return dList;
	}
	/*
	 * 覆盖start方法调用run
	 */
	public List<Dishes> start(int num,List<List<Dishes>> ll,int startNum) {
	    return run(num,ll,startNum);	
	}
}
