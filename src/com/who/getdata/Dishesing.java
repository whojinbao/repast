package com.who.getdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Dishesing {
	private List<String> seatId=new ArrayList<String>();
	private int menuId;
	private String menuName;
	private int maxNum;
	private int doTime;
	private List<String> detailedId =new ArrayList<String>();
	private Date startTime;
	private int EWT;
	private int percentage;
	private List<Integer> detailednum=new ArrayList<Integer>();
	
	public int getPercentage() {
		percentage=99;
		if(EWT>0){
			percentage=(doTime*60000-EWT)*100/(doTime*60000);
		}
		return percentage;
	}
	public List<Integer> getDetailednum() {
		return detailednum;
	}
	public void setDetailednum(int detailednum) {
		this.detailednum.add(detailednum);
	}
	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}
	public int getEWT() {
		return EWT/60000;
	}
	public void setEWT(int eWT) {
		EWT = eWT;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public List<String> getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId.add(seatId);
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
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
	public List<String> getDetailedId() {
		return detailedId;
	}
	public void setDetailedId(String detailedId) {
		this.detailedId.add(detailedId);
	}
	public void setDetailedId(List<String> detailedId) {
		this.detailedId=detailedId;
	}
	
	
}
