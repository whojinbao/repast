package com.who.hearth;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.publics.dao.DaoFactory;

public class HearthDao {
	/*
	 * ȡ�����ݿ��п���ʹ�õ���̨����
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
			System.out.println("ȡ��̨"+e.getMessage());
		}
		return num;
	}
}
