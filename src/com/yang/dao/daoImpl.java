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
		String sql="insert into employee values(?,?,?,?,?,?,?)";
		Object[] obj =new Object[]{yy.getUser_id(),yy.getUser_name(),yy.getUser_sex(),yy.getUser_age(),yy.getUser_addr(),yy.getUser_power(),yy.getUser_pwd()};
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
		String sql="update employee set user_age=?,user_addr=?,user_pwd=? where user_id=?";
		Object[]obj=new Object[]{yy.getUser_age(),yy.getUser_addr(),yy.getUser_pwd(),yy.getUser_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 员工的数据查询
	 */
	public List<YUser> select(){
		String sql="select e1.user_id,e1.user_name,e1.user_sex,e1.user_age,e1.user_addr,r1.role_name,e1.user_pwd from employee e1,role r1 where e1.user_power=r1.role_id";
		List<YUser> ll=new ArrayList<YUser>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				YUser yu=new YUser();
				yu.setUser_id(rs.getInt(1));
				yu.setUser_name(rs.getString(2));
				yu.setUser_sex(rs.getString(3));
				yu.setUser_age(rs.getInt(4));
				yu.setUser_addr(rs.getString(5));
				yu.setName(rs.getString(6));
				yu.setUser_pwd(rs.getString(7));
				ll.add(yu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}
	
	/**
	 * 模糊查询
	 */
	public List<YUser> select1(YUser yy){
		String sql="select * from employee where user_name like '%"+yy.getUser_name()+"%'";
		List<YUser>lm=new ArrayList<YUser>();
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				yy.setUser_id(rs.getInt(1));
				yy.setUser_age(rs.getInt(4));
				yy.setUser_sex(rs.getString(3));
				yy.setUser_power(rs.getInt(6));
				yy.setUser_name(rs.getString(2));
				yy.setUser_addr(rs.getString(5));
				lm.add(yy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return lm;
	}
}
