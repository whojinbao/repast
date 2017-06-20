package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.MenuListener;

import com.publics.dao.DaoFactory;
import com.zf.entity.Menu;

/**
 * �Բ�Ʒ����ӣ�ɾ�����޸ģ���ѯ��ȫ����
 * @author Administrator
 *
 */
public class UseMenuDao {
	
	private DaoFactory da1 = new DaoFactory();

	/***
	 * Addtype ��Ʒ�����
	 * Menu menu  ��Ʒ
	 * menu.getMenu_name() ��ò�Ʒ��name   ��Ʒ��id���� 
	 * @param
	 */
	public void addMenu(Menu menu ){
		String sql = "insert into menu values(?,?,?,?,?)";    
		Object[] obj = {menu.getMenuName(),menu.getDoTime(),menu.getMaxNum(),menu.getMenuTypeId(),menu.getMenuPrice()};
		da1.executeUpdate(sql, obj);
	}

	/***
	 * delMenu ��Ʒ��ɾ��
	 * @param 
	 * Menu_id ��Ʒ��id
	 */
	public void delMenu(int id){
		String sql = "delete from menu WHERE menu_id in(?) ";
		Object[] obj = {id};
		da1.executeUpdate(sql, obj);
	}
	
	
	/***
	 * updateMenu ���£��޸Ĳ�Ʒ
	 * 
	 * 
	 * 
	 */
	public void updateMenu(Menu menu){
		String sql = "update menu set menu_name =?,  doTime = ?,maxNum=?, menuType=?," +
				     "menuPrice=? where menu_id= ?" ;
		System.out.println(menu.getMaxNum());
		Object[] obj = {menu.getMenuName(),menu.getDoTime(),menu.getMaxNum(),menu.getMenuTypeId(),menu.getMenuPrice(),menu.getMenuId()};
	    da1.executeUpdate(sql, obj);  
	}

	/***
	 * selMenu ��Ʒ�Ĳ�ѯ����ȫ������
	 * @param 
	 */
	public List<Menu> selMenu(){
		String sql ="select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId ORDER BY mu1.menu_id ASC";		
		ResultSet rs = da1.executeQuery(sql, null);
		List<Menu> menuList = new ArrayList<Menu>();		
		try {					
			while(rs.next()){
				Menu menu2 = new Menu();
				menu2.setMenuId(rs.getInt(1));
				menu2.setMenuName(rs.getString(2));
				menu2.setDoTime(rs.getInt(3));
				menu2.setMaxNum(rs.getInt(4));
				menu2.setMenuTypeName(rs.getString(5));
				menu2.setMenuPrice(rs.getInt(6));
				menuList.add(menu2);	
				System.out.println(rs.getObject(1));
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return menuList;
		
	}

	/**
	 * selIdMenu ��Ʒ�Ĳ�ѯ����ȫ�����ݣ��� ��Ʒid
	 * @param 
	 */
	public Menu selIdMenu(int menuId){
		System.out.println("setIddao");
		String sql ="select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				    " menuType mt1 where mu1.menuType=mt1.typeId and  mu1.menu_id= ? ORDER BY mu1.menu_id ASC " ;
		Object[] obj = {menuId};
		ResultSet rs = da1.executeQuery(sql, obj);
		Menu menu2 = new Menu();
		try {					
			while(rs.next()){
				
				System.out.println(rs.getInt(1));
				menu2.setMenuId(rs.getInt(1));
				menu2.setMenuName(rs.getString(2));
				menu2.setDoTime(rs.getInt(3));
				menu2.setMaxNum(rs.getInt(4));
				menu2.setMenuTypeName(rs.getString(5));
				menu2.setMenuPrice(rs.getInt(6));
				System.out.println(rs.getInt(6));
				return menu2;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * selMenu ��Ʒ�Ĳ�ѯ����ȫ�����ݣ��� ����
	 * @param 
	 */
	public List<Menu> selTyMenu(String typeName){
		String sql ="select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and  mt1.typeName = '?' ORDER BY mu1.menu_id ASC " ;
		Object[] obj = {typeName};
		ResultSet rs = da1.executeQuery(sql, obj);
		List<Menu> menuList = new ArrayList<Menu>();		
		try {					
			while(rs.next()){
				Menu menu2 = new Menu();
				menu2.setMenuId(rs.getInt(1));
				menu2.setMenuName(rs.getString(2));
				menu2.setDoTime(rs.getInt(3));
				menu2.setMaxNum(rs.getInt(4));
				menu2.setMenuTypeName(rs.getString(5));
				menu2.setMenuPrice(rs.getInt(6));
				menuList.add(menu2);	
				System.out.println(rs.getObject(1));
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return menuList;
	}
	
	/***
	   * selMenu ��Ʒ�Ĳ�ѯ������ģ����ѯ
	   * @param 
	   */
	public List<Menu> selMhMenu(String menuName){
		String sql = "select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and mu1.menu_name like '%"+menuName+"%' ORDER BY mu1.menu_id ASC ";
		
		ResultSet rs = da1.executeQuery(sql, null);
		List<Menu> menuList = new ArrayList<Menu>();		
		try {					
			while(rs.next()){
				Menu menu2 = new Menu();
				menu2.setMenuId(rs.getInt(1));
				menu2.setMenuName(rs.getString(2));
				menu2.setDoTime(rs.getInt(3));
				menu2.setMaxNum(rs.getInt(4));
				menu2.setMenuTypeName(rs.getString(5));
				menu2.setMenuPrice(rs.getInt(6));
				menuList.add(menu2);	
				System.out.println(rs.getObject(1));				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return menuList;
		
	}

}
