package com.caoqi.zhuo;

import java.util.List;



public interface dao {
		public int addZhuo(zhuo zz);//�������
		public int delete(zhuo zz);//ɾ������
		public int update(zhuo zz);//��������
		public List<zhuo> select1();//��ѯ����
		
	
}
