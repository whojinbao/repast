package com.who.getdata;
import java.util.Date;
/*
 * ��ȡ���š������������ϡ�����ϲ�ʱ�䡢Ԥ�Ƶȴ�ʱ���ʵ����
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
