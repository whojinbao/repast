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
 *     �Բ�Ʒ����menuType�Ĳ���
 *     ����ҳ�� ����ҳ��������ݣ�menuType.jsp������ӵ����ݿ�
 *     ����dao���̣��������ݿ�
 *     ��������
 * @author Administrator
 *
 */
public class UseMenuTypeAction {

	private UseMenuTypeDao  useTypeDao = new UseMenuTypeDao();
	private UtilService utilService = new UtilService();
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
	 * ��֤�Ƿ�����
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
