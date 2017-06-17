<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.1.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/h-menu.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/h-menu.css" charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/h-menu-left-gps.css" charset="UTF-8">
<%request.setCharacterEncoding("UTF-8"); %>
<style>
* {
	padding: 0px;
	margin: 0px;
}

ul,li {
	list-style-type: none;
}

a {
	color: #00007F;
	text-decoration: none;
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
						<dt>热菜类</dt>			
					</dl>
					<dl>
						<dt>凉菜类</dt>
					</dl>
					<dl>
						<dt>汤类</dt>
					</dl>
					<dl>
						<dt>糕点</dt>
					</dl>
					<dl>
						<dt>酒水</dt>
					</dl>
					<dl>
						<dt>果盘</dt>
					</dl>
				</div>
			</div>
		</div>
	
<!--   tab  -->
		<div id="master_memu_top">
			<button type="button" class="btn btn-primary">外卖</button>
			<button type="button" class="btn btn-success">在线点餐</button>
			<button type="button" class="btn btn-info">线下店餐</button>
			<div id="master_memu_top_search">
				<input class="form-control" placeholder="Search" type="text">
				<button class="btn btn-default">搜索</button>
			</div>
		</div>
		
<!-- 购物车 -->
		<div id="master_memu_bottom">
			<img src="images/timg.jpg" />
		
			<div id="master_memu_bottom_lognum">1</div>
			<div id="master_memu_bottom_prices">
				总价：&nbsp;￥<span>0</span>&nbsp;元
			</div>
		</div>
		<div id="master_memu_right">

			<div class="master_memu_right_classify">
<!--  /////// 热菜              -->				<div>热菜</div>
				
			<!-- 单个菜品 -->	
				<div class="product">
			   
					    <div class="product_shade"></div>
					     <img src="images/about-img-1.png">

					     <div class="product-content">
						     <h3 class="name">
							   <strong>红烧土豆块5</strong>&nbsp;￥<span>35.00</span>
						    </h3>						   
						     <ul class="add">
							    <li><input type="button" class="product_sub" value="-" />
							     </li>
							    <li><input type="text" value="1" class="product_ipt"
								   style="width:20px;height:20px;font-size:12px;background:none;" />
							    </li>
							    <li><input type="button" class="product_add" value="+" />
							    </li>
							    <li><input type="button" class="putIn" value="放入菜单" /></a>
							    </li>
						    </ul>
					     </div>
					
					<!-- </div> -->
				</div>
				


			<div class="master_memu_right_classify">
<!-- ////凉菜 -->			<div>凉菜</div>
				  <div class="product">
				   
					    <div class="product_shade"></div>
					    <img src="images/about-img-23.jpg">
					
					  <div class="product-content">
						<h3 class="name">
							<strong>凉拌萝卜</strong>&nbsp;￥<span>25.00</span>
						</h3>
						<ul class="add">
							<li><input type="button" class="product_sub" value="-" />
							</li>
							<li><input type="text" value="1" class="product_ipt"
								style="width:20px;height:20px;font-size:12px;background:none;" />
							</li>
							<li><input type="button" class="product_add" value="+" />
							</li>
							<li><input type="button" class="putIn" value="放入菜单" />
							</li>
						</ul>
					</div>
				</div>
			</div>
		
			<div class="master_memu_right_classify">
<!--  汤类  -->		<div>汤类</div>
				<div class="product">
					<div class="product_shade"></div>
					<img src="images/about-img-31.jpg">
					<div class="product-content">
						<h3 class="name">
							<strong>蛋黄汤</strong>&nbsp;￥<span>45.00</span>
						</h3>
						
						<ul class="add">
							<li><input type="button" class="product_sub" value="-" />
							</li>
							<li><input type="text" value="1" class="product_ipt"
								style="width:20px;height:20px;font-size:12px;background:none;" />
							</li>
							<li><input type="button" class="product_add" value="+" />
							</li>
							<li><input type="button" class="putIn" value="放入菜单" /></a>
							</li>
						</ul>
					</div>
				</div>
			
			<div class="master_memu_right_classify">
<!--糕点  -->				<div>糕点</div>
				<div class="product">
					<div class="product_shade"></div>
					<img src="images/about-img-10.jpg">
					<div class="product-content">
						<h3 class="name">
							<strong>三明治</strong>&nbsp;￥<span>15.00</span>
						</h3>
					
						<ul class="add">
							<li><input type="button" class="product_sub" value="-" />
							</li>
							<li><input type="text" value="1" class="product_ipt"
								style="width:20px;height:20px;font-size:12px;background:none;" />
							</li>
							<li><input type="button" class="product_add" value="+" />
							</li>
							<li><input type="button" class="putIn" value="放入菜单" /></a>
							</li>
						</ul>
					</div>
				</div>
			
			<div class="master_memu_right_classify">
<!-- 酒水 -->				<div>酒水</div>
				<div class="product">
					<div class="product_shade"></div>
					<img src="images/about-img-16.jpg">
					<div class="product-content">
						<h3 class="name">
							<strong>老白干 </strong>&nbsp;￥<span>45.00</span>
						</h3>
						
						<ul class="add">
							<li><input type="button" class="product_sub" value="-" />
							</li>
							<li><input type="text" value="1" class="product_ipt"
								style="width:20px;height:20px;font-size:12px;background:none;" />
							</li>
							<li><input type="button" class="product_add" value="+" />
							</li>
							<li><input type="button" class="putIn" value="放入菜单" /></a>
							</li>
						</ul>
					</div>
				</div>
				
			<div class="master_memu_right_classify">
<!--果盘  -->				<div>果盘</div>
				<div class="product">
					<div class="product_shade"></div>
					<img src="images/about-img-29.jpg">
					<div class="product-content">
						<h3 class="name">
							<strong>草莓</strong>&nbsp;￥<span>25.00</span>
						</h3>
					
						<ul class="add">
							<li><input type="button" class="product_sub" value="-" />
							</li>
							<li><input type="text" value="1" class="product_ipt"
								style="width:20px;height:20px;font-size:12px;background:none;" />
							</li>
							<li><input type="button" class="product_add" value="+" />
							</li>
							<li><input type="button" class="putIn" value="放入菜单" /></a>
							</li>
						</ul>
					</div>
				</div>
		</div>
		
			<div style="height:100px;width:1px"></div>
		</div>
		<div></div>
<!--  -->		
		<div class="hah"></div>
		<div id="menuDetailsShow">
			<button id="menuDetailsShow_close" class="btn btn-default">-</button>
			<div>
				<span class="menuDetails_span">xxxxxx名称</span> <span
					class="menuDetails_txt">数量</span> <span class="menuDetails_prices"
					style="width:40px;">总价</span>
			</div>
			<div id="menuDetailsShow_son"></div>
			<span id="menuDetails_details_span1">总数量</span> <span
				id="menuDetails_details_num1">0</span> <span
				id="menuDetails_details_price1">总价格</span> <span
				style="color:red;margin-left:25px;">￥</span> <span
				id="menuDetails_details_price_num1">0</span>
		</div>
		<div id="menuDetails">
			<button class="menuDetails_close" class="btn btn-default">-</button>
			<div style="height:20px;"></div>
			<div id="menuDetails_son"></div>

			<div id="menuDetails_details">
				<span id="menuDetails_details_span">总数量</span> <span
					id="menuDetails_details_num">0</span> <span
					id="menuDetails_details_price">总价格</span> <span
					style="color:red;margin-left:25px;">￥</span> <span
					id="menuDetails_details_price_num">0</span>
				<div>
					<div id="menuDetails_submit1">
						<button class="btn btn-default" id="menuDetails_submit1_delete">清空菜单</button>
						<button class="btn btn-default" id="menuDetails_submit1_submit">确认提交</button>
					</div>

				</div>

			</div>
</body>
</html>
