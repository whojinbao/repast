package com.yang.dao;

import java.util.List;

import com.yang.model.Auth;

public interface AuthDao {
	public int addAuth(Auth aa);
	public int deleteAuth(Auth aa);
	public int updateAuth(Auth aa);
	public List<Auth> select();
}
