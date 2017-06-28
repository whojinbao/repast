package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.zf.entity.MenuType;



/***
 *对 菜品分类的添加，删除，查询操作（全部）
 * @param typeName  菜品分类的名称
 * typeId 菜品分类的id
 */
public class UseMenuTypeDao {
	private DaoFactory da1 = new DaoFactory();
   
	/***
	 * Addtype 菜品分类的添加
	 * @param typeName  菜品分类的名称
	 */
	public void Addtype(String typeName){
		String sql = "insert into menuType values(?)";

		Object[] obj = {typeName};
		da1.executeUpdate(sql, obj);
	}

	/***
	 * deltype 菜品分类的删除
	 * @param typeName  菜品分类的名称
	 * typeId 菜品分类的id
	 */
	public void deltype(int id){
		String sql = "delete from menuType WHERE typeId in(?) ";
		Object[] obj = {id};
		da1.executeUpdate(sql, obj);
	}

	/***
	 * seltype 菜品分类的查询，，全部数据
	 * @param typeName  菜品分类的名称
	 *  typeId 菜品分类的id
	 *  maxPage 每页显示几条
	 *  startPage 从第几条开始
	 */
	public List<MenuType> seltype(){
		String sql = "select * from menuType ORDER BY typeId ASC";
		ResultSet rs = da1.executeQuery(sql, null);
		List<MenuType> menuTypeList = new ArrayList<MenuType>();
		try {				
			while(rs.next()){
				MenuType menutype = new MenuType();
				menutype.setTypeId( rs.getInt(1));
				menutype.setTypeName(rs.getString(2));
				menuTypeList.add(menutype);		
				
			}				
		}
		catch(Exception e){
			return null;
		}
		return menuTypeList;
	}
	/**
	 * 
	 */
	 public List<MenuType> selName(String typeName1){
		    String sql = "select * from menuType where typeName='"+typeName1+"'";
			DaoFactory da1 = new DaoFactory();
			ResultSet rs= da1.executeQuery(sql, null);
	        List<MenuType> menuList = new ArrayList<MenuType>();
			try{
			   rs.next();
			   MenuType menuType = new MenuType();
			   menuType.setTypeId(rs.getInt(1));
			   menuType.setTypeName(rs.getString(2));
			   menuList.add(menuType);
			}catch(Exception e){
				
			}
			return menuList;
	 }

	/***
	 * count() 查询总条数
	 */
	public int count(){
		String sql = "select count(*) from menuType";
		ResultSet rs = da1.executeQuery(sql, null);
		int count = 0;
		try {
			rs.next();
			count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return count;

	}
}
