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
import com.zf.entity.util.ShopCartUtil;
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
	private UseMenuTypeAction usemenuTypeAction = new UseMenuTypeAction();

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
		//刷新菜类
		usemenuTypeAction.sel();
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
	 *  菜品验证id
	 * 
	 * @return
	 */
	public String verifyId(){

		String  menuIdStr = request.getParameter("menuId");       
		int menuId = Integer.parseInt(menuIdStr);
		List<Menu> menuList=useMenu.selIdMenu(menuId);

		try {
			if(menuList.size() > 0){
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
	 *  菜品验证NAME
	 * 
	 * @return
	 */
	public String verifyName(){
		String  menuName = request.getParameter("menuName");
		List<Menu> menuList = useMenu.selName(menuName);

		try {
			if(menuList.size()>0){
				response.getWriter().print(false);
			}else{
				response.getWriter().print(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return null;

	}



	/**
	 * del() 菜品删除
	 * 
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

		//刷新菜类
		usemenuTypeAction.sel();	
		try {		
			useMenu.updateMenu(menu);		
			selMenu();

		} catch (Exception e) {		

		}				
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
		UseMenuTypeAction uta =new UseMenuTypeAction();
		uta.sel();
		List<orderUtil> util = selTyMenuService.getList();
		List<ShopCartUtil> ss = (List<ShopCartUtil>)session.getAttribute("shopCartList");
		if(ss!=null){
			List<orderUtil> util1 =getDishesNum(ss,util);
			session.setAttribute("orderUtilList",util1 );
		}else{
			session.setAttribute("orderUtilList",util );
		}
		return "diancan";
	}
	
	/*
	 * 去外卖
	 */
	public String gowaimai(){
		UseMenuTypeAction uta =new UseMenuTypeAction();
		uta.sel();
		List<orderUtil> util = selTyMenuService.getList();
		List<ShopCartUtil> ss = (List<ShopCartUtil>)session.getAttribute("shopCartList");
		if(ss!=null){
			List<orderUtil> util1 =getDishesNum(ss,util);
			session.setAttribute("orderUtilList",util1 );
		}else{
			session.setAttribute("orderUtilList",util );
		}
		return "waimai";
	}
	
	public List<orderUtil> getDishesNum(List<ShopCartUtil> ss,List<orderUtil> util){
		for (int i = 0; i < ss.size(); i++) {
			int id1=ss.get(i).getMenuId();
			for (int j = 0; j < util.size(); j++) {
				List<Menu> list=util.get(j).getMenuList();
				if(list!=null){
					for (int k = 0; k < list.size(); k++) {
						int id2=list.get(k).getMenuId();
						if(id1==id2){
							list.get(k).setNum(ss.get(i).getNum());
						}
					}
				}
			}
		}
		return util;
	}

	/**
	 * selIdMenu() 查询数据库中菜品,按菜品id
	 * 在修改菜品中使用
	 * @return
	 */
	public String selIdMenu(){

		Integer menuId = Integer.parseInt(request.getParameter("menuId"));
		usemenuTypeAction.sel();
		List<Menu> menuList =useMenu.selIdMenu(menuId);	
		Menu menu = menuList.get(0);
		session.setAttribute("menu", menu);		
		return "Update";
	}

	/**
	 * selMhMenu() 模糊查询，按菜品名称
	 *
	 * @return
	 */
	public String selMhMenu(){

		String menuName= request.getParameter("menuName");
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
