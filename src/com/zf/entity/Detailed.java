package com.zf.entity;

import java.util.Date;


/**
 * 
 * ����ID	                     �굥ID        	�µ�ʱ��	                 ��id	����	       ״̬���Ƿ��ϲˣ�	��ʼʱ��                    �ϲ�ʱ��
  orderId	detailedId	detailedTime	menuId	num	  dishesStatus	stateTime	outTime

 * @author Administrator
 *
 */
public class Detailed {
    private String orderId;
    private String detailedId;
    private Date   detailedTime;
    private int menuId;
    private String menuName;
    private int num;
	private int dishesStatus;
    private Date stateTime;
    private Date outTime;
    private int menuPrice;

	
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDetailedId() {
		return detailedId;
	}
	public void setDetailedId(String detailedId) {
		this.detailedId = detailedId;
	}
	public Date getDetailedTime() {
		return detailedTime;
	}
	public void setDetailedTime(Date detailedTime) {
		this.detailedTime = detailedTime;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDishesStatus() {
		return dishesStatus;
	}
	public void setDishesStatus(int dishesStatus) {
		this.dishesStatus = dishesStatus;
	}
	public Date getStateTime() {
		return stateTime;
	}
	public void setStateTime(Date stateTime) {
		this.stateTime = stateTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
}
