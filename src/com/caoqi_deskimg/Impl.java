package com.caoqi_deskimg;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.publics.dao.DaoFactory;

public class Impl implements dao {
	/*
	 * 从桌子表，桌子状态表，桌子图片表，桌子房间表，中的模糊查询
	 * 
	 */
	//所有桌子的查询
	public List<Deskimg> select(){
		String sql="select zh.seatid,zh.maxPerson,zh.staffId,de.src,zz.seatStatusName from zhuo zh,destImg de,room r1,zhuostatus zz where zh.imgId=de.id and zh.rid=r1.id and zh.seatStatusId=zz.seatStatusId order by zh.seatid ";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<Deskimg> ld=new ArrayList<Deskimg>();
		try {
			while(rs.next()){
				Deskimg dd=new Deskimg();
				dd.setSeatid(rs.getInt(1));
				dd.setMaxPerson(rs.getInt(2));
				dd.setStaffId(rs.getInt(3));
				dd.setSrc(rs.getString(4));
				dd.setStaticName(rs.getString(5));
				ld.add(dd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ld;
	}
	//大厅桌子的查询
	public List<Deskimg> select1(){
		String sql="select zh.seatid,zh.maxPerson,zh.staffId,de.src,zz.seatStatusName from zhuo zh,destImg de,room r1,zhuostatus zz where zh.imgId=de.id and zh.rid=r1.id and zh.seatStatusId=zz.seatStatusId and r1.id=10101 order by zh.seatid ";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<Deskimg> ld=new ArrayList<Deskimg>();
		try {
			while(rs.next()){
				Deskimg dd=new Deskimg();
				dd.setSeatid(rs.getInt(1));
				dd.setMaxPerson(rs.getInt(2));
				dd.setStaffId(rs.getInt(3));
				dd.setSrc(rs.getString(4));
				dd.setStaticName(rs.getString(5));
				ld.add(dd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ld;
	}
	//包箱桌子的查询
	public List<Deskimg> select2(){
		String sql="select zh.seatid,zh.maxPerson,zh.staffId,de.src,zz.seatStatusName from zhuo zh,destImg de,room r1,zhuostatus zz where zh.imgId=de.id and zh.rid=r1.id and zh.seatStatusId=zz.seatStatusId and r1.id=10102 order by zh.seatid ";
		ResultSet rs=DaoFactory.executeQuery(sql, null);
		List<Deskimg> ld=new ArrayList<Deskimg>();
		try {
			while(rs.next()){
				Deskimg dd=new Deskimg();
				dd.setSeatid(rs.getInt(1));
				dd.setMaxPerson(rs.getInt(2));
				dd.setStaffId(rs.getInt(3));
				dd.setSrc(rs.getString(4));
				dd.setStaticName(rs.getString(5));
				ld.add(dd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ld;
	}
	/*
	 * 根据桌子表的id改变桌子状态表的name
	 */
	public int update(Deskimg ss) {
		String sql="update zhuo set seatStatusId =(select seatStatusId from zhuostatus where seatStatusName=?) where seatid=?";
		Object[]ob=new Object[]{ss.getStaticName(),ss.getSeatid()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	
}
