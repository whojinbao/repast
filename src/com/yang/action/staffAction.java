package com.yang.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yang.dao.dao;
import com.yang.dao.daoImpl;
import com.yang.model.YUser;
import com.yang.model.peihe;

public class staffAction {
	private peihe pp;
	
	public peihe getPp() {
		return pp;
	}

	public void setPp(peihe pp) {
		this.pp = pp;
	}

	dao dd=new daoImpl();
	YUser yy=new YUser();
	/**
	 * 利用辅助类进行增加方法，把得到的数据存入到session中，并且保存现场
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String save(){
		yy.setUser_id(pp.getUser_id());
		yy.setUser_name(pp.getUser_name());
		yy.setUser_pwd(pp.getUser_pwd());
		yy.setUser_sex(pp.getUser_sex());
		yy.setUser_phone(pp.getUser_phone());
		yy.setUser_age(pp.getUser_age());
		yy.setUser_add(pp.getUser_add());
		yy.setUser_power(pp.getUser_power());
		dd.addYuser(yy);
		List<YUser> lq=dd.select();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ok";
	}
	/**
	 * 利用辅助类进行删除，定义一个参数用来存储删除条件值
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String delete(){
		HttpServletRequest resp=ServletActionContext.getRequest();
		int a=Integer.parseInt(resp.getParameter("a"));
		yy.setUser_id(a);
		dd.delYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "oq";
	}
	/**
	 * 更新数据，选定需要更新的对象，并且调用select 方法把值存入session中
	 * 返回值result在struts中配置路径
	 * @return
	 */
	public String update(){
		/*yy.setRealName(pp.getRealName());
		yy.setSex(pp.getSex());
		yy.setPhone(pp.getPhone());
		yy.setAddr(pp.getAddr());
		yy.setUserName(pp.getUserName());*/
		yy.setUser_name(pp.getUser_name());
		yy.setUser_pwd(pp.getUser_pwd());
		yy.setUser_sex(pp.getUser_sex());
		yy.setUser_phone(pp.getUser_phone());
		yy.setUser_age(pp.getUser_age());
		yy.setUser_add(pp.getUser_add());
		yy.setUser_power(pp.getUser_power());
		yy.setUser_id(pp.getUser_id());
		dd.updateYUser(yy);
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ow";
	}
	/**
	 * 查询所有的数据，存放在session中，并且通过调用显示在页面中
	 * @return
	 */
	public String select(){
		List<YUser> lq=dd.select();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lq", lq);
		return "ot";
	}
}
