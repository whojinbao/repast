package com.caoqi.order;

import java.util.Date;

public class peiOrder {
	private String id;//����
	Date  orderTimes;//�µ�ʱ��
	int seatId;//����
	String menuName; //��Ʒ
	int totalPrice;//�����۸�
	int caiPrice;//ÿ���˵ļ۸�
	public int getCaiPrice() {
		return caiPrice;
	}
	public void setCaiPrice(int caiPrice) {
		this.caiPrice = caiPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrderTimes() {
		return orderTimes;
	}
	public void setOrderTimes(Date orderTimes) {
		orderTimes = orderTimes;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
