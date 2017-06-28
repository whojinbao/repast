package com.who;

import java.util.ArrayList;
import java.util.List;

import com.who.algorithm.Sort3;
import com.who.getdata.Dishes;

public class Test {
	
	public static void main(String[] args){
		/*Sort3 ss=new Sort3();
		List<Dishes> ll=ss.outPuttimes();
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i).getMenuName());
		}*/
		List<String >ll=new ArrayList<String>();
		ll.add("0");
		ll.add("1");
		ll.add("2");String aa=ll.get(0);
		ll.set(0, ll.get(2));
		
		ll.set(2,aa);
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i));
		}
		
	}

}
