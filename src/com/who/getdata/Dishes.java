package com.who.getdata;

import java.util.List;
/*
 * 已点菜品实体类（桌号、菜品ID、菜品名称、可炒最大量、数量、用时、权重、详情单ID）
 * 未入锅开炒
 */
public class Dishes {
	private List<String> seatId;
	private int menuId;
	private String menuName;
	private int maxNum;
	private List<Integer> quantity;
	private int doTime;
	private List<Integer> seat;
	private int detailedId;
	private int product;
	private int waiting;
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
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
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
	public int getDetailedId() {
		return detailedId;
	}
	public void setDetailedId(int detailedId) {
		this.detailedId = detailedId;
	}
}
