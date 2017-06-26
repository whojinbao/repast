package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
		String sql = "insert into orderList values(?,?,?,?,?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*Date dd1=new Date();
    	String ss1=sdf.format(dd1);*/
		String orderTimeStr = sdf.format(order1.getOrderTimes());
		Object[] obj = {order1.getOrderId(),orderTimeStr,
				order1.getSeatId(),order1.getStaffId(), order1.getOrderStatus(),
				order1.getOrderSort(),order1.getTotalPrice()};

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
	 * 对订单的修改
	 * 
	 */
	public void updateOrder(String orderId,int totalPrice,int orderStatus){

		String sql = "update  orderList set totalPrice = ?,orderStatus =? where orderId = ?";
		Object[] obj = {totalPrice,orderStatus,orderId,};
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
				order1.setOrderTimes((Date)rs.getObject(2));
				order1.setSeatId(rs.getInt(3));
				order1.setStaffId(rs.getString(4));				
				order1.setOrderStatus(rs.getInt(5));
				order1.setOrderSort(rs.getInt(6));
				order1.setTotalPrice(rs.getInt(7));				
				orderList.add(order1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	/**
	 * 对订单的查询，模糊查询
	 * 
	 */
	public List<Order> selMhOrder(Date startTime,Date endTime,String mhOredrSeatId){
		String sql = "SELECT * FROM orderList WHERE orderTimes BETWEEN ? AND ? and seatId LIKE '%"+mhOredrSeatId+"%' ";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*Date dd1=new Date();
    	String ss1=sdf.format(dd1);*/
		String startTimeString = sdf.format(startTime);
		String endTimeStr = sdf.format(endTime);
		Object [] obj={startTimeString,endTimeStr};
		ResultSet rs= da1.executeQuery(sql, obj);
		List<Order> orderList = new ArrayList<Order>();
		try {
			while (rs.next()){
				Order order1 = new Order();
				order1.setOrderId(rs.getString(1));	
				order1.setOrderTimes(rs.getDate(2));
				order1.setSeatId(rs.getInt(3));
				order1.setStaffId(rs.getString(4));				
				order1.setOrderStatus(rs.getInt(5));
				order1.setOrderSort(rs.getInt(6));
				order1.setTotalPrice(rs.getInt(7));				
				orderList.add(order1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}


	/**
	 * 对订单的查询，orderId
	 * 
	 */
	public List<Order> selIdOrder(String orderId){
		String sql = "SELECT * FROM orderList WHERE orderId = ?";


		Object [] obj={orderId};
		ResultSet rs= da1.executeQuery(sql, obj);

		List<Order> orderList = new ArrayList<Order>();
		try {
			while (rs.next()){
				Order order1 = new Order();
				order1.setOrderId(rs.getString(1));	
				order1.setOrderTimes(rs.getDate(2));
				order1.setSeatId(rs.getInt(3));
				order1.setStaffId(rs.getString(4));				
				order1.setOrderStatus(rs.getInt(5));
				order1.setOrderSort(rs.getInt(6));
				order1.setTotalPrice(rs.getInt(7));				
				orderList.add(order1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	/**
	 * 
	 */
	public Order getOrder(int seatId){
		String sql2 = "select * from orderList where orderStatus=0 and seatId ="+seatId;
		DaoFactory da1 = new DaoFactory();
		ResultSet rs2 = da1.executeQuery(sql2, null);
        Order order = new Order();
        try {
        	rs2.next();      
			order.setOrderId(rs2.getString(1));
			order.setOrderTimes(rs2.getDate(2));
			order.setSeatId(seatId);
			order.setStaffId(rs2.getString(4));
			order.setOrderStatus(rs2.getInt(5));
			order.setOrderSort(rs2.getInt(6));
			order.setTotalPrice(rs2.getInt(7));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      return order;
	}
}
