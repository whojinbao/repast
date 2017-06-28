package com.caoqi.waiter;

import java.util.List;

public interface dao {
	public int update(waiter wt);
	public List<waiter> select();
	public List<waiter> select1(waiter wt);
	public List<waiter> selectRoom();
	public List<waiter> selectBox();
	public int update1(waiter ww);
	public List<waiter> orderSeat();
}
