package com.caoqi.waiter;
public class waiter {
	private  String seatid;//桌号
	private int maxPerson;//可坐人数
	private int seatStatusId;//状态id
	private String statusName;//状态名
	private String rName;//房间名
	private String imgSrc;//图片路径
	private String staffName;//服务员名
	int orderStatus;//是否结账
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getSeatStatusId() {
		return seatStatusId;
	}
	public void setSeatStatusId(int seatStatusId) {
		this.seatStatusId = seatStatusId;
	}
	public String getSeatid() {
		return seatid;
	}
	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}
	public int getMaxPerson() {
		return maxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
}
