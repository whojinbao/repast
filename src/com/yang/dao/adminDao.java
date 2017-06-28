package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.admin;

public class adminDao {
	public int add(admin aa){
		String sql="insert into admin values(?,?)";
		Object[]obj={aa.getUser_id(),aa.getUser_pwd()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	public int update(admin aa){
		String sql="update admin set user_pwd=? where user_id=?";
		Object[]obj={aa.getUser_pwd(),aa.getUser_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	public List<admin> select(){
		String sql="select * from admin ";
		List<admin>ll=new ArrayList<admin>();
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				admin aa=new admin();
				aa.setUser_id(rs.getInt("user_id"));
				aa.setUser_pwd(rs.getString("user_pwd"));
				ll.add(aa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}
}
