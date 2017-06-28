/*package com.yang.lanjieqi;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yang.dao.Role_authImpl;
import com.yang.model.Role;
import com.yang.model.role_auth;


public class lanjieqi extends MethodFilterInterceptor{

	Role_authImpl ra=new Role_authImpl();
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception{

		HttpServletRequest request=ServletActionContext.getRequest();	
		role_auth ru =new role_auth();
		String uri = request.getRequestURI();//得到请求路径
		System.out.println(request.getRequestURI()+"aaaaaaaaa");		
		List<role_auth> listAR=ra.select(ru);

		for(int i = 0; i < listAR.size(); i++) {
			System.out.println(listAR.get(i).getAddr());
			if(listAR.get(i).getAddr().equals(uri)){
				String result = arg0.invoke();
				return result;
			}
		}
		return "login";
	}		

	}		

		



*/