package com.caoqi_deskimg;

import java.util.List;

public interface dao {
	public List<Deskimg> select();
	public List<Deskimg> select1();
	public List<Deskimg> select2();
	public int update(Deskimg ss);
	
}
