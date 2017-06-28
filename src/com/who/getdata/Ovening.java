package com.who.getdata;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ovening {
	private String[] seatId;
	private String menuId;
	private String menuName;
	private int maxNum;
	private int doTime;
	private String[] detailedId;
	private String startTime;
	private int EWT;
	private int percentage;
	private String[] detailednum;
	private String waitTime;
	public String getWaitTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:00");
		Date date=new Date();
		long ll=date.getTime()+getEWT()*60000;
		waitTime=sdf.format(ll);
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public int getPercentage() {
		percentage=99;
		if(EWT>0){
			percentage=(doTime*60000-EWT)*100/(doTime*60000);
		}
		return percentage;
	}
	public int getEWT() {
		return EWT/60000;
	}
	public void setEWT(int eWT) {
		EWT = eWT+8000;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getDoTime() {
		return doTime;
	}
	public void setDoTime(int doTime) {
		this.doTime = doTime;
	}
	public String[] getSeatId() {
		return seatId;
	}
	public void setSeatId(String[] seatId) {
		this.seatId = seatId;
	}
	public String[] getDetailedId() {
		return detailedId;
	}
	public void setDetailedId(String[] detailedId) {
		this.detailedId = detailedId;
	}
	public String[] getDetailednum() {
		return detailednum;
	}
	public void setDetailednum(String[] detailednum) {
		this.detailednum = detailednum;
	}
}
