<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="js/h-menu.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"
	charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/h-menu.css"
	charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/h-menu-left-gps.css"
	charset="UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
%>
<style>
* {
	padding: 0px;
	margin: 0px;
}

body {
	background-color: #F7F7F7;
}

ul,li {
	list-style-type: none;
}

a {
	color: #00007F;
	text-decoration: none;
}

#top {
	height: 60px;
	color: white;
	background: url("../image/diancan.png") no-repeat 80px 0px;
	background-color: #000;
	position: fixed;
	z-index: 999;
	width: 101%;
	border:1px red solid;
}

#nav {
	margin-top: 60px;
	height: 30px;
	color: white;
	background-color: #EEEEEE;
	position: fixed;
	z-index: 999;
	width: 101%;
}

#nav_fixed {
	position: fixed;
	top: 0;
}

.row {
	width: 100%;
	
}

.buttom {
	margin-top: 90px;
	margin-left: 300px;
	position: relative;
	z-index: 9px;
}

#master_memu_left {
	position: absolute;
	top: 160px;
	left: 60px;
	width: 200px;
	POSITION: fixed;
}

.dishes_sort {
	font-size: 18px;
	margin-left: 30px;
}

.buttom_sort {
	margin-top: 28px;
}

.dishes_boss {
	border: 1px solid #000;
	width: 46%;
	height: 90px;
	margin-left: 20px;
	margin-top: 20px;
	background-color: #fff;
	position: relative;
	min-width: 300px;
	float: left;
}

.dishes_img {
	width: 90px;
	height: 90px;
	position: absolute;
	top: 0px;
	left: 0px;
}

.dishes_img img {
	width: 100%;
	height: 100%;
}

.dishes_name {
	height: 30px;
	width: 40%;
	position: absolute;
	left: 95px;
	top: 5px;
	text-indent: 8px;
	font-weight: bold;
}

.dishes_prices {
	height: 30px;
	width: 80px;
	position: absolute;
	left: 95px;
	top: 55px;
	color: red;
	text-indent: 8px;
	font-weight: bold;
}

.dishes_operation {
	position: absolute;
	bottom: 8px;
	right: 12px;
	width: 100px;
	height: 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
}

.add_shopp {
	width: 100px;
	height: 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
	color: #fff;
	font-size: 13px;
	line-height: 28px;
	text-align: center;
	background-color: #0089DC;
	border: none;
}

.add_shopp_div {
	width: 100px;
	height: 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
	position: relative;
	display: none;
}

.shopping_input {
	margin: 0px;
	padding: 0px;
	width: 40px;
	height: 28px;
	font-size: 13px;
	line-height: 28px;
	position: absolute;
	left: 30px;
	top: 0px;
	border: 1px solid #EEEEEE;
	text-align: center;
	z-index: 15;
	outline: 0;
}

.shopping_minus {
	width: 40px;
	height: 28px;
	line-height: 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
	font-size: 15px;
	line-height: 28px;
	background-color: #EEEEEE;
	border: 1px solid #EEEEEE;
	z-index: 5;
	outline: 0;
}

.shopping_add {
	width: 40px;
	height: 28px;
	line-height: 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
	font-size: 15px;
	line-height: 28px;
	background-color: #EEEEEE;
	border: 1px solid #EEEEEE;
	position: absolute;
	right: 0px;
	z-index: 5;
	outline: 0;
}

.shopping_add:hover,.shopping_minus:hover {
	background: #ddd;
}

.base {
	height: 120px;
}

#shopping_cart {
	width: 320px;
	height: 48px;
	position: fixed;
	bottom: 0px;
	right: 0px
}

#shopping_cart_left {
	width: 200px;
	height: 48px;
	background-color: #2C2C2C;
	float: left;
	position: relative;
	border: none;
}

#shopping_cart_right {
	width: 120px;
	height: 47px;
	background-color: #F0F0F0;
	float: left;
	position: absolute;
	top: 0px;
	left: 200px;
}

#shopping_cart_logo {
	width: 40px;
	height: 40px;
	position: absolute;
	top: 4px;
	left: 2px;
	overflow: hidden;
	border: 1px solid #2C2C2C;
}

#shopping_cart_logo img {
	width: 300%;
	height: 300%;
	position: absolute;
	top: -24px;
	left: -52px;
}

#shopping_cart_allprice {
	position: absolute;
	top: 10px;
	left: 37px;
	height: 30px;
	width: 160px;
}

.peisongfei {
	color: #99997D;
	font-size: 12px;
	padding-left: 5px;
	border-left: 1px solid #99997D;
	letter-spacing: -1px;
}

.allprice {
	color: white;
	font-size: 20px;
}

#allnum {
	background-color: red;
	color: white;
	padding-left: 1.5px;
	padding-right: 1.5px;
	height: 20px;
	min-width: 20px;
	border-radius: 50%;
	position: absolute;
	top: 2px;
	left: 23px;
}

#shopping_cart_none {
	font-size: 17px;
	color: black;
	position: absolute;
	top: 10px;
	left: 5px;
	display:none;
}

#shopping_cart_notnone {
	font-size:20px;
	width: 100%;
	height: 100%;
	text-align:center;
	color: white;
	background-color: #51D862;
	line-height: 100%;
	border: none;
	display:inline-block;
}
</style>
</head>

<body>
	<div id="master_memu">
		<div id="master_memu_left">
			<div class="container">
				<div class="leftsidebar_box">
					<div class="line"></div>
					<dl>
						<dt ><a href="#c1">热门推荐</a></dt>
					</dl>
					<c:forEach items="${MenuTypeList }" var="menuType" >
						<dl>
						<!-- 定义锚点
						<a href="javascript:void(0)" onclick="document.getElementByIdx_x('view').scrollIntoView();"></a>
                           <a id="view"></a>  -->
							<dt>						
								<%-- <a href="JavaScript:void(0)" onclick="document.getElementById('${orderUtil.menuTypeName }').scrollIntoView();">
								${menuType.typeName }</a> --%>
								<a>${menuType.typeName }</a>
							</dt>
						</dl>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-xs-12 col-sm-12" id="top"></div>
		<div class="col-xs-12 col-sm-12" id="nav"></div>
		<div class="col-xs-9 col-sm-7 buttom">
		 <div class="buttom_sort row">
				 <div class="dishes_sort"><a  name="c1">热门推荐</a></div> 	
				 <div height="50" width="100%" border="1"></div> 
		 </div>		
	   <c:forEach items="${orderUtilList }" var="orderUtil">

			    <div class="buttom_sort row">
				       
	            <div class="dishes_sort" >
	              
	                <a id="${orderUtil.menuTypeName }">${orderUtil.menuTypeName }</a>
	            </div>
	       <c:forEach items="${orderUtil.menuList }" var="menu">	      	          	              
	              <!-- 第一个菜品显示到前台界面开始边界 -->					
						<div class="dishes_boss">
							<div class="dishes_img">
								<img src="../image/timg.jpg"></img>
							</div>
							<!-- 放图片 -->
							<div class="dishes_name">${menu.menuName }</div>
							<!-- 放名字 -->
							<div class="dishes_prices">${menu.menuPrice }元</div>
							<!-- 放价格 -->
							<div class="dishes_operation">
								<button class="add_shopp" onclick="getNum('${menu.menuName }','${menu.menuPrice }','1')" href="javascript:;">放入购物车</button>
								<!-- 蓝色放入购物车 -->
								<div class="add_shopp_div">
									<button class="shopping_minus">-</button>
									<!-- -按钮 -->
									<input class="shopping_input" type="text" value="1">
									<!-- +-中间的输入框	 -->
									<button class="shopping_add">+</button>
									<!-- +按钮 -->
								</div>	
								</div>
								</div>
									
						<!-- 第一个菜品显示到前台界面结束边限 -->  	               	                   	         
	            </c:forEach>
	            </div>
	            
	   </c:forEach>
	  </div>
	</div>
					
		
		
<!-- 购物车开始 -->
	<div id="shopping_cart">
		<button id="shopping_cart_left">
			<div id="shopping_cart_logo">
				<img src="../image/touming01.png"></img>
			</div>
			<div id="shopping_cart_allprice">
				<span class="allprice">￥0</span> <span class="peisongfei">配送费￥10</span>
			</div>
			<div id="allnum">1110</div>
		</button>
		<div id="shopping_cart_right">
			<div id="shopping_cart_none">购物车是空的</div>
			<a  href="shopCart.jsp"><button id="shopping_cart_notnone">点餐车</button></a>
		</div>
	</div>
    <%--  <div >
          <c:forEach items="${orderListche }" var="orderche">
               <div>
                ${orderche.get("menuName") } &nbsp;&nbsp;&nbsp;${orderche.get("price") }&nbsp;&nbsp;&nbsp;${orderche.get("num") }
               </div>
          </c:forEach>
          <div>总价：</div>
     </div> --%>
	<!-- 购物车结束 -->
	<div class="buttom_sort row">
		<div class="base col-xs-12 co4l-sm-3"></div>
	</div> 
	<script type="text/javascript">		
	window.onload=function() {
			$.ajax({
			type: 'POST',
			url: 'menuType_sel.action',
			data:{ip:diancan},
			dataType: 'json',
			success: function(data){
			    
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	 }
	 
	 /*得到点餐的数据*/
	 function getNum(name,price,num){	
	    alert("加入购物车成功");
	    $.ajax({
			type: 'POST',
			url: 'shopCart_order.action',		
			data:{menuName:name,price:price,num:num},
			dataType: 'json',
			success: function(data){
			    alert("加入购物车成功");
			},
			error:function(data) {
				console.log(data.msg);
			},
		});	
} 
	
	
	
	/*  window.onload=function() {
	 alert("xx");
			$.ajax({
			type: 'POST',
			url: 'menu_selTyMenu.action',		
			dataType: 'json',
			success: function(data){
			    
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	 } */
    
	</script>
</body>
</html>
