package com.zf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.publics.dao.DaoFactory;
import com.zf.entity.MenuType;


/***
 *�� ��Ʒ�������ӣ�ɾ������ѯ������ȫ����
 * @param typeName  ��Ʒ���������
 * typeId ��Ʒ�����id
 */
public class UseMenuTypeDao {
	private DaoFactory da1 = new DaoFactory();
	
	  /***
	   * Addtype ��Ʒ��������
	   * @param typeName  ��Ʒ���������
	   */
    public void Addtype(String typeName){
        String sql = "insert into menuType values(?)";
    
    	Object[] obj = {typeName};
    	da1.executeUpdate(sql, obj);
    }
    
    /***
	   * deltype ��Ʒ�����ɾ��
	   * @param typeName  ��Ʒ���������
	   * typeId ��Ʒ�����id
	   */
    public void deltype(int id){
    	String sql = "delete from menuType WHERE typeId in(?) ";
    	Object[] obj = {id};
    	da1.executeUpdate(sql, obj);
    }
    
    /***
	   * seltype ��Ʒ����Ĳ�ѯ����ȫ������
	   * @param typeName  ��Ʒ���������
	   *  typeId ��Ʒ�����id
	   */
    public List<MenuType> seltype(){
    	String sql = "select * from menuType ORDER BY typeId ASC";
    	ResultSet rs = da1.executeQuery(sql, null);
    	List<MenuType> menuTypeList = new ArrayList<MenuType>();
		try {				
			while(rs.next()){
				MenuType menutype = new MenuType();
				menutype.setTypeId( (Integer) rs.getObject(1));
				menutype.setTypeName(rs.getString(2));
				menuTypeList.add(menutype);				
			}				
		}
		catch(Exception e){
           return null;
		}
    	return menuTypeList;
    }
}
