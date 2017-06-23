package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Auth;

public class AuthDaoImpl implements AuthDao {
		/**
		 *调用daoFactory方法进行增加的sql语句
		 */
	public int addAuth(Auth aa) {
		// TODO Auto-generated method stub
		String sql="insert into auth values(?,?,?)";
		Object[] obj=new Object[]{aa.getAuth_id(),aa.getAuth_name(),aa.getAuth_info()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 *调用daoFactory方法进行删除的sql语句
	 */
	public int deleteAuth(Auth aa) {
		// TODO Auto-generated meth od stub
		String sql="delete from auth where auth_id=?";
		Object[] params={aa.getAuth_id()};
		return DaoFactory.executeUpdate(sql, params);
	}
	/**
	 *调用daoFactory方法进行更新的sql语句
	 */
	public int updateAuth(Auth aa) {
		// TODO Auto-generated method stub
		String sql="update auth set auth_name=?,auth_info=? where auth_id=?";
		Object[]obj=new Object[]{aa.getAuth_name(),aa.getAuth_info(),aa.getAuth_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 *调用daoFactory方法进行删除的sql语句
	 */
	public List<Auth> select() {
		// TODO Auto-generated method stub
		String sql="select * from auth";
		List <Auth> list =new ArrayList<Auth>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				Auth au=new Auth();
				au.setAuth_id(rs.getInt(1));
				au.setAuth_name(rs.getString(2));
				au.setAuth_info(rs.getString(3));
				list.add(au);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("aaaa"+e.getMessage());
		}
		return list;
	}

}
