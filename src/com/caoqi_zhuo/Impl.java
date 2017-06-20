package com.caoqi_zhuo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;




public class Impl implements dao {

	/*
	 * 桌子的添加
	 */
	public int addZhuo(zhuo zz) {
		String sql="insert into zhuo values(?,?,?,?,?,?)";
		Object[]ob=new Object[]{zz.getSeatid(),zz.getMaxPerson(),zz.getSeatStatus(),zz.getStaffId(),zz.getImgid(),zz.getRid()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	/*
	 * 桌子的状态的改变
	 */
	public int update(zhuo zz) {
		String sql="update zhuo set seatStatusId=? where seatid=?";
		Object[]ob=new Object[]{zz.getSeatStatus(),zz.getSeatid()};
		return DaoFactory.executeUpdate(sql, ob);
	}
	/*
	 * 桌子的删除
	 */
	public int delete(zhuo zz) {
		String sql="delete from zhuo where seatid=?";
		Object [] params={zz.getSeatid()};	
		return DaoFactory.executeUpdate(sql, params);
	}
	/*
	 * 桌子的查询
	 */
	public List<zhuo> select1() {
		String sql="select * from zhuo ";
		List<zhuo> lc=new ArrayList<zhuo>();
		ResultSet rs=null;
		rs=DaoFactory.executeQuery(sql, null);
		try {
			while(rs.next()){	
				zhuo zz=new zhuo();
				zz.setSeatid(rs.getInt(1));
				zz.setMaxPerson(rs.getInt(2));
				zz.setSeatStatus(rs.getInt(3));
				zz.setStaffId(rs.getInt(4));
				zz.setImgid(rs.getInt(5));
				zz.setRid(rs.getInt(6));
				lc.add(zz);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lc;
	}
}