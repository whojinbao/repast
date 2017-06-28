package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.QT;

public class QTdao implements QTLogin{

	public String list(String name) {
		// TODO Auto-generated method stub
		String sql="select pwd from qiantai where id=?";
		Object params[]={name};
		List<QT>list=new ArrayList<QT>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, params);
		String pswd=null;
		try {
			if(rs.next()){
				pswd=rs.getString("pwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pswd;
	}
		
}
