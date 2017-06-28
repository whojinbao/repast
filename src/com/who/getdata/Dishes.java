package com.who.getdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * 已点菜品实体类（桌号、菜品ID、菜品名称、可炒最大量、数量、用时、权重、详情单ID）
 * 未入锅开炒
 */
public class Dishes {
	private List<String> seatId =new ArrayList<String>();
	private int menuId;
	private String menuName;
	private int maxNum;
	private List<String> quantity =new ArrayList<String>();
	private int doTime;
	private List<Integer> seat =new ArrayList<Integer>();
	private List<String> detailedId =new ArrayList<String>();
	private int product;
	private int waiting;
	private String waitTime;
	
	public String getWaitTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:00");
		Date date=new Date();
		long ll=date.getTime()+getWaiting()*60000;
		waitTime=sdf.format(ll);
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public int getWaiting() {
		return waiting;
	}
	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}
	public List<String> getSeatId() {
		return seatId;
	}
	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId.add(seatId);
	}
	public List<String> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<String> quantity) {
		this.quantity = quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity.add(quantity);
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
	public List<Integer> getSeat() {
		return seat;
	}
	public void setSeat(List<Integer> seat) {
		this.seat = seat;
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
