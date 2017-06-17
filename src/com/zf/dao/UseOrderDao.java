package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.zf.entity.Order;



/***
 *对订单的添加，删除，查询操作（全部）
 * @param 
 * 
 */
public class UseOrderDao {
	private DaoFactory da1 = new DaoFactory();
	
	/**
	 * 对订单的添加
	 * 
	 */
	public void addOrder(Order order1){
		String sql = "insert into orderList values(?,?,?,?,?,?,?,)";
		Object[] obj = {order1.getOrderId(),order1.getOrderTimes(),
				   order1.getSeatId(),order1.getStaffId(),order1.getTotalPrice(),
				   order1.getOrderStatus(),order1.getOrderSort()};
		da1.executeUpdate(sql, obj);
	}
	
	/**
	 * 对订单的删除
	 * 
	 */
	public void delOrder(int orderId){
		String sql = "delete  from orderList where orderId in(?) ";
		Object[] obj = {orderId};
		da1.executeUpdate(sql, obj);
	}
	
	/**
	 * 对订单的查询，全部数据
	 * 
	 */
	public List<Order> selOrder(){
		 String sql = "select * from orderList";
		ResultSet rs= da1.executeQuery(sql, null);
		List<Order> orderList = new ArrayList<Order>();
		try {
			while (rs.next()){
				Order order1 = new Order();
				order1.setOrderId(rs.getString(1));
				System.out.println(rs.getString(1));
				order1.setOrderTimes((Date)rs.getObject(2));
				order1.setSeatId(rs.getInt(3));
				order1.setStaffId(rs.getInt(4));
				order1.setTotalPrice(rs.getFloat(5));
				order1.setOrderStatus(rs.getInt(6));
				order1.setOrderSort(rs.getInt(7));
				orderList.add(order1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return orderList;
	}
}
