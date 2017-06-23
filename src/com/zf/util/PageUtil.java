package com.zf.util;

import java.util.List;

public class PageUtil {
	private int count;              //������
	private List list;              //��ѯ�����
	private int   allPage;            //��ҳ��
	private int maxPage;               //ÿҳ����
	private String pageStr;            //��ҳ����
	private int currPage;               //��ǰҳ��
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
		sb.append("<a href='?currPage=1&pageSize="+getMaxPage()+"'>��ҳ</a>");
		sb.append("<a href='?currPage="+Integer.toString(getCurrPage()-1)+ "&pageSize="+getMaxPage()+"'>��һҳ</a>");
		sb.append("��  "+getCurrPage()+" ҳ");
		sb.append("<a href='?currPage="+Integer.toString(getCurrPage()+1)+ "&pageSize="+getMaxPage()+"'>��һҳ</a>");
		sb.append("<a href='?currPage="+getAllPage()+"&pageSize="+getMaxPage()+"'>βҳ</a>");
		//sb.append("<form action='SelectStudentServlet' method='post'/><input type='text' name='tiaoyema'/><input type='submit' value='��ҳ'/></form>");
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
