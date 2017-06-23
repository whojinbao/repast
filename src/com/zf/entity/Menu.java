package com.zf.entity;


/***
 * id	name	所用时间	    单锅最大数量	菜品分类ID	         价格
 menuId	 menuName	doTime	maxNum	menuType	menuPrice

 * @author Administrator
 *  菜品分类ID  menuType 转为菜类名
 */
public class Menu {
    private int menuId;
    private String menuName;
    private int doTime;
    private int maxNum;
    private int menuTypeId;
	private String menuTypeName;
    private int menuPrice;
    private String imgUrl;
    private String menuDescribe;
    
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getDoTime() {
		return doTime;
	}
	public void setDoTime(int doTime) {
		this.doTime = doTime;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getMenuTypeId() {
		return menuTypeId;
	}
	public void setMenuTypeId(int menuTypeId) {
		this.menuTypeId = menuTypeId;
	}
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getMenuDescribe() {
		return menuDescribe;
	}
	public void setMenuDescribe(String menuDescribe) {
		this.menuDescribe = menuDescribe;
	}

	
}
