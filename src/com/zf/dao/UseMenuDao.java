package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.MenuListener;

import com.publics.dao.DaoFactory;
import com.zf.entity.Menu;

/**
 * 对菜品的添加，删除，修改，查询（全部）
 * @author Administrator
 *
 */
public class UseMenuDao {
	
	private DaoFactory da1 = new DaoFactory();

	/***
	 * Addtype 菜品的添加
	 * Menu menu  菜品
	 * menu.getMenu_name() 获得菜品的name   菜品的id自增 
	 * @param
	 */
	public void addMenu(Menu menu ){
		String sql = "insert into menu values(?,?,?,?,?)";    
		Object[] obj = {menu.getMenuName(),menu.getDoTime(),menu.getMaxNum(),menu.getMenuTypeId(),menu.getMenuPrice()};
		da1.executeUpdate(sql, obj);
	}

	/***
	 * delMenu 菜品的删除
	 * @param 
	 * Menu_id 菜品的id
	 */
	public void delMenu(int id){
		String sql = "delete from menu WHERE menu_id in(?) ";
		Object[] obj = {id};
		da1.executeUpdate(sql, obj);
	}
	
	
	/***
	 * updateMenu 更新，修改菜品
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
	 * selMenu 菜品的查询，，全部数据
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
	 * selIdMenu 菜品的查询，，全部数据，按 菜品id
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
	 * selMenu 菜品的查询，，全部数据，按 菜类
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
	   * selMenu 菜品的查询，，，模糊查询
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
