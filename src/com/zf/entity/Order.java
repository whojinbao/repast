package com.zf.entity;

import java.text.SimpleDateFormat;
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
   private float totalPrice;
   private String orTimes;
   
public String getOrTimes() {
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
	orTimes=sdf.format(getOrderTimes());
	return orTimes;
}
public void setOrTimes(String orTimes) {
	this.orTimes = orTimes;
}
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
public float getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(float totalPrice) {
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
