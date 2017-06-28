package com.yang.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.yang.model.Role_Auth;
import com.yang.util.RoleauthUtil;
public class RoleAuthDao {
	/**
	 *更换角色的修改
	 * @param ra
	 * @return
	 */
	public int update(RoleauthUtil ra ){
		String sql="update employee set user_power=? where user_id=?";
		Object[] obj=new Object[]{ra.getUser_power(),ra.getUser_id()};
		return DaoFactory.executeUpdate(sql, obj);
	}
	/**
	 * 查询
	 * @param ra1
	 * @return
	 */
	public List<Role_Auth> select(){
		String sql="select e1.user_id,r1.role_name from employee e1,role r1 where e1.user_power = r1.role_id";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<Role_Auth> list=new ArrayList<Role_Auth>();
		try {
			while(rs.next()){
				Role_Auth ra=new Role_Auth();
				ra.setUser_id(rs.getInt(1));
				ra.setName(rs.getString(2));
				list.add(ra);
			}
		} catch (Exception e) {
			System.out.println("权限"+e.getMessage());
		}
		return list;
	}
	
}
