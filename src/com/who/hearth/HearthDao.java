package com.who.hearth;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.publics.dao.DaoFactory;

public class HearthDao {
	/*
	 * 取出数据库中可以使用的灶台数量
	 */
	public int getHearth(){
		DaoFactory dd=new DaoFactory();
		String sql="select num from hearth where id=1";
		ResultSet rs=dd.executeQuery(sql, null);
		int num=0;
		try {
			rs.next();
			num=rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("取灶台"+e.getMessage());
		}
		return num;
	}
}
