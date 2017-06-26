package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.zf.entity.Detailed;

/**
 * 对订单详情表 detailed 的添加，删除，修改，查询（全部）
 * @author Administrator
 *
 *订单ID	                     详单ID        	下单时间	                 菜id	数量	       状态（是否上菜）	开始时间                     上菜时间              类型
  orderId	detailedId	detailedTime	menuId	num	  dishesStatus	stateTime	outTime  detailedtype

 */
public class UseDetailedDao {
    private DaoFactory da1 =new DaoFactory();
    
    /**
     * 对订单详情表 detailed 的添加
     */
    public void addDetailed(Detailed detailed1){
    	String sql = "insert into detailed(orderId,detailedId,detailedTime,menuId,detailednum," +
    			     " dishesStatus) values(?,?,?,?,?,?)";
 	    			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	/*Date dd1=new Date();
    	String ss1=sdf.format(dd1);*/
    	String detailedTimeStr = sdf.format(detailed1.getDetailedTime());
    	Object [] obj = {detailed1.getOrderId(),detailed1.getDetailedId(),
    			detailedTimeStr,detailed1.getMenuId(),detailed1.getNum(),
    			detailed1.getDishesStatus()};    
    	da1.executeUpdate(sql, obj);	
    }
    
    
    /**
     * 对订单详情表 detailed 的删除
     */
    public void delDetailed(int detailedId){
    	String sql = "delete from detailed where detailedId in(?)";
    	Object[] obj = {detailedId};
    	da1.executeUpdate(sql, obj);
    }
    
    
    /**
     * 对订单详情表 detailed 的查询，全部数据
     */
    public List<Detailed> selDetailed(String orderId){
    	ResultSet rs = null;
    	if( orderId != null ){
    		String sql2 = "select d1.orderId,d1.detailedId,d1.detailedTime,m1.menuName,d1.detailednum,m1.menuPrice from detailed d1,menu m1 " +
    				      " where d1.menuId=m1.menuId  and d1.orderId = (?)";
    		Object [] obj = {orderId};
    		 rs= da1.executeQuery(sql2, obj);
    	}else{  
    		String sql1 = "select * from detailed";   		
    		 rs= da1.executeQuery(sql1, null);
    	}
    	
    	List<Detailed> detailedList = new ArrayList<Detailed>();
    	try {
			while(rs.next()){
				Detailed detailed1 = new Detailed();
				detailed1.setOrderId(rs.getString(1));
				detailed1.setDetailedId(rs.getString(2));
				detailed1.setDetailedTime(rs.getDate(3));
				detailed1.setMenuName(rs.getString(4));
				detailed1.setNum(rs.getInt(5));
				detailed1.setMenuPrice(rs.getInt(6));
				detailedList.add(detailed1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return detailedList;
    	
    }
}
