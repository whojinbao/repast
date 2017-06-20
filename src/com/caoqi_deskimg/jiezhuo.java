package com.caoqi_deskimg;

public class jiezhuo {
	private int seatid;//桌子编号
	private int maxPerson;//桌子可座人数
	private int staffId;//服务员号
	private String src;//桌子图片的路径
	private String staticName;//桌子的状态
	public String getStaticName() {
		return staticName;
	}
	public void setStaticName(String staticName) {
		this.staticName = staticName;
	}
	public int getSeatid() {
		return seatid;
	}
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
	public int getMaxPerson() {
		return maxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
