package com.zf.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.publics.dao.DaoFactory;
import com.zf.dao.UseMenuTypeDao;
import com.zf.entity.MenuType;
import com.zf.util.PageUtil;
import com.zf.util.UtilService;

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
	private UtilService utilService = new UtilService();
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
	 * 验证是否已有
	 */
	public String verify(){
		String  typeName1 = request.getParameter("typeName");
		List<MenuType> menuTypeList = useTypeDao.selName(typeName1);
        
		try {
			if(menuTypeList.size() >0){
				response.getWriter().print(false);
			}else{
				response.getWriter().print(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
		session.setAttribute("MenuTypeList", menuTypeList);

		String currPageStr = request.getParameter("currPage");
		String pageSizeStr = request.getParameter("pageSize");

		Integer currPage = null;
		Integer pageSize = null;
		try{
			currPage = Integer.parseInt(currPageStr);
		}catch(Exception e){

		}     		
		PageUtil util = utilService.sel(currPage, pageSize, menuTypeList);
		session.setAttribute("MenuTypePageUtil",util);

		return "ok";
	}

}
