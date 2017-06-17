package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.YUser;

public class daoImpl implements dao{
	public int addYuser(YUser yy){
		String sql="insert into staff values(?,?,?,?,?,?,?,?,?)";
		Object[] obj =new Object[]{yy.getUserName(),yy.getUserPwd(),yy.getRealName(),yy.getSex(),yy.getAge(),yy.getPhone(),yy.getAddr(),yy.getPostcode(),yy.getPower() };
		return DaoFactory.executeUpdate(sql, obj);
	}
	public int delYUser(YUser yy){
		String sql="delete from staff where userName=?";
		Object[] params={yy.getUserName()};
		return DaoFactory.executeUpdate(sql, params);
	}
	public int updateYUser(YUser yy){
		String sql="update staff set realName=?,sex=?,phone=?,addr=? where userName=?";
		Object[]obj=new Object[]{yy.getRealName(),yy.getSex(),yy.getPhone(),yy.getAddr(),yy.getUserName()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	public List<YUser> select(){
		String sql="select * from staff";
		List<YUser> ll=new ArrayList<YUser>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){
				YUser yu=new YUser();
				yu.setUserName(rs.getString(1));

				yu.setUserPwd(rs.getString(2));
				yu.setRealName(rs.getString(3));
				yu.setSex(rs.getString(4));
				yu.setAge(rs.getInt(5));
				yu.setPhone(rs.getString(6));
				yu.setAddr(rs.getString(7));
				yu.setPostcode(rs.getString(8));
				yu.setPower(rs.getInt(9));
				ll.add(yu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}
}
