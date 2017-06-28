package com.yang.util;
/**
 * 角色的辅助类，给予set和get方法
 * @author Administrator
 *
 */
public class authUtil {
	private int auth_id;
	private String auth_name;
	private String auth_path;
	
	public int getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public String getAuth_path() {
		return auth_path;
	}
	public void setAuth_path(String auth_path) {
		this.auth_path = auth_path;
	}
	
}
