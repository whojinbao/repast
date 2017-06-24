package com.zf.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Flags.Flag;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.who.getdata.DishesDao;
import com.zf.dao.UseMenuDao;
import com.zf.dao.UseOrderDao;
import com.zf.entity.Detailed;
import com.zf.entity.Order;
import com.zf.entity.util.ShopCartUtil;

public class ShopCartAction {
	/**
	 * ��ͣ��������ﳵ�����빺�ﳵ��
	 * 
	 */

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private UseDetailedAction usedetailedaction = new UseDetailedAction();
	private UseOrderAction  useOrderAction = new UseOrderAction();

	public void order(){
		/**
		 * ��õ��ҳ���ύ������
		 */
		String menuNameStr = request.getParameter("menuName");
		String menuPriceStr =request.getParameter("price");
		String numStr = request.getParameter("num");

		/*String seatId = request.getParameter("3");
		String staffId = request.getParameter("1002");

		String orderSort = request.getParameter("0");*/
		
		
		//float sourceF = Float.parseFloat(sourceStr);
		int menuPrice =Integer.parseInt(menuPriceStr) ;
		int num = Integer.parseInt(numStr);
		//���ݲ�Ʒ����id
		UseMenuDao usemenuDao = new UseMenuDao();
		int menuId = usemenuDao.selName(menuNameStr);

		ShopCartUtil shopCart = new ShopCartUtil();
		shopCart.setMenuId(menuId);
		shopCart.setMenuName(menuNameStr);
		shopCart.setMenuPrice(menuPrice);   	
		shopCart.setNum(num);   	
		String orderSort = "1";
		//�������ﳵ
		HttpSession  shopCartsession= request.getSession();

		/**
		 * ��ȡlist���� ���Ƿ񴴽����ﳵ
		 */
		List<ShopCartUtil> shopCartList1=(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		if(shopCartList1==null){//δ�������ﳵ��ֱ�����
			/**
			 * ������ţ�Ա����    ����״̬���Ƿ���� ��	  ������� ����������ͣ�
			 */
             
			System.out.println(shopCartsession.getAttribute("seatId"));
			System.out.println(shopCartsession.getAttribute("staffId"));	
			
			
			shopCartsession.setAttribute("orderSort", orderSort);



			List<ShopCartUtil> shopCartList = new ArrayList<ShopCartUtil>();
			shopCartList.add(shopCart);

			shopCartsession.setAttribute("shopCartList", shopCartList);
		}else{
			//���й��ﳵ
			/**
			 * ������ţ�Ա����    ����״̬���Ƿ���� ��	  ������� ����������ͣ�
			 */

				
			shopCartsession.setAttribute("orderSort", orderSort);


			/**
			 * �ж��µ�Ĳ��Ƿ�����
			 */	
			int flag = -1;
			List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
			for(int i=0;i<list1.size();i++){
				String name = list1.get(i).getMenuName();
				if(menuNameStr.equals(name)){
					//����Ĳ�����
					num = list1.get(i).getNum()+1;
					list1.get(i).setNum(num);
					shopCartsession.setAttribute("shopCartList", list1);
					flag = 1;
					break;
				}
			}
			if(flag == -1){
				//����Ĳ�û��
				shopCartList1.add(shopCart);
				shopCartsession.setAttribute("shopCartList", shopCartList1);

			}
		}  	

		try {
			getTotalPrice();
			request.getRequestDispatcher("shopCart.jsp").forward(request,response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * ���ﳵ��ɾ��
	 */
	public String del(){
		
		String menuIdStr = request.getParameter("menuId");
		String ip = request.getParameter("ip");
		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		try{
			if(ip != null){
				list1.clear();
				shopCartsession.setAttribute("shopCartList",list1 );
				request.getRequestDispatcher("shopCart.jsp").forward(request,response );
			}else{
				int index = -1;
				int menuId =0;
				try{
					menuId = Integer.parseInt(menuIdStr);
				}catch(Exception e){

				}
				
				for(int i=0;i<list1.size();i++){
					int id = list1.get(i).getMenuId();
					if(menuId == id){
						index = i;
					}
				}
				if(index>-1){
					list1.remove(index);
				}
				shopCartsession.setAttribute("shopCartList",list1 );
				getTotalPrice();
				request.getRequestDispatcher("shopCart.jsp").forward(request,response );
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �����ܼ�,δÿһ�ι��ﳵ���ܼ�
	 */

	public int getTotalPrice(){
		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil> shopCartList2=(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		int totalPrice=0;
		for(int i=0;i<shopCartList2.size();i++){
			int num = shopCartList2.get(i).getNum();
			int price = shopCartList2.get(i).getMenuPrice();
			totalPrice =totalPrice+ num * price;

		}
		shopCartsession.setAttribute("totalPrice", totalPrice);
		return totalPrice;

	}
	/**
	 * ���ɶ�����������seatId��Ա��staffId�������ţ��굥�ţ�
	 */
	public void getOrder(){

		System.out.println("get");
		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil> shopCartList =(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");

		Date newTime = null;
      

		//�ж����������������ǼӲ�
		 System.out.println(shopCartsession.getAttribute("seatId"));
 
      
		int seatId =  (Integer) shopCartsession.getAttribute("seatId"); 
		System.out.println(seatId);
		int flag = -1;
		String orderId3=null;
		int totalPrice = 0;
		/**
		 * �������ѵ㶩�������űȽϡ��鿴�Ƿ����orderStatus;
		 */
		
		String sql="select orderId,totalPrice from orderList where orderStatus=0 and seatId="+seatId;
		DishesDao dd=new DishesDao();
		ResultSet rs=dd.getData(sql, null);		
		try {
			if(rs.next()){	//����˵���Ӳ�
				flag = 0;
				orderId3=rs.getString(1);
				totalPrice=rs.getInt(2);
			}else{	//���������ɶ���
			     flag=1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newTime = new Date();//��ǰʱ��
		if(flag == 1){//�ѽ��ˣ����ɶ�������������
			System.out.println("dingdan");
			shopCartsession.setAttribute("orderTimes", newTime);//�¶���ʱ��

			String orderId1=sdf.format(newTime);
			shopCartsession.setAttribute("orderId", orderId1);//����id
			String detailedId1 = orderId1+"001";
			shopCartsession.setAttribute("detailedTime", newTime);//�¶�������ʱ��
			shopCartsession.setAttribute("detailedId1", detailedId1);

			//����
			Order ordernew = new Order();
			ordernew.setOrderId(orderId1);
			ordernew.setOrderTimes(newTime);
			ordernew.setOrderSort(1);
			ordernew.setOrderStatus(0);
			ordernew.setSeatId(seatId);
			String staffId = (String)shopCartsession.getAttribute("staffId");

			ordernew.setStaffId(staffId);
			//��һ�ε�ͣ����ɶ������ܼ۾��ǣ����ﳵ���ܼ�totalPrice��

			int price2  =(Integer)shopCartsession.getAttribute("totalPrice");
			ordernew.setTotalPrice(price2);			 
			useOrderAction.addOrder(ordernew);


			//�굥
			for(int i=0;i<shopCartList.size();i++){
				System.out.println("s1");
				int menuId = shopCartList.get(i).getMenuId();
				System.out.println("s2");
				int num = shopCartList.get(i).getNum();
				System.out.println("s3");
				Detailed detailednew = new Detailed();
				System.out.println("s4");
				detailednew.setDetailedId(detailedId1);
				System.out.println("s5");
				detailednew.setDetailedTime(newTime);
				System.out.println("s6");
				detailednew.setDishesStatus(0);
				System.out.println("s7");
				detailednew.setMenuId(menuId);
				System.out.println("s8");
				detailednew.setNum(num);
				System.out.println("s9");
				detailednew.setOrderId(orderId1);

				System.out.println("s10");
				usedetailedaction.addDetailed(detailednew);
				System.out.println("s11");
			}
			String sql1="insert into quanzhong(detailedId) values("+detailedId1+")";
			DishesDao d1d=new DishesDao();
			d1d.updateData(sql1,null);




		}else if(flag == 0){//δ���ˣ����ɶ������飬
			System.out.println("xiangdan");
			shopCartsession.setAttribute("detailedTime", newTime);
			String  detailedId1 = sdf.format(newTime)+"002";
			shopCartsession.setAttribute("detailedId1", detailedId1);
			//�ı䶩���ܼ�totalPrice��float menuPrice =Float.parseFloat(menuPriceStr) ;
			int p1 = (Integer) shopCartsession.getAttribute("totalPrice");
			totalPrice = totalPrice+ p1;;

			/**
			 * ����굥���ı䶩���ܼ�totalPrice�����˸ı䶩��״̬orderStatus��
			 */
			useOrderAction.updateOrder(orderId3, totalPrice, 0);

			//����굥
			System.out.println(shopCartList.size());
			for(int i=0;i<shopCartList.size();i++){
				int menuId = shopCartList.get(i).getMenuId();
				int num = shopCartList.get(i).getNum();
				Detailed detailednew = new Detailed();
				detailednew.setDetailedId(detailedId1);
				detailednew.setDetailedTime(newTime);
				detailednew.setDishesStatus(0);
				detailednew.setMenuId(menuId);
				detailednew.setNum(num);
				detailednew.setOrderId(orderId3);
			

				usedetailedaction.addDetailed(detailednew);
			}	
			
			
		/*	try {
				
				request.getRequestDispatcher("order.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
}
