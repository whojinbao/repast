package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;

public class Sort1 {
	/*
	 * 按照点餐顺序进行排序
	 * 把List<List<Dishes>>按照先后顺序合并为List<Dishes>
	 * 
	 */
	private List<Dishes> heList(){
		Combine pp=new Combine();
		List<List<Dishes>> ll=pp.sort();
		List<Dishes> ld=new ArrayList<Dishes>();
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				ld.add(ll.get(i).get(j));
			}
		}
		return ld;
	}
	/*
	 * 输出结果
	 */
	public List<Dishes> outPuttimes(){

		
		Allot cc=new Allot();
		return cc.outPuttimes(heList());
		
	}
}
