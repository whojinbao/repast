package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.YUser;

public class daoImpl implements dao{
	/**
	 *员工的数据增加
	 */
	public int addYuser(YUser yy){
		String sql="insert into employee values(?,?,?,?,?,?,?,?)";
		Object[] obj =new Object[]{yy.getUser_id(),yy.getUser_name(),yy.getUser_pwd(),yy.getUser_sex(),yy.getUser_phone(),yy.getUser_age(),yy.getUser_add(),yy.getUser_power()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 *员工的数据删除
	 */
	public int delYUser(YUser yy){
		String sql="delete from employee where user_id=?";
		Object[] params={yy.getUser_id()};
		return DaoFactory.executeUpdate(sql, params);
	}
	/**
	 * 员工的数据更新
	 */
	public int updateYUser(YUser yy){
		String sql="update employee set user_name=?,user_pwd=?,user_sex=?,user_phone=? ,user_age=?,user_add=?,user_power=? where user_id=?";
		Object[]obj=new Object[]{yy.getUser_name(),yy.getUser_pwd(),yy.getUser_sex(),yy.getUser_phone(),yy.getUser_age(),yy.getUser_add(),yy.getUser_power(),yy.getUser_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 员工的数据查询
	 */
	public List<YUser> select(){
		String sql="select * from employee";
		List<YUser> ll=new ArrayList<YUser>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				YUser yu=new YUser();
				yu.setUser_id(rs.getInt(1));
				yu.setUser_name(rs.getString(2));
				yu.setUser_pwd(rs.getString(3));
				yu.setUser_sex(rs.getString(4));
				yu.setUser_phone(rs.getString(5));
				yu.setUser_age(rs.getInt(6));
				yu.setUser_add(rs.getString(7));
				yu.setUser_power(rs.getInt(8));
				ll.add(yu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}
}
