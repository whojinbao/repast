package com.caoqi.waiter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;

public class Impl implements dao{
/*
 * 根据桌子的id改桌子状态
 * 清扫
 */
	public int update(waiter wt) {
		String sql="update zhuo set seatStatusId=? where seatid=?";
		Object[]ob=new Object[]{wt.getSeatStatusId(),wt.getSeatid()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	/*
	 * 结账
	 */
	public int update1(waiter wt){
		String sql="update orderList set orderStatus=? where seatId=?";
		Object[]ob=new Object[]{wt.getOrderStatus(),wt.getSeatid()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	//查询未结账的显示桌面
		public List<waiter> orderSeat(){
			String sql="select z1.seatid,zz.seatStatusName,o1.orderStatus,d1.src from zhuo z1,zhuostatus zz,orderList o1 ,destImg d1 where z1.seatStatusId=zz.seatStatusId and z1.seatid=o1.seatId and z1.imgId=d1.id";
			ResultSet rs=DaoFactory.executeQuery(sql, null);
			List<waiter> lw=new ArrayList<waiter>();
			try {
				while(rs.next()){
					waiter ww=new waiter();
					ww.setSeatid(rs.getString(1));
					ww.setStatusName(rs.getString(2));
					ww.setOrderStatus(rs.getInt(3));
					ww.setImgSrc(rs.getString(4));
					lw.add(ww);
				}
			} catch (Exception e) {
				System.out.println("pp4"+e.getMessage());
			}
			return lw;
		}
	/*
	 * 根据桌子的所座人数和桌子状态查询桌子
	 */
	public List<waiter> select1(waiter wt) {
		// TODO Auto-generated method stub
		String sql="select z1.seatid,z1.maxPerson,d1.src,r1.name,zs.seatStatusName from zhuo z1,destImg d1,room r1,zhuostatus zs where z1.imgId=d1.id and z1.rid=r1.id and z1.seatStatusId=zs.seatStatusId and z1.maxPerson=? and zs.seatStatusName=?";
		Object[]ob=new Object[]{wt.getMaxPerson(),wt.getStatusName()};
		ResultSet rs=DaoFactory.executeQuery(sql, ob);
		List<waiter> lw=new ArrayList<waiter>();
		try {
			while(rs.next()){
				waiter ww=new waiter();
				ww.setSeatid(rs.getString(1));
				ww.setMaxPerson(rs.getInt(2));
				ww.setImgSrc(rs.getString(3));
				ww.setrName(rs.getString(4));
				ww.setStatusName(rs.getString(5));
				lw.add(ww);
			}
		} catch (Exception e) {
			System.out.println("pp3"+e.getMessage());
		}
		return lw;
	}
	/*
	 * 查询的桌子显示在服务员页面
	 */
	public List<waiter> select() {
		// TODO Auto-generated method stub
		String sql="select z1.seatid,z1.maxPerson,d1.src,r1.name,zs.seatStatusName from zhuo z1,destImg d1,room r1,zhuostatus zs where z1.imgId=d1.id and z1.rid=r1.id and z1.seatStatusId=zs.seatStatusId";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<waiter> lw=new ArrayList<waiter>();
		try {
			while(rs.next()){
				waiter ww=new waiter();
				ww.setSeatid(rs.getString(1));
				ww.setMaxPerson(rs.getInt(2));
				ww.setImgSrc(rs.getString(3));
				ww.setrName(rs.getString(4));
				ww.setStatusName(rs.getString(5));
				lw.add(ww);
			}
		} catch (Exception e) {
			System.out.println("pp1"+e.getMessage());
		}
		return lw;
	}
	/*
	 * 查询的桌子显示在服务员中的大厅页面
	 */
	public List<waiter> selectRoom() {
		// TODO Auto-generated method stub
		String sql="select z1.seatid,z1.maxPerson,d1.src,r1.id,zs.seatStatusName from zhuo z1,destImg d1,room r1,zhuostatus zs where z1.imgId=d1.id and z1.rid=r1.id and z1.seatStatusId=zs.seatStatusId and r1.id=10101";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<waiter> lw=new ArrayList<waiter>();
		try {
			while(rs.next()){
				waiter ww=new waiter();
				ww.setSeatid(rs.getString(1));
				ww.setMaxPerson(rs.getInt(2));
				ww.setImgSrc(rs.getString(3));
				ww.setrName(rs.getString(4));
				ww.setStatusName(rs.getString(5));
				lw.add(ww);
			}
		} catch (Exception e) {
			System.out.println("pp"+e.getMessage());
		}
		return lw;
	}
	/*
	 * 查询的桌子显示在服务员中的包厢页面
	 */
	public List<waiter> selectBox() {
		// TODO Auto-generated method stub
		String sql="select z1.seatid,z1.maxPerson,d1.src,r1.id,zs.seatStatusName from zhuo z1,destImg d1,room r1,zhuostatus zs where z1.imgId=d1.id and z1.rid=r1.id and z1.seatStatusId=zs.seatStatusId and r1.id=10102";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<waiter> lw=new ArrayList<waiter>();
		try {
			while(rs.next()){
				waiter ww=new waiter();
				ww.setSeatid(rs.getString(1));
				ww.setMaxPerson(rs.getInt(2));
				ww.setImgSrc(rs.getString(3));
				ww.setrName(rs.getString(4));
				ww.setStatusName(rs.getString(5));
			
				lw.add(ww);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lw;
	}

}
