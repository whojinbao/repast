package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Auth;

public class AuthDaoImpl implements AuthDao {

	public int addAuth(Auth aa) {
		// TODO Auto-generated method stub
		String sql="insert into auth values(?,?,?,?,?)";
		Object[] obj=new Object[]{aa.getAuthId(),aa.getAuthName(),aa.getAuthPath(),aa.getParentId(),aa.getAuthDescription()};
		return DaoFactory.executeUpdate(sql, obj);
	}

	public int deleteAuth(Auth aa) {
		// TODO Auto-generated meth od stub
		String sql="delete from auth where authId=?";
		Object[] params={aa.getAuthId()};
		return DaoFactory.executeUpdate(sql, params);
	}

	public int updateAuth(Auth aa) {
		// TODO Auto-generated method stub
		String sql="update auth set authName=?,authPath=?,parentId=?,authDescription=? where authId=?";
		Object[]obj=new Object[]{aa.getAuthName(),aa.getAuthPath(),aa.getParentId(),aa.getAuthDescription(),aa.getAuthId()};
		return DaoFactory.executeUpdate(sql, obj);
	}

	public List<Auth> select() {
		// TODO Auto-generated method stub
		String sql="select * from auth";
		List <Auth> list =new ArrayList<Auth>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				Auth au=new Auth();
				
				au.setAuthId(rs.getInt(1));
				au.setAuthName(rs.getString(2));
				au.setAuthPath(rs.getString(3));
				au.setParentId(rs.getInt(4));
				au.setAuthDescription(rs.getString(5));
				list.add(au);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("aaaa"+e.getMessage());
		}
		return list;
	}

}
