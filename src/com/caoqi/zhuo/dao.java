package com.caoqi.zhuo;

import java.util.List;



public interface dao {
		public int addZhuo(zhuo zz);//添加桌子
		public int delete(zhuo zz);//删除桌子
		public int update(zhuo zz);//更新桌子
		public List<zhuo> select1();//查询桌子
		
	
}
