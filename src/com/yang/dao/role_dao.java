package com.yang.dao;

import java.util.List;

import com.yang.model.Role;

public interface role_dao {
	public int addRole(Role rr);
	public int deleteRole(Role rr);
	public int updateRole(Role rr);
	public List<Role> select();
	
}
