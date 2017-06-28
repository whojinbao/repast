package com.yang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Login;

public class LoginDaoImpl implements LoginDao {

	public List<String> list(String name) {
		// TODO Auto-generated method stub
		String sql="select user_pwd,user_name,role_name from employee,role  where  user_power=role_id and user_id=?";
		Object params[]={name};
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, params);
		List<String> ll=new ArrayList<String>();
		
		try {
			if(rs.next()){
				String pswd=rs.getString("user_pwd");
				String name1=rs.getString("user_name");
				String role=rs.getString("role_name");
				ll.add(pswd);
				ll.add(name1);
				ll.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ll;
	}

}
