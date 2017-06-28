package com.zf.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zf.dao.UseMenuDao;
import com.zf.dao.UseMenuTypeDao;
import com.zf.entity.Menu;
import com.zf.entity.MenuType;
import com.zf.entity.util.orderUtil;
import com.zf.service.SelTyMenuService;
import com.zf.util.PageUtil;
import com.zf.util.UploadFile;
import com.zf.util.UtilService;


/**
 *     对菜品 menu的操作
 *     上启页面 ，从页面坚守数据（menu.jsp），添加到数据库
 *     下启dao工程，链接数据库
 *     更新数据
 * @author Administrator
 *
 */
public class UseMenuAction extends ActionSupport{

	private UseMenuDao useMenu = new UseMenuDao();
	private UtilService utilService = new UtilService();
	private SelTyMenuService selTyMenuService = new SelTyMenuService();
	//接受菜品添加的图片
	private File[] menuFile;
	private String[] menuFileFileName;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response =ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	private Menu menu = new Menu();



	/**
	 * addMenu() 往菜品中添加新菜品
	 * 
	 * @return
	 */

	public String addMenu(){
		String path = request.getRealPath("/");
		System.out.println(menuFile);
		System.out.println(menuFileFileName);
		System.out.println(path);
		try {
			/**
			 * 1.保存产品
			 * 2.保存产品图片到物理路径
			 * 3.保存产品图片到数据库
			 */
			//saveProduct();
			
		   
            
			String names[] = new UploadFile().upload(menuFile, menuFileFileName, path);
			//循环names保存到数据库。
			for(int i=0;i<names.length;i++){
				System.out.println(names[i]);
				
				menu.setImgUrl(names[i]);
			}
			useMenu.addMenu(menu);

			selMenu();
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("menu", menu);
			return "error";
		}				
		return "ok";
	}

	/**
	 * del() 往菜品分类中删除分类
	 * typeId 接受的分类id
	 * @return
	 */
	public String del(){

		int menuId =Integer.parseInt(request.getParameter("menuId")) ;	   
		useMenu.delMenu(menuId);
		selMenu();
		return "ok";
	}	


	/**
	 *updateMenu() 修改菜品
	 * 
	 * @return
	 */
	public String updateMenu(){
		System.out.println("update");
		useMenu.updateMenu(menu);
		selMenu();
		return "ok";
	}	
	/**
	 * selMenu() 查询数据库中菜品(所有) 
	 *
	 * @return
	 */
	public String selMenu(){
	    
		List<Menu> menuList = useMenu.selMenu();	
		String currPageStr = request.getParameter("currPage");
		String pageSizeStr = request.getParameter("pageSize");
		Integer currPage = null;
		Integer pageSize = null;
		try{
			currPage = Integer.parseInt(currPageStr);
		}catch(Exception e){

		}
		PageUtil util = utilService.sel(currPage, pageSize, menuList);
		session.setAttribute("MenuPageUtil", util);
		return "ok";
	}

	/**
	 * selTyMenu() 查询数据库中菜品,按菜类
	 *
	 * @return
	 */
	public String selTyMenu(){
		System.out.println("ty");
		/*String typeName = request.getParameter("typeName");*/
		
		List<orderUtil> util = selTyMenuService.getList();
		session.setAttribute("orderUtilList",util );
		try {
			request.getRequestDispatcher("diancan.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * selIdMenu() 查询数据库中菜品,按菜品id
	 * 在修改菜品中使用
	 * @return
	 */
	public String selIdMenu(){
		Integer menuId = Integer.parseInt(request.getParameter("menuId"));
		Menu menu =useMenu.selIdMenu(menuId);	
		session.setAttribute("menu", menu);
		try {
			request.getRequestDispatcher("menuUpdate.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
  
	/**
	 * selMhMenu() 模糊查询，按菜品名称
	 *
	 * @return
	 */
	public String selMhMenu(){
		System.out.println("mh");
		String menuName= request.getParameter("menuName");
		System.out.println(menuName);
		List<Menu> menuList =useMenu.selMhMenu(menuName);
		String currPageStr = request.getParameter("currPage");
		String pageSizeStr = request.getParameter("pageSize");
		Integer currPage = null;
		Integer pageSize = null;
		try{
			currPage = Integer.parseInt(currPageStr);
		}catch(Exception e){

		}
		PageUtil util = utilService.sel(currPage, pageSize, menuList);
		session.setAttribute("MenuPageUtil", util);

		session.setAttribute("menuList", menuList);
		return "ok";
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public UseMenuDao getUseMenu() {
		return useMenu;
	}
	public void setUseMenu(UseMenuDao useMenu) {
		this.useMenu = useMenu;
	}
	public UtilService getUtilService() {
		return utilService;
	}
	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}
	public File[] getMenuFile() {
		return menuFile;
	}
	public void setMenuFile(File[] menuFile) {
		this.menuFile = menuFile;
	}
	public String[] getMenuFileFileName() {
		return menuFileFileName;
	}
	public void setMenuFileFileName(String[] menuFileFileName) {
		this.menuFileFileName = menuFileFileName;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}

}
