package com.who;

import java.util.List;

import com.who.algorithm.Sort2;
import com.who.getdata.Dishes;

public class Test {
	
	public static void main(String[] args){
		Sort2 ss=new Sort2();
		List<Dishes> ll=ss.outPuttimes();
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i).getMenuName());
		}
	}

}
