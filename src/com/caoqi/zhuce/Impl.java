package com.caoqi.zhuce;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;

public class Impl implements dao {

	public int add(zhuce zc) {
		String sql="insert into qiantai values(?,?,?,?,?)";
		Object[]ob=new Object[]{zc.getId(),zc.getName(),zc.getPwd(),zc.getTel(),zc.getIdcard()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	public String list(zhuce zc) {
		// TODO Auto-generated method stub
		String sql="select pwd from qiantai where id=?";
		Object params[]={zc.getId()};
		List<zhuce>list=new ArrayList<zhuce>();
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
