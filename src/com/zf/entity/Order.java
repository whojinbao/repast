package com.zf.entity;

import java.util.Date;

/*����ID	�굥ID	                    �µ�ʱ��	���ţ��ͻ�id��	Ա��id	               �ܼ�                              	  �������1��ͣ�2��������                     
orderId	detailedId	orderTimes	seatId	   staffId	  totalPrice              orderSort 
                   ����״̬���Ƿ����  0��δ����һ���µ���1��δ���Ӳˣ�2�����ˣ� orderStatus	 
*/
public class Order {
   private String orderId; 
   private Date orderTimes;
   private  String seatId;
   private String staffId;
   private int orderStatus;
   private int orderSort;
   private int totalPrice;
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}

public Date getOrderTimes() {
	return orderTimes;
}
public void setOrderTimes(Date orderTimes) {
	this.orderTimes = orderTimes;
}
public String getSeatId() {
	return seatId;
}
public void setSeatId(String seatId) {
	this.seatId = seatId;
}
public String getStaffId() {
	return staffId;
}
public void setStaffId(String staffId) {
	this.staffId = staffId;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public int getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(int orderStatus) {
	this.orderStatus = orderStatus;
}
public int getOrderSort() {
	return orderSort;
}
public void setOrderSort(int orderSort) {
	this.orderSort = orderSort;
}
   
}
