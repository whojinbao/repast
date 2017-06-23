package com.zf.util;

import java.util.List;

public class PageUtil {
	private int count;              //总条数
	private List list;              //查询结果集
	private int   allPage;            //总页数
	private int maxPage;               //每页几条
	private String pageStr;            //分页链接
	private int currPage;               //当前页码
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public String getPageStr() {
		StringBuffer sb =new StringBuffer();
		sb.append("<a href='?currPage=1&pageSize="+getMaxPage()+"'>首页</a>");
		sb.append("<a href='?currPage="+Integer.toString(getCurrPage()-1)+ "&pageSize="+getMaxPage()+"'>上一页</a>");
		sb.append("第  "+getCurrPage()+" 页");
		sb.append("<a href='?currPage="+Integer.toString(getCurrPage()+1)+ "&pageSize="+getMaxPage()+"'>下一页</a>");
		sb.append("<a href='?currPage="+getAllPage()+"&pageSize="+getMaxPage()+"'>尾页</a>");
		//sb.append("<form action='SelectStudentServlet' method='post'/><input type='text' name='tiaoyema'/><input type='submit' value='跳页'/></form>");
		return sb.toString();
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
}
