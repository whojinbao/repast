package com.who.algorithm;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;
import com.who.util.Sort3Quanzhong;
import com.who.util.Sort3Util;

public class Sort3 {
	private static final List<Dishes> Dishes = null;
	DishesDao dd=new DishesDao();
	List<Dishes> reDishes=dd.getDishes();
	
	public List<Dishes> heList(){
		Combine pp=new Combine();
		List<List<Dishes>> ll=pp.sort(reDishes);
		List<Dishes> ld=new ArrayList<Dishes>();
		for (int i = 0; i < ll.size(); i++) {
			List<Dishes> list=ll.get(i);
			for (int j = 0; j < list.size(); j++) {
				ld.add(list.get(j));
			}
		}
		for (int i = 1; i < ld.size(); i++) {
			for (int j = 0; j < ld.size()-i; j++) {
				Dishes ds1=ld.get(j);
				Dishes ds2=ld.get(j+1);
				if(ds1.getSeatId().size()<=ds2.getSeatId().size()){
					if(ds1.getSeatId().size()==ds2.getSeatId().size()){
						if(ds1.getDoTime()>ds2.getDoTime()){
							ld.set(j, ds2);
							ld.set(j+1, ds1);
						}
					}else{
						ld.set(j, ds2);
						ld.set(j+1, ds1);
					}
				}
			}
		}
		return ld;
	}
	
	private List<Dishes> hahh(){
		List<Dishes> ll=heList();
		long flagTime=600000;
		/*
		 * 统计每桌上一道菜上菜时间与 当前时间的差值su
		 * 计算权重sqz
		 */
		List<Sort3Quanzhong> sqz=new ArrayList<Sort3Quanzhong>();
		List<Sort3Util> su=new ArrayList<Sort3Util>();
		String sql="select * from orderList where orderStatus=0 order by orderTimes desc";
		ResultSet rs=dd.getData(sql, null);
		try {
			while(rs.next()){
				Sort3Util sutil=new Sort3Util();
				sutil.setName(rs.getString("seatId"));
				su.add(sutil);
			}
		} catch (Exception e) {}
		for (int i = 0; i < su.size(); i++) {
			String sql2="select top 1 await,urge,support from orderList o,quanzhong q ,detailed d where orderStatus=0 and q.detailedId=d.detailedId and o.orderId=d.orderId and o.seatId="+su.get(i).getName();
			ResultSet rs2=dd.getData(sql2, null);
			try {
				while(rs2.next()){
					int num=rs2.getInt("await")*rs2.getInt("urge")*rs2.getInt("support");
					if(num<36){
						Sort3Quanzhong sqq=new Sort3Quanzhong();
						sqq.setName(su.get(i).getName());
						sqq.setQuanzhong(num);
						sqz.add(sqq);
					}
				}
			} catch (Exception e) {
			}
			String sql1="select top 1 startTime,orderTimes from detailed d,orderList o,menu m where o.orderStatus=0 and o.orderId=d.orderId and m.menuId=d.menuId and m.menuType=1 and o.seatId="+su.get(i).getName()+" order by startTime desc";
			ResultSet rs1=dd.getData(sql1, null);
			try {
				while(rs1.next()){
					if(rs1.getString("startTime")==null){
						String string=rs1.getString("orderTimes");
						string =string.substring(0,string.length()-2);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date dd=sdf.parse(string);
						Date date=new Date();
						long lg=date.getTime()-dd.getTime();
						su.get(i).setTime(lg);
					}else{
						String string=rs1.getString("startTime");
						string =string.substring(0,string.length()-2);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date dd=sdf.parse(string);
						Date date=new Date();
						long lg=date.getTime()-dd.getTime();
						su.get(i).setTime(lg);
					};
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i < sqz.size(); i++) {		//按照权重进行排序；数值小的在前面
			for (int j = 0; j < sqz.size()-i; j++) {
				if (sqz.get(j).getQuanzhong()>sqz.get(j+1).getQuanzhong()) {
					Sort3Quanzhong llist=sqz.get(j);
					sqz.set(j, sqz.get(j+1));
					sqz.set(j+1, llist);
				}
				
			}
			
		}
		
		
		
		for (int i = 0; i < sqz.size(); i++) {
			String seatid=sqz.get(i).getName();
			for (int j = 0; j < ll.size(); j++) {
				List<String> list= ll.get(j).getSeatId();
				int flag=-1;
				for (int k = 0; k < list.size(); k++) {
					if(seatid.equals(list.get(k))){
						flag=j;
						break;
					}
				}
				if(flag!=-1){
					ll.add(0, ll.get(flag));
					ll.remove(flag+1);
				}
			}
		}
		for (int i = 0; i < su.size(); i++) {
			if(su.get(i).getTime()>flagTime){
				String seatid=su.get(i).getName();
				for (int j = 0; j < ll.size(); j++) {
					List<String> list= ll.get(j).getSeatId();
					int flag=-1;
					for (int k = 0; k < list.size(); k++) {
						if(seatid.equals(list.get(k))){
							flag=j;
							break;
						}
					}
					if(flag!=-1){
						ll.add(0, ll.get(flag));
						ll.remove(flag+1);
						break;
					}
				}
			}
		}
		
		
		return ll;
	}
	
	
	/*
	 * 输出结果
	 */
	public List<Dishes> outPuttimes(){
		Allot cc=new Allot();
		return cc.outPuttimes(hahh()) ;
	}
}
