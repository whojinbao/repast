package com.upload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
public class upload extends ActionSupport {
	private File[] proFile;
	private String[] proFileFileName;
	public String addProduct() {
		HttpServletRequest request = ServletActionContext.getRequest();// 在父类BaseAction中写好的方法
		try {
			/**
			 * 1.保存产品
			 * 2.保存产品图片到物理路径
			 * 3.保存产品图片到数据库
			 */
			//saveProduct();
			String names[] = new uploadFile().upload(proFile, proFileFileName);
			
			//循环names保存到数据库。
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			return "error";
		}
		return null;
	}

	public File[] getProFile() {
		return proFile;
	}

	public void setProFile(File[] proFile) {
		this.proFile = proFile;
	}

	public String[] getProFileFileName() {
		return proFileFileName;
	}

	public void setProFileFileName(String[] proFileFileName) {
		this.proFileFileName = proFileFileName;
	}

}
