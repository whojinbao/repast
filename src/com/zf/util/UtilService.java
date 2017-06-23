package com.zf.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilService {
	public PageUtil sel(Integer currPage,Integer pageSize,List list){
		PageUtil util = new PageUtil();

		//给util 的count赋值 
		int count = list.size();   
		util.setCount(count);
		//给util 的maxPage赋值
		currPage = currPage == null?1:currPage;
		pageSize = pageSize == null?5:pageSize;
		util.setMaxPage(pageSize);
		//得到count与pageSize 先计算出总页数allpage
		//计算总页数allPage
		int allPage;    	 
		allPage=util.getCount()/util.getMaxPage();
		if(util.getCount()%util.getMaxPage()>0){
			allPage++;
		}
		util.setAllPage(allPage);
		//比较currpage的值 确定跳转到那页
		if(currPage<1) currPage=1 ;
		if(currPage >= util.getAllPage()) currPage=util.getAllPage();
		//确定currPage后再改util赋值  再去数据库查询
		System.out.println("当前页"+currPage);
		util.setCurrPage(currPage); 

		//得到从第几条开始
		int startIndex = (currPage -1) * pageSize;

		//到数据库查询， 得到结果后给util 赋值list
		//把查询的结果list 取出pageSize条放入另一个list，按每页几条 从startIndex开始
		List list1  = new ArrayList();
		int size = currPage * pageSize;
		if(size>= count){
			size = count;
		}
		for(int i=startIndex;i<size;i++){								
			list1.add(list.get(i));

		} 
		System.out.println(startIndex+"  "+size);
	

		util.setList(list1);
		return util;
	}
}
