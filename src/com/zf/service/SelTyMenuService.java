package com.zf.service;

import java.util.ArrayList;
import java.util.List;

import com.zf.dao.UseMenuDao;
import com.zf.dao.UseMenuTypeDao;
import com.zf.entity.Menu;
import com.zf.entity.MenuType;
import com.zf.entity.util.orderUtil;

public class SelTyMenuService {
 
	
	public List getList(){
	//��һ�����飬��menuTypeName�� �� menuList<typeName>
	List<orderUtil> ordrUtilList = new ArrayList<orderUtil>();
	//��ȡmenuType ����
	UseMenuTypeDao usemenuatypeDao = new UseMenuTypeDao();
	List<MenuType> menuTypeList = usemenuatypeDao.seltype();
	for(int i=0;i<menuTypeList.size();i++){
		MenuType menuType = menuTypeList.get(i);
		String typeName = menuType.getTypeName();
		
		//����menuTypeList ������typeName�õ� menuList	
		List<Menu> menuList =(new UseMenuDao()).selTyMenu(typeName);	
		System.out.println("ss"+menuList.size());
		//��typeName��menuList  ����һ����������ࣻ��list���� ordrUtilList	
		if(menuList.size()<=0){
			menuList =null;
		}
		orderUtil orderUtil = new com.zf.entity.util.orderUtil();
		orderUtil.setMenuTypeName(typeName);
		orderUtil.setMenuList(menuList);
		ordrUtilList.add( orderUtil);
	}
	return ordrUtilList;
}
}


