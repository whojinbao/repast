package com.zf.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/*订单ID	详单ID	                    下单时间	桌号（客户id）	员工id	               总价                              	  订单类别（1点餐，2，外卖）                     
orderId	detailedId	orderTimes	seatId	   staffId	  totalPrice              orderSort 
                   订单状态（是否结账  0：未，第一次下单，1：未，加菜，2，结账） orderStatus	 
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
