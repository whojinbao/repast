package com.who.algorithm;

import java.util.List;

import com.who.getdata.Dishes;


public class Cooking extends Thread{
	/*
	 * ����ȴ���ʱ��
	 * numΪ��̨��������ListΪ�ֺù��Ĳ�Ʒ��startNumΪ��ǰ������ȼ����ֳ���
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
	 * ����start��������run
	 */
	public List<Dishes> start(int num,List<List<Dishes>> ll,int startNum) {
	    return run(num,ll,startNum);	
	}
}
