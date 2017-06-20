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
 *     对菜品分类menuType的操作
 *     上启页面 ，从页面坚守数据（menuType.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseMenuTypeAction {

	private UseMenuTypeDao  useTypeDao = new UseMenuTypeDao();
    private MenuType menuType = new MenuType();
	/**
	 * 得到  request ，session
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
	 * add() 往菜品分类中添加分类
	 * typeName 接受的分类名称
	 * @return
	 */

	public String add(){
		String typeName =menuType.getTypeName();
		useTypeDao.Addtype(typeName);
		sel();
		return "ok";
	}

	/**
	 * del() 往菜品分类中删除分类
	 * typeId 接受的分类id
	 * @return
	 */
	public String del(){
		
		 int typeId =Integer.parseInt(request.getParameter("menuTypeId")) ;
		
		useTypeDao.deltype(typeId);
		sel();
		return "ok";
	}
	/**
	 * sel() 查询数据库中菜品分类(所有)
	 *ip  页面请求的地址 ，那个页面
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
