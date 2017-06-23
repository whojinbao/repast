package com.zf.action;

import java.util.List;

import com.zf.entity.Menu;
import com.zf.entity.util.orderUtil;
import com.zf.service.SelTyMenuService;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelTyMenuService sel = new SelTyMenuService();
		List<orderUtil> list = sel.getList();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			String name = list.get(i).getMenuTypeName();
			List<Menu> menuList = list.get(i).getMenuList();
		
			for(int y =0; y<menuList.size();y++){
				System.out.print("ss"+name+y+menuList.get(y).getMenuName());
			}
			System.out.println();
				
			
		}
		
	}

}
