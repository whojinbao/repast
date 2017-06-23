package com.zf.entity;

import java.util.Date;

/*订单ID	详单ID	                    下单时间	桌号（客户id）	员工id	               总价                              	  订单类别（1点餐，2，外卖）                     
orderId	detailedId	orderTimes	seatId	   staffId	  totalPrice              orderSort 
                   订单状态（是否结账  0：未，第一次下单，1：未，加菜，2，结账） orderStatus	 
*/
public class Order {
   private String orderId; 
   private Date orderTimes;
   private  int seatId;
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
public int getSeatId() {
	return seatId;
}
public void setSeatId(int seatId) {
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
