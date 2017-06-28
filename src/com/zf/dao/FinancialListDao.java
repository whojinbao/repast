package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.publics.dao.DaoFactory;
import com.zf.entity.util.menuUtil;
import com.zf.entity.util.orderUtil2;

public class FinancialListDao {
	private DaoFactory da1 =new DaoFactory();	
	
	//菜品欢迎程度
	public  List<menuUtil> getMenu(String startTime,String endTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime += " 00:00:00";
		endTime +=" 23:59:59";
		  //得到每样菜对应的数量
		/*String sql1 = "select m1.menuName ,d1.detailednum from orderList o1,menu m1 ,detailed d1 " +
				     "where  o1.orderId = d1.orderId and m1.menuId = d1.menuId " +
				    "and orderTimes BETWEEN '"+startTime+"' AND '"+endTime+"'";*/
		String sql1="select o1.orderTimes,m1.menuName ,d1.detailednum from orderList o1,menu m1 ,detailed d1  " +
				   " where  o1.orderId = d1.orderId and m1.menuId = d1.menuId " +
				   "and orderTimes BETWEEN '"+startTime+"' AND '"+endTime+"' ORDER BY o1.orderTimes desc ";
		ResultSet rs = da1.executeQuery(sql1, null);
		 //得到所有的菜名
	    String sql2 = "select menuName from menu";
	    ResultSet rs2 = da1.executeQuery(sql2, null);
	    //得到每样菜对应的数量
	    List<menuUtil> menuUtils= new ArrayList<menuUtil>();
	 	    		
		try {
			 while(rs2.next()){
			    menuUtil m1 = new menuUtil();
			    //把每样菜放到lsit，默认数量为0
			    m1.setMenuName(rs2.getString(1));
			    m1.setNum(0);
			    m1.setShowTime("");
			    menuUtils.add(m1);			  
			 }
			 while(rs.next()){
					String name1 = rs.getString(1);
					int num1 = rs.getInt(2);
					for(int i=0;i<menuUtils.size();i++){	
					    menuUtil m2 = menuUtils.get(i);
					    String name2 = m2.getMenuName();
					    //有相同菜名，数量累加
					    int num2 = m2.getNum();
					    if(name2.equals(name1)){
					    	num2 = num2+num1;
					    	m2.setNum(num2);
					    }																		
					 }			   
		        }
			 //清空表中数据
			 String sql4 = "truncate table menuUtil";
			 da1.executeUpdate(sql4, null);
			 for(int i=0;i<menuUtils.size();i++){
				    menuUtil m2 = menuUtils.get(i);
				    String name2 = m2.getMenuName();
				    int num2 = m2.getNum();
				   //添加数据库
				    String sql3 = "insert into menuUtil(menuName,num) values(?,?)";
					Object[] obj = {name2,num2};
					da1.executeUpdate(sql3, obj);
			 }
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
         return menuUtils;
		
	}
	
	/**
	 * 得到排名前3 的菜
	 */
	
	public List<menuUtil> getGoodMenu(String startTime,String endTime){
		List<menuUtil> countmenu= getMenu(startTime,endTime);//得到所有菜与数量
		 String sql5 = "select top 3 menuName,num from menuUtil ORDER BY num desc  ";
		 ResultSet rs = da1.executeQuery(sql5, null);
		 List<menuUtil> menuUtils1  = new ArrayList<menuUtil>();
		 /**
			 * 得到菜的总数量
			 * 得到菜所占比重
			 */
		int countNum = countmenu.size();
		
		 try {
			while(rs.next()){
				 menuUtil m1 = new  menuUtil();
				 m1.setMenuName(rs.getString("menuName"));
				 m1.setNum(rs.getInt("num"));
				 int xx = m1.getNum()*100/countNum;
				 String xxstr = xx+"%";
				 m1.setScale(xxstr);
				 menuUtils1.add(m1);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return menuUtils1;
	}
	
	/**
	 * 得到排名靠后的菜
	 */
	public List<menuUtil> getBadMenu(String startTime,String endTime){
		List<menuUtil> countmenu= getMenu(startTime,endTime);//得到所有菜与数量
		 String sql4 = "select top 3 menuName,num from menuUtil ORDER BY num ASC  ";
		 ResultSet rs = da1.executeQuery(sql4, null);
		 List<menuUtil> menuUtils1  = new ArrayList<menuUtil>();
		 /**
			 * 得到菜的总数量
			 * 得到菜所占比重
			 */
		 int countNum = countmenu.size();
		 try {
			while(rs.next()){
				 menuUtil m1 = new  menuUtil();
				 m1.setMenuName(rs.getString("menuName"));
				 m1.setNum(rs.getInt("num"));
				 int xx = m1.getNum()*100/countNum;
				 String xxstr = xx+"%";
				 m1.setScale(xxstr);
				 menuUtils1.add(m1);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return menuUtils1;
	}
	
	/**
	 * 得到订单表
	 * 计算总单数，总金额，平均金额
	 */
	public orderUtil2 getOrderPrice(String startTime,String endTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime += " 00:00:00";
		endTime +=" 23:59:59";
		String sql1 = "select totalPrice from orderList where orderTimes BETWEEN '"+startTime+"' AND '"+endTime+"'";
		String sql2 = "select COUNT(*) 总单数,DATEDIFF(DD,'"+startTime+"','"+endTime+"' ) 天数 from orderList where orderTimes BETWEEN '"+startTime+"' AND '"+endTime+"' ";
		ResultSet rs1 = da1.executeQuery(sql1, null);
		ResultSet rs2 = da1.executeQuery(sql2, null);
		orderUtil2 orderutil2 = new orderUtil2();
		//得到总单数，总天数，总金额
		float totalPrice = 0;
		int dates = 0;
		int ordersize = 0;
		//日均，每单金额
		float avgPrice;
		float avgorderPrice;
		try {
			while(rs1.next()){
			  totalPrice += rs1.getFloat(1);	
			}
			while(rs2.next()){
				ordersize = rs2.getInt(1);
				dates = rs2.getInt(2);
			}
			
			avgPrice = totalPrice/dates;
			avgorderPrice = totalPrice/ordersize;
			
			orderutil2.setTotalPrice(totalPrice);
			orderutil2.setAvgorderPrice(avgorderPrice);
			orderutil2.setAvgPrice(avgPrice);
			orderutil2.setTotalOrder(ordersize);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderutil2;
		
	}
 	
	
	
	
	
	
	
	
}
