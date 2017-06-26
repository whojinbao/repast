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
	 * 点餐，创建购物车，加入购物车；
	 * 
	 */

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private UseDetailedAction usedetailedaction = new UseDetailedAction();
	private UseOrderAction  useOrderAction = new UseOrderAction();

	public String order(){
		/**
		 * 获得点餐页面提交的数据
		 */
		String menuNameStr = request.getParameter("menuName");
		String menuPriceStr =request.getParameter("price");
		String numStr = request.getParameter("num");
		if("0".equals(numStr)){
			del(menuNameStr);
			return null;
		}
		/*String seatId = request.getParameter("3");
		String staffId = request.getParameter("1002");

		String orderSort = request.getParameter("0");*/


		//float sourceF = Float.parseFloat(sourceStr);
		int menuPrice =Integer.parseInt(menuPriceStr) ;
		int num = Integer.parseInt(numStr);
		//根据菜品名查id
		UseMenuDao usemenuDao = new UseMenuDao();
		int menuId = usemenuDao.selName(menuNameStr).get(0).getMenuId();

		ShopCartUtil shopCart = new ShopCartUtil();
		shopCart.setMenuId(menuId);
		shopCart.setMenuName(menuNameStr);
		shopCart.setMenuPrice(menuPrice);   	
		shopCart.setNum(num);  
		String orderSort = "1";
		//创建购物车
		HttpSession  shopCartsession= request.getSession();

		/**
		 * 获取list链表， 看是否创建购物车
		 */
		List<ShopCartUtil> shopCartList1=(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		if(shopCartList1==null){//未创建购物车，直接添加
			/**
			 * 添加桌号，员工，    订单状态（是否结账 ）	  订单类别 （外卖，点餐）
			 */


			shopCartsession.setAttribute("orderSort", orderSort);

			List<ShopCartUtil> shopCartList = new ArrayList<ShopCartUtil>();
			shopCartList.add(shopCart);

			shopCartsession.setAttribute("shopCartList", shopCartList);
		}else{
			//已有购物车
			/**
			 * 添加桌号，员工，    订单状态（是否结账 ）	  订单类别 （外卖，点餐）
			 */

			shopCartsession.setAttribute("orderSort", orderSort);

			/**
			 * 判断新点的菜是否已有
			 */	
			int flag = -1;
			List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
			for(int i=0;i<list1.size();i++){
				String name = list1.get(i).getMenuName();
				if(menuNameStr.equals(name)){
					//所点的菜已有
					list1.get(i).setNum(num);
					shopCartsession.setAttribute("shopCartList", list1);
					flag = 1;
					break;
				}
			}
			if(flag == -1){
				//所点的菜没有
				shopCartList1.add(shopCart);
				shopCartsession.setAttribute("shopCartList", shopCartList1);

			}
		}  	


		getTotalPrice();

		return null;
	}
	/**
	 * 
	 * @param aaa
	 */
	public void del(String aaa){
		String sql001="select * from menu where menuName='"+aaa+"'";
		DishesDao dd=new DishesDao();
		ResultSet rs=dd.getData(sql001, null);
		String menuIdStr ="";
		try {
			rs.next();
			menuIdStr=rs.getString("menuId");
		} catch (Exception e) {
		}

		String ip = request.getParameter("ip");
		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		try{
			if(ip != null){
				list1.clear();
				shopCartsession.setAttribute("shopCartList",list1 );

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

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 *  购物车的清空
	 */
	public String clear(){
		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		list1.clear();
		shopCartsession.setAttribute("shopCartList",list1 );
		int totalPrice = (Integer) shopCartsession.getAttribute("totalPrice");
		shopCartsession.setAttribute("totalPrice", 0);
		return "shopCart";
	}
	/**
	 * 购物车的删除
	 */
	public String del(){

		String menuIdStr = request.getParameter("menuId");

		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil>  list1= (List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		try{
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

		}catch(Exception e){
			e.printStackTrace();
		}
		return "shopCart";
	}

	/**
	 * 计算总价,未每一次购物车内总价
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
	 * 生成订单，有桌号seatId，员工staffId，订单号，详单号，
	 */
	public String getOrder(){

		HttpSession  shopCartsession= request.getSession();	
		List<ShopCartUtil> shopCartList =(List<ShopCartUtil>) shopCartsession.getAttribute("shopCartList");
		Date newTime = null;

		//判断是新增订单，还是加菜      
		String seatId =(String) shopCartsession.getAttribute("zhuo"); 	
		int flag = -1;
		String orderId3=null;
		int totalPrice = 0;
		/**
		 * 桌号与已点订单的桌号比较。查看是否结账orderStatus;
		 */

		String sql="select orderId,totalPrice from orderList where orderStatus=0 and seatId="+seatId;
		DishesDao dd=new DishesDao();
		ResultSet rs=dd.getData(sql, null);		
		try {
			if(rs.next()){	//存在说明加菜
				flag = 0;
				orderId3=rs.getString(1);
				totalPrice=rs.getInt(2);
			}else{	//不存在生成订单
				flag=1;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}


		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newTime = new Date();//当前时间
		if(flag == 1){//已结账，生成订单，订单详情
			shopCartsession.setAttribute("orderTimes", newTime);//下订单时间

			String orderId1=sdf.format(newTime);
			shopCartsession.setAttribute("orderId", orderId1);//订单id
			String detailedId1 = orderId1+"001";
			shopCartsession.setAttribute("detailedTime", newTime);//下订单详情时间
			shopCartsession.setAttribute("detailedId1", detailedId1);

			//订单
			Order ordernew = new Order();
			ordernew.setOrderId(orderId1);
			ordernew.setOrderTimes(newTime);
			ordernew.setOrderSort(1);
			ordernew.setOrderStatus(0);
			ordernew.setSeatId(seatId);
			String staffId = (String)shopCartsession.getAttribute("staffid");
			ordernew.setStaffId(staffId);
			//第一次点餐，生成订单，总价就是，购物车内总价totalPrice；

			int price2  =(Integer)shopCartsession.getAttribute("totalPrice");
			ordernew.setTotalPrice(price2);			 
			useOrderAction.addOrder(ordernew);


			//详单
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


		}else if(flag == 0){//未结账，生成订单详情，
			shopCartsession.setAttribute("detailedTime", newTime);
			String  detailedId1 = sdf.format(newTime)+"002";
			shopCartsession.setAttribute("detailedId1", detailedId1);
			//改变订单总价totalPrice，float menuPrice =Float.parseFloat(menuPriceStr) ;
			int p1 = (Integer) shopCartsession.getAttribute("totalPrice");
			totalPrice = totalPrice+ p1;;

			/**
			 * 添加详单，改变订单总价totalPrice，结账改变订单状态orderStatus；
			 */
			useOrderAction.updateOrder(orderId3, totalPrice, 0);

			//添加详单

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
		 * 显示订单
		 */
		UseOrderDao orderDao = new UseOrderDao();
		Order order4 = orderDao.getOrder(seatId);
		shopCartsession.setAttribute("orderResult", order4);
		return "order";


	}

	/**
	 * 详单表
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
	 * 结账
	 */
	public String settle(){
		HttpSession  shopCartsession= request.getSession();	
		int seatId =  (Integer) shopCartsession.getAttribute("seatId"); 	
		String sql = "update orderList set orderStatus =1 where seatId=" +seatId;
		DaoFactory da1 = new DaoFactory();
		da1.executeUpdate(sql, null);
		shopCartsession.invalidate();
		return  "start";

	}
}

