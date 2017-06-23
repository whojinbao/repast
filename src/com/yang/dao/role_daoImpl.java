package com.yang.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Role;

public class role_daoImpl implements role_dao {
	/**
	 * 角色的添加
	 * Id 名称 描述
	 */
	public int addRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="insert into role values(?,?,?)";
		Object[] obj=new Object[]{rr.getRole_id(),rr.getRole_name(),rr.getRole_info()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 角色的删除，以id为条件
	 */
	public int deleteRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="delete from role where role_id=?";
		Object[]obj=new Object[]{rr.getRole_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 角色的更新
	 */
	public int updateRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="update role set role_name=?,role_info=? where role_id=?";
		Object[]obj=new Object[]{rr.getRole_name(),rr.getRole_info(),rr.getRole_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 角色的查询，查询所有的角色
	 */
	public List<Role> select() {
		// TODO Auto-generated method stub
		String sql="select * from role";
		List<Role> ll=new ArrayList<Role>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				Role rr=new Role();
				rr.setRole_id(rs.getInt(1));
				rr.setRole_name(rs.getString(2));
				rr.setRole_info(rs.getString(3));
				ll.add(rr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查询"+e.getMessage());
		}
		return ll;
	}

}
