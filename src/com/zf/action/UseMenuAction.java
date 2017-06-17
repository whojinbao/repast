package com.zf.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseMenuDao;
import com.zf.entity.Menu;
import com.zf.entity.MenuType;


/**
 *     对菜品 menu的操作
 *     上启页面 ，从页面坚守数据（menu.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseMenuAction {
	
    private UseMenuDao useMenu = new UseMenuDao();
    HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private Menu menu = new Menu();
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	/**
	 * addMenu() 往菜品中添加新菜品
	 * 
	 * @return
	 */

	public String addMenu(){
	
		
        useMenu.addMenu(menu);
        System.out.println(menu.getMenuTypeId());
        selMenu();
		return "ok";
	}
	
	/**
	 * del() 往菜品分类中删除分类
	 * typeId 接受的分类id
	 * @return
	 */
	public String del(){
		
		int menuId =Integer.parseInt(request.getParameter("menuId")) ;	   
		useMenu.delMenu(menuId);
		selMenu();
		return "ok";
	}	
	
	/**
	 * selMenu() 查询数据库中菜品(所有) 按菜类查询
	 *
	 * @return
	 */
	public String selMenu(){
	    
		List<Menu> menuList =useMenu.selMenu();
	
	
		session.setAttribute("menuList", menuList);
		return "ok";
	}
	
}
