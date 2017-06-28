package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.publics.dao.DaoFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
		String sql = "insert into menu values(?,?,?,?,?,?,?)";    
		Object[] obj = {menu.getMenuId(),menu.getMenuName(),menu.getDoTime(),menu.getMaxNum(),
				menu.getMenuTypeId(),menu.getMenuPrice(),menu.getImgUrl()};
		da1.executeUpdate(sql, obj);
	}

	/***
	 * delMenu 菜品的删除
	 * @param 
	 * Menu_id 菜品的id
	 */
	public void delMenu(int id){
		String sql = "delete from menu WHERE menuId in(?) ";
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
		String sql = "update menu set menuName =?, doTime = ?,maxNum=?, menuType=?," +
				"menuPrice=? where menuId= ?" ;
		Object[] obj = {menu.getMenuName(),menu.getDoTime(),menu.getMaxNum(),menu.getMenuTypeId(),menu.getMenuPrice(),
				      menu.getMenuId()};
		da1.executeUpdate(sql, obj);  
	}

	/***
	 * selMenu 菜品的查询，，全部数据
	 * @param 
	 */
	public List<Menu> selMenu(){
		String sql ="select mu1.menuId,mu1.menuName,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice,mu1.imgUrl from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId ORDER BY mu1.menuId ASC";		

		/*	String sql ="select top "+maxPage+" mu1.menuId,mu1.menuName,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice,mu1.imgUrl,mu1.menuDescribe from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and mu1.menuId not in (select top "+startIndex+"menuId from menu) ORDER BY mu1.menuId ASC";*/
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
				menu2.setImgUrl(rs.getString(7));				
				menuList.add(menu2);	


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
	public List<Menu> selIdMenu(int menuId){
		String sql ="select mu1.menuId,mu1.menuName,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice, mu1.imgUrl from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and  mu1.menuId= ? ORDER BY mu1.menuId ASC " ;
		Object[] obj = {menuId};
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
				menu2.setImgUrl(rs.getString(7));
				menuList.add(menu2);			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return menuList;
	}
	/**
	 * 菜品的查询 以name 
	 */
	public List<Menu> selName(String name){
		String sql ="select * from menu where menuName = ? " ;
		Object[] obj = {name};
		ResultSet rs = da1.executeQuery(sql, obj);
		List<Menu> menuList = new ArrayList<Menu>() ;

		int menuId = 0;
		try {
			while(rs.next()){
				Menu menu2 = new Menu();
				menu2.setMenuId(rs.getInt(1));
				menu2.setMenuName(rs.getString(2));
				menu2.setDoTime(rs.getInt(3));
				menu2.setMaxNum(rs.getInt(4));
				menu2.setMenuTypeName(rs.getString(5));
				menu2.setMenuPrice(rs.getInt(6));
				menu2.setImgUrl(rs.getString(7));
				menuList.add(menu2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}


	/**
	 * selMenu 菜品的查询，，全部数据，按 菜类
	 * @param 
	 */
	public List<Menu> selTyMenu(String typeName){
		String sql ="select mu1.menuId,mu1.menuName,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice, mu1.imgUrl from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and  mt1.typeName = '"+typeName+"' ORDER BY mu1.menuId ASC " ;


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
				menu2.setImgUrl(rs.getString(7));			
				menuList.add(menu2);	

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return menuList;
	}

	/**
	 * selMenu 菜品的查询，，，模糊查询
	 * @param 
	 */
	public List<Menu> selMhMenu(String menuName){
		String sql = "select mu1.menuId,mu1.menuName,mu1.doTime,mu1.maxNum,mt1.typeName,mu1.menuPrice, mu1.imgUrl from menu mu1, " +
				" menuType mt1 where mu1.menuType=mt1.typeId and mu1.menuName like '%"+menuName+"%' ORDER BY mu1.menuId ASC ";

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
				menu2.setImgUrl(rs.getString(7));
				menuList.add(menu2);	

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return menuList;
	}
	/**
	 * 以name查找price
	 * 
	 */
       public int selPrice(String menuName){
    	    String sql = "select * from menu where menuName = ?";
    	    Object[] obj = {menuName};
    	    ResultSet rs = da1.executeQuery(sql, obj);
    	    int price =0;
    	    try {
				while(rs.next()){
					Menu menu2 = new Menu();
				    price = rs.getInt("MenuPrice");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    return price;
       }
	/**
	 * 得到菜品总条数
	 */
	public int count(){
		String sql = "select count(*) from menu";
		ResultSet rs = da1.executeQuery(sql, null);
		try {
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
