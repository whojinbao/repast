package com.yang.dao;

import com.publics.dao.DaoFactory;
import com.yang.model.YUser;
/**
 * dao模式进行增删改查
 * @author Administrator
 *
 */
public class YUserDao {
	/**
	 * 员工数据添加
	 */
	//private ConPool cop=new ConPool();
	DaoFactory da1=new DaoFactory();
	public void addYu(YUser  yy){
		int flag=-1;
		String sql="insert into staff(userName,userPwd,realName,sex,age,phone,addr,postcode,power) values(?,?,?,?,?,?,?,?,?)";
		Object[] obj ={yy.getUserName(),yy.getUserPwd(),yy.getRealName(),yy.getSex(),
				yy.getAge(),yy.getPhone(),yy.getAddr(),yy.getPostcode(),yy.getPower() };
		/*for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}*/
		da1.executeUpdate(sql, obj);		
	}
	public void delYU(YUser yy){
		String sql="delete from staff where userName=?";
		Object[] obj={yy.getUserName()};
		da1.executeUpdate(sql, obj);
	}
}
