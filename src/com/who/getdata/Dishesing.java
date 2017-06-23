package com.who.getdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Dishesing {
	private List<Integer> seatId=new ArrayList<Integer>();
	private int menuId;
	private String menuName;
	private int maxNum;
	private int doTime;
	private int detailedId;
	private Date startTime;
	private int EWT;
	private List<Integer> detailednum=new ArrayList<Integer>();
	public List<Integer> getDetailednum() {
		return detailednum;
	}
	public void setDetailednum(int detailednum) {
		this.detailednum.add(detailednum);
	}
	public void setSeatId(List<Integer> seatId) {
		this.seatId = seatId;
	}
	public int getEWT() {
		return EWT;
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
	public List<Integer> getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
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
	public int getDetailedId() {
		return detailedId;
	}
	public void setDetailedId(int detailedId) {
		this.detailedId = detailedId;
	}
	
	
}
