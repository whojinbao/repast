package com.yang.dao;

import java.util.List;

import com.yang.model.YUser;

public interface dao {
	/**
	 * ��ɾ�Ĳ�
	 * @param yy
	 * @return
	 */
	public int addYuser (YUser yy);
	public int delYUser(YUser yy);
	public int updateYUser(YUser yy);
	public List <YUser> select();
}
