package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Login;

public class LoginDaoImpl implements LoginDao {
/*
 *根据员工id查询员工密码;
 */
	public String list(String name) {
		// TODO Auto-generated method stub
		String sql="select user_pwd from employee where user_id=?";
		Object params[]={name};
		List<Login>list=new ArrayList<Login>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, params);
		String pswd=null;
		String pd=null;
		List<String>ls=new ArrayList<String>();
		try {
			if(rs.next()){
				pswd=rs.getString("user_pwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pswd;
	}
}
