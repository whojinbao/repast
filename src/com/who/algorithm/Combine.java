package com.who.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.who.getdata.Dishes;
import com.who.getdata.DishesDao;

public class Combine {
	DishesDao dd=new DishesDao();
	List<Dishes> liDishes=dd.getDishes();
	List<String> liNum=dd.getDetailed();
	/*
	 * ���ݿ��ж�ȡ����ֵ���з���
	 * ÿһ���������ݷŽ�һ��List<Dishes>��
	 * �����������ݷŽ�List<List<Dishes>>�У��䳤��Ϊ�¹�����������δ���˵ĵ���̨���ܺ�
	 * ����Ȩ�س˻�������Dishes���е�product�����У�
	 */
	private List<List<Dishes>> divide(){
		List<List<Dishes>> lli=new ArrayList<List<Dishes>>();
		for (int i = 0; i < liNum.size(); i++) {			//����
			List<Dishes> ld=new ArrayList<Dishes>();
			String b=liNum.get(i);
			int flag=-1;
			for (int j = 0; j < liDishes.size(); j++) {
				String a=liDishes.get(j).getDetailedId().get(0);
				if (a.equals(b)) {
					ld.add(liDishes.get(j));
					flag=1;
				}
			}
			if(flag==1){
				lli.add(ld);
			}
		}
		for (int i = 0; i < lli.size(); i++) {		
			List<Dishes> ld=lli.get(i);
			for (int j = 0; j < ld.size(); j++) {
				Dishes dd=ld.get(j);
				List<Integer> num=dd.getSeat();
				int sum=num.get(0)*num.get(1)*num.get(2);
				dd.setProduct(sum);
			}
		}
		return lli;
	}
	/*
	 * List<Dishes>�ڵ�ֵ����ð������
	 * ÿһ��������ʱ����д�С������ֵС����ǰ��
	 * ����Ȩ�ؽ���������ֵС����ǰ��
	 */
	private List<List<Dishes>> maopaopaixu(){
		List<List<Dishes>> aa= new ArrayList<List<Dishes>>();
		List<List<Dishes>> ll=divide();
		for (int n = 0; n < ll.size(); n++) {			//ÿ��������ʱ���������
			List<Dishes> llist=ll.get(n);
			for (int i = 1; i < llist.size(); i++) {
				for (int j = 0; j < llist.size()-i; j++) {
					if(llist.get(j).getDoTime()>llist.get(j+1).getDoTime()){
						Dishes dd=llist.get(j);
						llist.set(j, llist.get(j+1));
						llist.set(j+1, dd);	
					}
				}
			}
			aa.add(llist);
		}
		for (int i = 1; i < aa.size(); i++) {		//����Ȩ�ؽ���������ֵС����ǰ��
			for (int j = 0; j < aa.size()-i; j++) {
				if (aa.get(j).get(0).getProduct()>aa.get(j+1).get(0).getProduct()) {
					List<Dishes> llist=aa.get(j);
					aa.set(j, aa.get(j+1));
					aa.set(j+1, llist);
				}
				
			}
			
		}
		return aa;
	}
	/*
	 * �ֲ�
	 * ��������������Ĳ˽��в��
	*/
	private List<List<Dishes>> fencai(int i,int j,List<List<Dishes>> ll,int max){
		Dishes din=ll.get(i).get(j);
		String a=din.getQuantity().get(0);
		String max1=Integer.toString(max);
		din.getQuantity().add(0, max1);
		din.getQuantity().remove(1);
		Dishes dink=new Dishes();
		List<String> ss=new ArrayList<String>();
		ss.add(din.getDetailedId().get(0));
		dink.setDetailedId(ss);
		dink.setDoTime(din.getDoTime());
		dink.setMaxNum(din.getMaxNum());
		dink.setMenuId(din.getMenuId());
		dink.setMenuName(din.getMenuName());
		dink.setProduct(din.getProduct());
		List<String> num=new ArrayList<String>();
		int ab=Integer.parseInt(a)-max;
		String abc=Integer.toString(ab);
		num.add(abc);
		dink.setQuantity(num);
		dink.setSeat(din.getSeat());
		dink.setSeatId(din.getSeatId().get(0));
		j++;
		ll.get(i).add(j, dink);
		if(ab>max){fencai(i,j,ll,max);}
		return ll;
	};
	/*
	 * ��ͬ��Ʒ���кϲ�
	 */
	public List<List<Dishes>> sort(){
		List<List<Dishes>> ll =maopaopaixu();
		
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i).size(); j++) {
				Dishes din=ll.get(i).get(j);
				int num=0;
				for (int k = 0; k < din.getQuantity().size(); k++) {
					num+=Integer.parseInt(din.getQuantity().get(k));
				}
				if (num<din.getMaxNum()) {
					int flag=-1;
					for (int k = i+1 ; k < ll.size(); k++) {
						for (int k2 = 0; k2 < ll.get(k).size(); k2++) {
							Dishes dink=ll.get(k).get(k2);
							if(din.getMenuId()==dink.getMenuId()){
								int num_1=0;
								for (int k_1 = 0; k_1 < din.getQuantity().size(); k_1++) {
									num_1 +=Integer.parseInt(din.getQuantity().get(k_1));
								}
								int num_2=Integer.parseInt(dink.getQuantity().get(0));
								if (num_1+num_2<=din.getMaxNum()) {
									din.getSeatId().add(dink.getSeatId().get(0));
									din.getDetailedId().add(dink.getDetailedId().get(0));
									din.getQuantity().add(dink.getQuantity().get(0));
									ll.get(k).remove(k2);
									k2--;
									if(num_1+num_2==din.getMaxNum()){
										flag=1;
									}
									break;
								}else{
									din.getSeatId().add(dink.getSeatId().get(0));
									int minnun=din.getMaxNum()-num_1;
									din.getQuantity().add(Integer.toString(minnun));
									din.getDetailedId().add(dink.getDetailedId().get(0));
									dink.getQuantity().set(0, Integer.toString(Integer.parseInt(dink.getQuantity().get(0))-minnun));
									flag=1;
									break;
								}
							}
						}
						if (flag==1) {
							break;
						}
						
						
						
					}
				}else if (num>din.getMaxNum()){         //���÷ֲ˷���
					ll=fencai(i,j,ll,din.getMaxNum());
				}
			}
		}
		return ll;
	}
}
