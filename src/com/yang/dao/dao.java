package com.yang.dao;

import java.util.List;

import com.yang.model.YUser;

public interface dao {
	/**
	 * ÔöÉ¾¸Ä²é
	 * @param yy
	 * @return
	 */
	public int addYuser (YUser yy);
	public int delYUser(YUser yy);
	public int updateYUser(YUser yy);
	public List <YUser> select();
}
