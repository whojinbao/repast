package com.zf.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseMenuDao;
import com.zf.entity.Menu;
import com.zf.entity.MenuType;


/**
 *     �Բ�Ʒ menu�Ĳ���
 *     ����ҳ�� ����ҳ��������ݣ�menu.jsp������ӵ����ݿ�
 *     ����dao���̣��������ݿ�
 *     ��������
 * @author Administrator
 *
 */
public class UseMenuAction {
	
    private UseMenuDao useMenu = new UseMenuDao();
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response =ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	private Menu menu = new Menu();
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	/**
	 * addMenu() ����Ʒ������²�Ʒ
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
	 * del() ����Ʒ������ɾ������
	 * typeId ���ܵķ���id
	 * @return
	 */
	public String del(){
		
		int menuId =Integer.parseInt(request.getParameter("menuId")) ;	   
		useMenu.delMenu(menuId);
		selMenu();
		return "ok";
	}	
	
	
	/**
	 *updateMenu() �޸Ĳ�Ʒ
	 * 
	 * @return
	 */
	public String updateMenu(){
		System.out.println("update");
		useMenu.updateMenu(menu);
		selMenu();
		return "ok";
	}	
	
	
	
	/**
	 * selMenu() ��ѯ���ݿ��в�Ʒ(����) 
	 *
	 * @return
	 */
	public String selMenu(){
	    
		List<Menu> menuList =useMenu.selMenu();	
		session.setAttribute("menuList", menuList);
		return "ok";
	}
	
	/**
	 * selTyMenu() ��ѯ���ݿ��в�Ʒ,������
	 *
	 * @return
	 */
	public String selTyMenu(){
	    String typeName = request.getParameter("typeName");
		List<Menu> menuList =useMenu.selTyMenu(typeName);	
		session.setAttribute("menuList", menuList);
		return "ok";
	}
	
	/**
	 * selIdMenu() ��ѯ���ݿ��в�Ʒ,����Ʒid
	 * ���޸Ĳ�Ʒ��ʹ��
	 * @return
	 */
	public String selIdMenu(){
		System.out.println("id");
	    Integer menuId = Integer.parseInt(request.getParameter("menuId"));
	    System.out.println(menuId);
		Menu menu =useMenu.selIdMenu(menuId);	
		session.setAttribute("menu", menu);
		System.out.println(menu.getMenuName());
	    try {
			request.getRequestDispatcher("menuUpdate.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * selMhMenu() ģ����ѯ������Ʒ����
	 *
	 * @return
	 */
	public String selMhMenu(){
		System.out.println("mh");
		
	    String menuName= request.getParameter("menuName");
	    System.out.println(menuName);
		List<Menu> menuList =useMenu.selMhMenu(menuName);
		session.setAttribute("menuList", menuList);
		return "ok";
	}
	
}
