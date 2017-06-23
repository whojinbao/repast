package com.zf.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilService {
	public PageUtil sel(Integer currPage,Integer pageSize,List list){
		PageUtil util = new PageUtil();

		//��util ��count��ֵ 
		int count = list.size();   
		util.setCount(count);
		//��util ��maxPage��ֵ
		currPage = currPage == null?1:currPage;
		pageSize = pageSize == null?5:pageSize;
		util.setMaxPage(pageSize);
		//�õ�count��pageSize �ȼ������ҳ��allpage
		//������ҳ��allPage
		int allPage;    	 
		allPage=util.getCount()/util.getMaxPage();
		if(util.getCount()%util.getMaxPage()>0){
			allPage++;
		}
		util.setAllPage(allPage);
		//�Ƚ�currpage��ֵ ȷ����ת����ҳ
		if(currPage<1) currPage=1 ;
		if(currPage >= util.getAllPage()) currPage=util.getAllPage();
		//ȷ��currPage���ٸ�util��ֵ  ��ȥ���ݿ��ѯ
		System.out.println("��ǰҳ"+currPage);
		util.setCurrPage(currPage); 

		//�õ��ӵڼ�����ʼ
		int startIndex = (currPage -1) * pageSize;

		//�����ݿ��ѯ�� �õ�������util ��ֵlist
		//�Ѳ�ѯ�Ľ��list ȡ��pageSize��������һ��list����ÿҳ���� ��startIndex��ʼ
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
