package com.yang.util;

public class RoleauthUtil {
	/**
	 * 权限辅助接受类
	 */
	private int user_id;
	private int user_power;
	private String powername;
		
	public String getPowername() {
		return powername;
	}
	public void setPowername(String powername) {
		this.powername = powername;
	}
	public int getUser_power() {
		return user_power;
	}
	public void setUser_power(int user_power) {
		this.user_power = user_power;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
