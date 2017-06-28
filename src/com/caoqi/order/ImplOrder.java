package com.caoqi.order;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.publics.dao.DaoFactory;

public class ImplOrder {
	/*
	 * ��ѯÿ��������δ���˵Ķ����ţ��Ͷ������ܼ�Ǯ
	 */
	public List<order>select(String str){
		String sql="select o1.orderId,o1.totalPrice from orderList o1,zhuo z1 where o1.seatId=z1.seatid and z1.seatid=? and o1.orderStatus=0";
		Object[]ob=new Object[]{str};
		ResultSet rs=DaoFactory.executeQuery(sql, ob);
		List<order> lo=new ArrayList<order>();
		try {
			while(rs.next()){
				order o2=new order();
				o2.setId(rs.getString(1));
				o2.setTotalPrice(rs.getInt(2));
				lo.add(o2);	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lo;
	}
	public String ovenSum(String dl){
		String sql="select d1.ovenSum from detailed d1,orderList o1 where d1.orderId=o1.orderId and o1.orderId=? and  o1.orderStatus=0";
		Object[]ob=new Object[]{dl};
		ResultSet rs=DaoFactory.executeQuery(sql, ob);
		String st=null;
		try {
			st=Integer.toString(rs.getInt(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return st;
	}
	/*
	 * ��ѯÿ�������еĲ�Ʒ�Լ�ÿ����Ʒ�ļ�Ǯ��
	 */
	public List<order>  select2(String pl){
		String sql="select m1.menuName,m1.menuPrice from orderList o1,menu m1,detailed d1 where o1.orderId=d1.orderId and d1.menuId=m1.menuId  and o1.orderId=?";
		Object[]ob=new Object[]{pl};
		ResultSet rs=DaoFactory.executeQuery(sql, ob);
		List<order> ls=new ArrayList<order>();
		try {
			while(rs.next()){
				order oy=new order();
				oy.setMenuName(rs.getString(1));
				oy.setCaiPrice(rs.getInt(2));
				ls.add(oy);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ls;
	}
}
