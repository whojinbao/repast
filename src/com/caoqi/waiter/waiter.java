package com.caoqi.waiter;
public class waiter {
	private  String seatid;//����
	private int maxPerson;//��������
	private int seatStatusId;//״̬id
	private String statusName;//״̬��
	private String rName;//������
	private String imgSrc;//ͼƬ·��
	private String staffName;//����Ա��
	int orderStatus;//�Ƿ����
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
