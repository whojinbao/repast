package com.zf.entity;

import java.util.Date;

/*订单ID	详单ID	下单时间	桌号（客户id）	员工id	               总价                                          订单状态（是否结账）	订单类别                     
orderId	detailedId	orderTimes	seatId	staffId	 totalPrice       orderStatus	orderSort  
*/
public class Order {
   private String orderId;
  
   private Date orderTimes;
   private  int seatId;
   private int staffId;
   private float totalPrice;
   private int orderStatus;
   private int orderSort;
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
public int getStaffId() {
	return staffId;
}
public void setStaffId(int staffId) {
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
