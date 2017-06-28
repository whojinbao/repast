package com.yang.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.daohang;

public class Impl {
	public List<daohang>select(){
		String sql="select * from daohang";
		List<daohang>ld=new ArrayList();
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				daohang dh=new daohang();
				dh.setId(rs.getInt(1));
				dh.setName(rs.getString(2));
				ld.add(dh);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ld;
	}

}
