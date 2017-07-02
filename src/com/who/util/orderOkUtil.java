package com.who.util;

import java.util.ArrayList;
import java.util.List;


public class orderOkUtil {
	private String id;
	private String time;
	private float price;
	private String status;
	private String name;
	private String address;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	List<YOrderOkUtil> list=new ArrayList<YOrderOkUtil>();
	public List<YOrderOkUtil> getList() {
		return list;
	}
	public void setList(List<YOrderOkUtil> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time.substring(0, time.length()-2);
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
