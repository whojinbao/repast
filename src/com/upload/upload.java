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
		HttpServletRequest request = ServletActionContext.getRequest();// �ڸ���BaseAction��д�õķ���
		try {
			/**
			 * 1.�����Ʒ
			 * 2.�����ƷͼƬ������·��
			 * 3.�����ƷͼƬ�����ݿ�
			 */
			//saveProduct();
			String names[] = new uploadFile().upload(proFile, proFileFileName);
			
			//ѭ��names���浽���ݿ⡣
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
