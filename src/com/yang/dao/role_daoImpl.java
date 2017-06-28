package com.yang.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Role;

public class role_daoImpl implements role_dao {
	/**
	 * ��ɫ�����
	 * Id ���� ����
	 */
	public int addRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="insert into role values(?,?)";
		Object[] obj=new Object[]{rr.getRole_id(),rr.getRole_name()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * ��ɫ��ɾ������idΪ����
	 */
	public int deleteRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="delete from role where role_id=?";
		Object[]obj=new Object[]{rr.getRole_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * ��ɫ�ĸ���
	 */
	public int updateRole(Role rr) {
		// TODO Auto-generated method stub
		String sql="update role set role_name=? where role_id=?";
		Object[]obj=new Object[]{rr.getRole_name(),rr.getRole_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * ��ɫ�Ĳ�ѯ����ѯ���еĽ�ɫ
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
				
				ll.add(rr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ"+e.getMessage());
		}
		return ll;
	}

}
