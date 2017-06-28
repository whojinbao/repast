package com.zf.action;

import java.util.HashMap;
import java.util.Map;

import com.zf.dao.FinancialListDao;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    FinancialListDao f1 = new FinancialListDao();
    f1.getGoodMenu("2017-06-01", "2017-06-28");
	
	}

}



