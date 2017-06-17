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
	 * selMenu() ��ѯ���ݿ��в�Ʒ(����) �������ѯ
	 *
	 * @return
	 */
	public String selMenu(){
	    
		List<Menu> menuList =useMenu.selMenu();
	
	
		session.setAttribute("menuList", menuList);
		return "ok";
	}
	
}
