package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;

public class Sort2 {
	/*
	 * 按照每桌第一道菜进行排序
	 * 把List<List<Dishes>>按照每桌第一道添加List<Dishes>
	 * 
	 */
	private List<Dishes> heList(){
		
		DishesDao dd=new DishesDao();
		List<String> lls=dd.getSeatList();
		Combine pp=new Combine();
		List<List<Dishes>> ll=pp.sort();
		List<Dishes> ld=new ArrayList<Dishes>();
		int flag=0;
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				flag++;
			}
		}
		List<String> strings=lls;
		for (int i = 0; i < flag; i++) {
			for (int k = 0; k <ll.size(); k++) {
				if(ll.get(k).size()>0){
					int flag1=1;
					String string2=ll.get(k).get(0).getSeatId().get(0);
					for (int j = 0; j < strings.size(); j++) {
						String string1=strings.get(j);
						if(string1.equals(string2)){
							flag1=-1;
						}
					}
					if (flag1==1) {
						ld.add(ll.get(k).get(0));
						for (int n = 0; n < ll.get(k).get(0).getSeatId().size(); n++) {
							strings.add(ll.get(k).get(0).getSeatId().get(n));
						}
						ll.get(k).remove(0);
					}
				}
				if(k==(ll.size()-1)){
					strings=new ArrayList<String>();
				}
			}

		}
		return ld;
	}
	/*
	 * 输出结果
	 */
	public List<Dishes> outPuttimes(){
		Allot cc=new Allot();
		return cc.outPuttimes(heList()) ;
	}
}
