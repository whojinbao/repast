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


	/***
	 * selMenu 菜品的查询，，全部数据，按 菜类
	 * @param 
	 */
	public List<Menu> selTyMenu(String menuType){
		String sql ="select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and  mt1.typeId = '?' ORDER BY mu1.menu_id ASC " ;
		Object[] obj = {menuType};
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
	public List<Menu> selMhMenu(String menuType){
		String sql = "select mu1.menu_id,mu1.menu_name,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and typeName like '%(?)%' ORDER BY mu1.menu_id ASC ";
		Object[] obj = {menuType};
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

}
