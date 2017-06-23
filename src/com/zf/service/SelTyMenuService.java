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
	//建一个数组，存menuTypeName， 和 menuList<typeName>
	List<orderUtil> ordrUtilList = new ArrayList<orderUtil>();
	//获取menuType 数组
	UseMenuTypeDao usemenuatypeDao = new UseMenuTypeDao();
	List<MenuType> menuTypeList = usemenuatypeDao.seltype();
	for(int i=0;i<menuTypeList.size();i++){
		MenuType menuType = menuTypeList.get(i);
		String typeName = menuType.getTypeName();
		
		//遍历menuTypeList ，根据typeName得到 menuList	
		List<Menu> menuList =(new UseMenuDao()).selTyMenu(typeName);	
		System.out.println("ss"+menuList.size());
		//将typeName，menuList  放入一个数组对象类；将list放入 ordrUtilList	
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


