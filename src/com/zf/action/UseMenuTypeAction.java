package com.zf.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zf.dao.UseMenuTypeDao;
import com.zf.entity.MenuType;

/**
 *     �Բ�Ʒ����menuType�Ĳ���
 *     ����ҳ�� ����ҳ��������ݣ�menuType.jsp������ӵ����ݿ�
 *     ����dao���̣��������ݿ�
 *     ��������
 * @author Administrator
 *
 */
public class UseMenuTypeAction {

	private UseMenuTypeDao  useTypeDao = new UseMenuTypeDao();
    private MenuType menuType = new MenuType();
	/**
	 * �õ�  request ��session
	 */
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();


	public UseMenuTypeDao getUseTypeDao() {
		return useTypeDao;
	}	
	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public void setUseTypeDao(UseMenuTypeDao useTypeDao) {
		this.useTypeDao = useTypeDao;
	}



	/**
	 * add() ����Ʒ��������ӷ���
	 * typeName ���ܵķ�������
	 * @return
	 */

	public String add(){
		String typeName =menuType.getTypeName();
		useTypeDao.Addtype(typeName);
		sel();
		return "ok";
	}

	/**
	 * del() ����Ʒ������ɾ������
	 * typeId ���ܵķ���id
	 * @return
	 */
	public String del(){
		
		 int typeId =Integer.parseInt(request.getParameter("menuTypeId")) ;
		
		useTypeDao.deltype(typeId);
		sel();
		return "ok";
	}
	/**
	 * sel() ��ѯ���ݿ��в�Ʒ����(����)
	 *ip  ҳ������ĵ�ַ ���Ǹ�ҳ��
	 * @return
	 */
	public String sel(){
		
		List<MenuType> menuTypeList = useTypeDao.seltype();
		session.setAttribute("menuTypeList", menuTypeList);
		
		String ip = request.getParameter("ip");
		System.out.println("ip"+ip);
		if(ip == null){	
			return "ok";
		}
		if(ip.equals("addMenu")){
			System.out.println("menuAdd");
			return "menuAdd";
		}
		if(ip.equals("addMenuType")){
			return "ok";
		}
		else{
		    return null;
		}

	}
	
}
