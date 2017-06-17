package com.who.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TotalUtil {
	private String seatId;
	private int countNum;
	private int have;
	private String lastTime;
	private String waitTime;
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
	public String getLastTime() {
		return lastTime;
	}
	
	public void setLastTime(Date lastTime) {
		String lastString="--";
		if(lastTime!=null){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 lastString=sdf.format(lastTime);
		}
		
		this.lastTime = lastString;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(Integer waitTime) {
		String lastString="--";
		if(waitTime!=null&&waitTime!=0){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 lastString=sdf.format(waitTime);
		}
		this.waitTime = lastString;
	}
}
