package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.yang.dao.AuthDao;
import com.yang.dao.AuthDaoImpl;
import com.yang.model.Auth;
import com.yang.util.authUtil;
public class authAction {
	private authUtil aut;
	public authUtil getAut() {
		return aut;
	}
	public void setAut(authUtil aut) {
		this.aut = aut;
	}
	AuthDao ad=new AuthDaoImpl();
	Auth at=new Auth();
	/**
	 * 利用辅助类进行增加方法，把得到的数据存入到session中，并且保存现场
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String save(){
		at.setAuth_id(aut.getAuth_id());
		at.setAuth_name(aut.getAuth_name());
		at.setAuth_info(aut.getAuth_info());
		ad.addAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sa";		
	}
	/**
	 * 利用辅助类进行删除，定义一个参数用来存储删除条件值
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String delete(){
		
		HttpServletRequest resp=ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		at.setAuth_id(a);
		ad.deleteAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv",lv);
		return "sx";
	}
	/**
	 * 更新数据，选定需要更新的对象，并且调用select 方法把值存入session中
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String update(){
		at.setAuth_name(aut.getAuth_name());
		at.setAuth_info(aut.getAuth_info());
		at.setAuth_id(aut.getAuth_id());
		ad.updateAuth(at);
		List<Auth> lv=ad.select();
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sd";
	}
	/**
	 * 查询所有的数据
	 * @return
	 */
	public String select(){
		List<Auth> lv=ad.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lv", lv);
		return "sw";
	}
}
