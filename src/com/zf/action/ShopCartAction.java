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

import com.publics.dao.DaoFactory;
import com.who.getdata.DishesDao;
import com.zf.dao.UseDetailedDao;
import com.zf.dao.UseMenuDao;
import com.zf.dao.UseOrderDao;
import com.zf.entity.Detailed;
import com.zf.entity.Order;
import com.zf.entity.util.ShopCartUtil;

public class ShopCartAction{
	/**
	 * ��ͣ��������ﳵ�����빺�ﳵ��
	 * 
	 */

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	//�������ﳵ
	HttpSession  shopCartsession= request.getSession();

	private UseDetailedAction usedetailedaction = new UseDetailedAction();
	private UseOrderAction  useOrderAction = new UseOrderAction();

	public String order(){
		/**
		 * ��õ��ҳ���ύ������
		 */
		/**
		 * ������ţ�Ա����    ����״̬���Ƿ���� ��	 
		 */

		String orderSort = "1";// ������� ������0�����1��
		shopCartsession.setAttribute("orderSort", orderSort);
		String menuIdStr = request.getParameter("menuId");
		String menuNameStr = request.getParameter("menuName");
		String menuPriceStr =request.getParameter("price");
		String numStr = request.getParameter("num");
		//float sourceF = Float.parseFloat(sourceStr);
		float menuPrice =Float.parseFloat(menuPriceStr) ;
		int num = Integer.parseInt(numStr);
		int menuId = Integer.parseInt(menuIdStr);	
		//���ҳ�����0��ɾ�����ﳵ������
		if(num == 0){
			del(menuId);
			return null;
		}

		ShopCartUtil shopCart = new ShopCartUtil();
		shopCart.setMenuId(menuId);
		shopCart.setMenuName(menuNameStr);
		shopCart.setMenuPrice(menuPrice);  
		shopCart.setNum(num);
		List<ShopCartUtil>  ShopCartList= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");

		/**
		 * �ж��µ�Ĳ��Ƿ�����
		 */	
		int flag = -1;//û��

		if(ShopCartList == null){//û���ﳵ
			List<ShopCartUtil>  ShopCartList1 = new ArrayList<ShopCartUtil>();
			ShopCartList1.add(shopCart);
			shopCartsession.setAttribute("shopCartList", ShopCartList1);
		}else{
			for(int i=0;i<ShopCartList.size();i++){
				String name = ShopCartList.get(i).getMenuName();
				if(menuNameStr.equals(name)){
					//����Ĳ�����
					ShopCartList.get(i).setNum(num);
					shopCartsession.setAttribute("shopCartList", ShopCartList);
					flag = 1;
					break;
				}

			}
			if(flag == -1){
				//����Ĳ�û��
				ShopCartList.add(shopCart);
				shopCartsession.setAttribute("shopCartList", ShopCartList);

			}
		}
		getTotalPrice();
		return null;
	}

	/**
	 *  ���ﳵ�����
	 */
	public String clear(){

		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		list1.clear();
		shopCartsession.setAttribute("shopCartList",list1 );
	/*	float totalPrice = Float.parseFloat((String) shopCartsession.getAttribute("totalPrice"));*/
		shopCartsession.setAttribute("totalPrice", 0);
		return "shopCart";
	}
	/**
	 * ɾ��һ������
	 */
	public void del(int menuId){
		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		try{
			int index = -1;		
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

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * ���ﳵ��ɾ��
	 */
	public String del(){
		String menuIdStr = request.getParameter("menuId");
		int menuId = Integer.parseInt(menuIdStr);
		del(menuId);
		return "shopCart";
	}

	/**
	 * �����ܼ�,ÿһ�ι��ﳵ���ܼ�
	 */

	public float getTotalPrice(){

		List<ShopCartUtil> shopCartList2=(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		float totalPrice=0;
		for(int i=0;i<shopCartList2.size();i++){
			int num = shopCartList2.get(i).getNum();
			float price = shopCartList2.get(i).getMenuPrice();
			totalPrice =totalPrice+ num * price;

		}
		shopCartsession.setAttribute("totalPrice", totalPrice);
		return totalPrice;

	}
	/**
	 * ���ɶ�����������seatId��Ա��staffId�������ţ��굥�ţ�
	 */
	public String getOrder(){


		List<ShopCartUtil> shopCartList =(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		Date newTime = null;

		//�ж����������������ǼӲ�      
		String seatId =(String) shopCartsession.getAttribute("zhuo"); 	
		int flag = -1;
		String orderId3=null;
		float totalPrice = 0;
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
				totalPrice=rs.getFloat(2);
			}else{	//���������ɶ���
				flag=1;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}


		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newTime = new Date();//��ǰʱ��
		if(flag == 1){//�ѽ��ˣ����ɶ�������������
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
			String staffId = (String)shopCartsession.getAttribute("staffid");
			ordernew.setStaffId(staffId);
			//��һ�ε�ͣ����ɶ������ܼ۾��ǣ����ﳵ���ܼ�totalPrice��

			float price2  = ( Float) shopCartsession.getAttribute("totalPrice");
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
				usedetailedaction.addDetailed(detailednew);				
			}
			String sql1="insert into quanzhong(detailedId) values("+detailedId1+")";
			DishesDao d1d=new DishesDao();
			d1d.updateData(sql1,null);


		}else if(flag == 0){//δ���ˣ����ɶ������飬
			shopCartsession.setAttribute("detailedTime", newTime);
			String  detailedId1 = sdf.format(newTime)+"002";
			shopCartsession.setAttribute("detailedId1", detailedId1);
			//�ı䶩���ܼ�totalPrice��float menuPrice =Float.parseFloat(menuPriceStr) ;
			float p1 = (Float) shopCartsession.getAttribute("totalPrice");
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

				usedetailedaction.addDetailed(detailednew);
			}	
		}

		/**
		 * ��ʾ����
		 */
		UseOrderDao orderDao = new UseOrderDao();
		Order order4 = orderDao.getOrder(seatId);
		shopCartsession.setAttribute("orderResult", order4);


		/**
		 * �¶�������չ��ﳵ
		 */
		clear();
		return "order";


	}

	/**
	 * �굥��
	 * @return
	 */
	public String detailedList(){
		String  orderIdStr = request.getParameter("orderId");		
		UseDetailedDao useDetailedDao = new UseDetailedDao();
		List<Detailed> detailedList = useDetailedDao.selDetailed(orderIdStr);
		HttpSession  shopCartsession= request.getSession();	
		shopCartsession.setAttribute("detailedListppp", detailedList);
		return "detailed";
	}

	/**
	 * ����
	 */
	public String settle(){
		HttpSession  shopCartsession= request.getSession();	
		
		String seatId = (String) shopCartsession.getAttribute("zhuo") ; 	
		String sql = "update orderList set orderStatus =1 where seatId=" +seatId;
		DaoFactory da1 = new DaoFactory();
		da1.executeUpdate(sql, null);
		shopCartsession.invalidate();
		return  "start";

	}
}

