package com.who.getdata;
import java.util.Date;
/*
 * 获取桌号、总数量、已上、最后上餐时间、预计等待时间的实体类
 */
public class Total {
	private String seatId;
	private int countNum;
	private int have;
	private Date lastTime;
	private int waitTime;
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
	public int getHave() {
		return have;
	}
	public void setHave(int have) {
		this.have = have;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	
}
