package com.zf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.sun.crypto.provider.RSACipher;
import com.zf.entity.Detailed;

/**
 * �Զ�������� detailed ����ӣ�ɾ�����޸ģ���ѯ��ȫ����
 * @author Administrator
 *
 *����ID	                     �굥ID        	�µ�ʱ��	                 ��id	����	       ״̬���Ƿ��ϲˣ�	��ʼʱ��                               �ϲ�ʱ��
  orderId	detailedId	detailedTime	menuId	num	dishesStatus	stateTime	outTime

 */
public class UseDetailedDao {
    private DaoFactory da1 =new DaoFactory();
    
    /**
     * �Զ�������� detailed �����
     */
    public void addDetailed(Detailed detailed1){
    	String sql = "insert into detailed values(?,?,?,?,?,?,?,?)";
    	Object [] obj = {detailed1.getOrderId(),detailed1.getDetailedId(),
    			detailed1.getDetailedTime(),detailed1.getMenuId(),detailed1.getNum(),
    			detailed1.getDishesStatus(),detailed1.getStateTime(),detailed1.getOutTime()};
    	da1.executeUpdate(sql, obj);
    }
    
    
    /**
     * �Զ�������� detailed ��ɾ��
     */
    public void delDetailed(int detailedId){
    	String sql = "delete from detailed where detailedId in(?)";
    	Object[] obj = {detailedId};
    	da1.executeUpdate(sql, obj);
    }
    
    
    /**
     * �Զ�������� detailed �Ĳ�ѯ��ȫ������
     */
    public List<Detailed> selDetailed(Integer orderId){
    	System.out.println("dao");
    	ResultSet rs = null;
    	
    	if( orderId != null){
    		String sql2 = "select * from detailed where orderId = (?) ";
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
				detailed1.setMenuId(rs.getInt(4));
				detailed1.setNum(rs.getInt(5));
				detailed1.setDishesStatus(rs.getInt(6));
				detailed1.setStateTime(rs.getDate(7));
				detailed1.setOutTime(rs.getDate(8));
				detailedList.add(detailed1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return detailedList;
    	
    }
}
