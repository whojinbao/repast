package com.zf.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
		System.out.println("gwc");
		String menuNameStr = request.getParameter("menuName");
		String menuPriceStr =request.getParameter("price");
		String numStr = request.getParameter("num");

		/*String seatId = request.getParameter("3");
		String staffId = request.getParameter("1002");
		String orderSort = request.getParameter("0");*/
		String seatId = "3";
		String staffId="1002";
		String orderSort="0";
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

			shopCartsession.setAttribute("seatId",seatId );
			shopCartsession.setAttribute("staffId", staffId);			
			shopCartsession.setAttribute("orderSort", orderSort);
			List<ShopCartUtil> shopCartList = new ArrayList<ShopCartUtil>();
			shopCartList.add(shopCart);

			shopCartsession.setAttribute("shopCartList", shopCartList);
		}else{
			//���й��ﳵ
			/**
			 * ������ţ�Ա����    ����״̬���Ƿ���� ��	  ������� ����������ͣ�
			 */

			shopCartsession.setAttribute("seatId",seatId );
			shopCartsession.setAttribute("staffId", staffId);			
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

		int seatId = Integer.parseInt((String) shopCartsession.getAttribute("seatId")) ;
		int flag = -1;
		int kk =-1;
		String orderId3=null;
		int totalPrice = 0;
		UseOrderDao useorderDao  = new UseOrderDao();
		List<Order>  orderList =useorderDao.selOrder(); 
		  System.out.println(seatId);
		/**
		 * �ύ�������ѵ㶩�������űȽϡ��鿴�Ƿ����orderStatus;
		 */
		for(int i=0;i<orderList.size();i++){
			int seatId1 = orderList.get(i).getSeatId();
			if(seatId1 == seatId ){
				int orderStatus = orderList.get(i).getOrderStatus();
				if(orderStatus == 1){//����
					flag = 1;
					System.out.println("1");
				}else if(orderStatus == 0){//δ����,
					flag = 0;
					orderId3 = orderList.get(i).getOrderId();
					totalPrice = orderList.get(i).getTotalPrice();
				}
				kk=1;
			}else if(seatId1 != seatId){
				kk=1;
			}
		}
		/**
		 * kk==-1;�ѵ㶩����û�������ӣ����ɶ���
		 */
		if(kk == -1){
			flag = 1;
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
			ordernew.setOrderSort(Integer.parseInt((String) shopCartsession.getAttribute("orderSort")));
			ordernew.setOrderStatus(0);
			ordernew.setSeatId(Integer.parseInt((String) shopCartsession.getAttribute("seatId")));
			ordernew.setStaffId(Integer.parseInt((String) shopCartsession.getAttribute("staffId")));
			//��һ�ε�ͣ����ɶ������ܼ۾��ǣ����ﳵ���ܼ�totalPrice��
			System.out.println(shopCartsession.getAttribute("totalPrice"));
			int price2  = (Integer) shopCartsession.getAttribute("totalPrice");
			ordernew.setTotalPrice(price2);			 
			useOrderAction.addOrder(ordernew);


			//�굥
			for(int i=0;i<shopCartList.size();i++){
				int menuId = shopCartList.get(i).getMenuId();
				int num = shopCartList.get(i).getNum();
				Detailed detailednew = new Detailed();
				detailednew.setDetailedId(detailedId1);
				detailednew.setDetailedTime(newTime);
				detailednew.setDishesStatus(0);
				detailednew.setMenuId(menuId);
				detailednew.setNum(num);
				detailednew.setOrderId(orderId1);
				detailednew.setOutTime(new Date());
				detailednew.setStateTime(new Date());
				usedetailedaction.addDetailed(detailednew);
			}




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
				detailednew.setOutTime(new Date());
				detailednew.setStateTime(new Date());
				System.out.println(menuId);
				System.out.println(newTime);
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
