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
	background: url("../image/waimai.png") no-repeat 80px 0px;
	background-color: #000;
	position: fixed;
	z-index: 999;
	width: 101%;
	border:1px red solid;
}

#nav {
	margin-top: 60px;
	height: 30px;
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
	z-index: 9;
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
	width: 98%;
	height: 98%;
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
}
#shopping_cart_notnone2 {
	font-size:20px;
	width: 100%;
	height: 100%;
	text-align:center;
	color: white;
	background-color: #51D862;
	line-height: 100%;
	border: none;
}
.username{
	position :absolute;
	right: 20px;
}




.zhucewidth {
	width: 380px;
	float: right;
}

#shoujihao,#passworddouble,#password,#name {
	margin-top: -20px;
	color: red;
	display: none;
}
.mimacuowu{
	position:absolute;
	top:280px;
	left:580px;
	display:none;
}
#mimacuowu1,#dengluok2,.displayselect1,.displayse2{
	display:none;
}
#mimacuowu2,#dengluok1,.displayselect2,.displayse1{
	display:block;
}
.dengluok{
	color:green;
	position: absolute;
	top:50px;
	left:80px;
	font-size:18px;
	display:none;
}

#selectseat{
	z-index: 9999999999;
	width:200px;
	position: absolute;
	top:10px;
	left:800px;
}
.quxiadan1{
	display:none;
}
#nav a{ color:black;}

</style>
<link rel="stylesheet" href="../qiantai/css/component.css" type="text/css"></link>
<link rel="stylesheet" href="../qiantai/css/zzsc.css" type="text/css"></link></head>

<body><script src="/demos/googlegg.js"></script>
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
								<a href="#${menuType.typeName }">${menuType.typeName }</a>
							</dt>
						</dl>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-xs-12 col-sm-12" id="top"></div>
		<div class="col-xs-12 col-sm-12" id="nav">
			<div class="username">
				<span><a href="who_order_gogeren.action">个人中心</a></span>
				<span>欢迎&nbsp;&nbsp;</span>
				<span id="username">${username }</span>&nbsp;&nbsp;<a href="who_order_zhuxiao.action">注销</a>
			</div>
		</div>
		<div class="col-xs-9 col-sm-7 buttom">
		 <div class="buttom_sort row">
				 <div class="dishes_sort"><a  name="c1">热门推荐</a></div> 	
				 <div height="50" width="100%" border="1"></div> 
		 </div>		
	   <c:forEach items="${orderUtilList }" var="orderUtil">

			    <div class="buttom_sort row">
				       
	            <div class="dishes_sort" >
	                 
	                <a name="${orderUtil.menuTypeName }">${orderUtil.menuTypeName }</a>
	            </div>
	       <c:forEach items="${orderUtil.menuList }" var="menu">	      	          	              
	              <!-- 第一个菜品显示到前台界面开始边界 -->					
						<div class="dishes_boss">
							<div class="dishes_img">
								<img src="../fileUpload/${menu.imgUrl }"></img>
							</div>
							<!-- 放图片 -->						
							<div class="dishes_id" style="display:none">${menu.menuId }</div>
						    <!--  -->
							<div class="dishes_name">${menu.menuName }</div>
							<!-- 放名字 -->
							<div class="dishes_prices"><span class="dangejiage">${menu.menuPrice }</span><span>元</span></div>
							<!-- 放价格 -->
							<div class="dishes_operation" >
								<div class="gouwuche1" onclick="getNum('${menu.menuId }','${menu.menuName }','${menu.menuPrice }','1')"  href="javascript:;"><input type="button" class="add_shopp" value="放入购物车"></div>
								<!-- 蓝色放入购物车 -->
								<div class="add_shopp_div">
									<button class="shopping_minus">-</button>
									<!-- -按钮 -->
									<input class="shopping_input" type="text" value="${menu.num }" name="menuNum">
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
				<span class="allprice"></span><span>元</span> 
			</div>
			<div id="allnum"> </div>
		</button>
		<div id="shopping_cart_right">
			<a  href="../qiantai/qrxdan/xiadan.jsp"><button  id="shopping_cart_notnone" >去下单</button></a>
			<a href="javascript:;" class="md-trigger "data-modal="modal-2">
			<button id="shopping_cart_notnone2">去下单</button></a>
		</div>
	</div>
	
	
	<%-- 模态框 --%>

<div style="width:1000px; height:500px; padding-left:450px;position:absolute;top:0px;">
		

		<!-- 登陆 -->

		<div class="demo form-bg md-modal md-effect-13" id="modal-2">
			<div class="container ">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<form class="form-horizontal" action="qtlogin_goxiadan.action" method="post">
							<span class="heading">用户登录</span>
							<div class="form-group">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="请输入手机号码" name="phone"> <i class="fa fa-user"></i>
							</div>
							<div class="form-group help">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="请输入密码"name="password"> <i class="fa fa-lock"></i> <a
									href="#" class="fa fa-question-circle"></a>
							</div>
							<div class="form-group">
								<div class="main-checkbox">
									<input type="checkbox" value="None" id="checkbox1" name="check" />
									<label for="checkbox1"></label>
								</div>
								<span class="text">记住我</span>
								 <a href="javascript:;" class="md-trigger btn btn-primary btn-sm"data-modal="modal-3">
									没有账号去注册	
								</a>
								<button type="submit" class="btn btn-default">立刻登录</button>
								<button class=" btn btn-default  md-close  btn-sm btn-primary" style="display: none;">立即注册</button>

							</div>
						</form>
					</div>
				</div>

			</div>
		</div>

		<!-- 注册 -->


		<div class="demo form-bg md-modal md-effect-13" id="modal-3">
			<div class="container ">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<form class="form-horizontal" action="qtlogin_waimailogin.action" method="post"  id="form1">
							<span class="heading">用户注册</span>
							<div class="form-group">
								<span>手机号</span><input type="text" name="phone"
									class="form-control zhucewidth" id="inputmobile"
									placeholder="手机号">
							</div>
							<div id="shoujihao">手机号格式不正确</div>
							<div class="form-group help">
								<span>姓名</span><input type="text" name="name"
									class="form-control zhucewidth" id="inputname"
									placeholder="请输入您的姓名">

							</div>
							<div id="name">请输入您的姓名</div>
							<div class="form-group help">
								<span>密&nbsp;&nbsp;码</span><input type="password" name="password"
									class="form-control zhucewidth" id="inputPassword1"
									placeholder="请输入6-16位密码">
							</div>
							<div id="password">密码长度不正确</div>
							
							<div class="form-group help">
								<span>重复密码</span><input type="password"
									class="form-control zhucewidth" id="inputPassword2"
									placeholder="请重复输入密码">

							</div>
							<div id="passworddouble">两次密码不一致</div>
							<div class="form-group">
								<button type="submit" id="zhucesubmit" class="btn btn-default" disabled="value">提交注册</button>
								<button class=" btn btn-default  md-close  btn-sm btn-primary"style="display: none;">返回登陆</button>

							</div>
						</form>
					</div>
				</div>

			</div>
		</div>



		<div class="md-overlay"></div>
		<!-- the overlay element -->
	</div>

<script type="text/javascript">		
	window.onload=function() {
		function username(){
			if($("#username").html()==""){
				$("#shopping_cart_notnone").hide();
				$(".username").hide();
			};
		}
		 username();
		
		$(".shopping_input").each(function(){
	        var value = $(this).val()*1; 
	        if(value>0){
	        	$(this).parent().css("display","block");
				$(this).parent().parent().find(".gouwuche1").css("display","none");
	        }else{
	        	$(this).parent().css("display","none");
				$(this).parent().parent().find(".gouwuche1").css("display","block");
	        }
	 	 });
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
				
	 };
	 
	 /*得到点餐的数据*/
	 function getNum(id,name,price,num){	         
	    $.ajax({
			type: 'POST',
			url: 'shopCart_order.action',		
			data:{menuId:id,menuName:name,price:price,num:num},
			dataType: 'json',
			success: function(data){
			   
			},
			error:function(data) {
				console.log(data.msg);
			},
		});	
						
}
	 
	 var mobile=false;
		var psw=false;
		var psw2=false;
		var name=false;
		$("#inputname").blur(function (){
			if($("#inputname").val()!=""){
				 $("#name").css("display","none");
				 name=true;
			}else{
				 $("#name").css("display","block");
				 name=false;
			}
			
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		});
		$("#inputmobile").blur(function(){
 			 if ((/^1[34578]\d{9}$/).test($("#inputmobile").val())){
 			    $("#shoujihao").css("display","none");
 			    mobile=true;
 			  }else {
 			    $("#shoujihao").css("display","block");
 			    mobile=false;
 			  }
 		 
	  if(mobile&&psw&&psw2&&name){
          $("#zhucesubmit").attr("disabled",false);
       }else{
       	 $("#zhucesubmit").attr("disabled",true);
       }; 
       var menuName=$("#inputmobile").val();
		 $.ajax({
			type:"post",
			url:"qtlogin_jiaoyan.action",
			data:{name:menuName},
			datatype:"json",
			success:function(data){
				if(data==1){
					$("#shoujihao").html("手机号已存在");
				 	$("#shoujihao").css("display","block");
				 	 mobile=false;
				}else{
					$("#shoujihao").html("手机号格式不正确");
				}	
			}
		});
	});
	 		 
		  if(mobile&&psw&&psw2&&name){
	           $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        }; 
		$("#inputPassword1").blur(function(){
		 
		  if ((/^[a-z0-9_-]{6,16}$/).test($("#inputPassword1").val())){
		    $("#password").css("display","none");
		    psw = true;
		  }else {
		   $("#password").css("display","block");
		    psw = false;
		  }
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		});

		$("#inputPassword2").blur(function(){
		if(!$("#inputPassword2").val()==""){
			 if (($("#inputPassword1").val())==($("#inputPassword2").val())){
		    $("#passworddouble").css("display","none");
		     psw2 = true;
		     
		  }else {
		   $("#passworddouble").css("display","block");
		    psw2 = false;
		  }
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	       }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		}
		 
		});
	 
	 /*计算价钱*/
	 function Total(){
	        var num=0; 
	        var money=0;
	        var txt = $(".shopping_input"); 
	        for (var i = 0; i < txt.length; i++) {
	            num += txt.eq(i).val()*1; 
	            money += (txt.eq(i).val()*1) * (txt.eq(i).parent().parent().parent().find(".dishes_prices").find(".dangejiage").html()*1);
	        }
	        $("#allnum").html(num);
	        $(".allprice").html(money);
	    }
	    Total();
	 $(".shopping_minus").click(function (){
		 var ipt=$(this).next();
		 var num=ipt.val();
		 if(num>0){num--;};
		 ipt.val(num);
		 if(num==0){
			$(this).parent().css("display","none");
			$(this).parent().parent().find(".gouwuche1").css("display","block");
		 }
		 var name=$(this).parent().parent().parent().find(".dishes_name").html();
		 var id=$(this).parent().parent().parent().find(".dishes_id").html();
		 var prices=$(this).parent().parent().parent().find(".dishes_prices").find(".dangejiage").html();
		 getNum(id,name,prices,num);
		 Total();
	 });
	 
	 $(".gouwuche1").click(function (){
		$(this).css("display","none");
		$(this).parent().find(".add_shopp_div").css("display","block");
		var num=$(this).parent().find(".add_shopp_div").find(".shopping_input").val();
		num++;
		$(this).parent().find(".add_shopp_div").find(".shopping_input").val(num);
		Total();
		
	});
	$(".shopping_add").click(function(){
		 var ipt=$(this).parent().find(".shopping_input");
		 var num=ipt.val();
		 num++;
		 ipt.val(num);
		 var name=$(this).parent().parent().parent().find(".dishes_name").html();
		 var id=$(this).parent().parent().parent().find(".dishes_id").html();
		 var prices=$(this).parent().parent().parent().find(".dishes_prices").find(".dangejiage").html();
		 getNum(id,name,prices,num);
		 Total();
		
	});
	$(".shopping_input").blur(function(){
		var num=$(this).val()*1;
		if(num<=0){
			num=0;
			$(this).val(num);
			$(this).parent().css("display","none");
			$(this).parent().parent().find(".gouwuche1").css("display","block");
		}
		var id=$(this).parent().parent().parent().find(".dishes_id").html();
		var name=$(this).parent().parent().parent().find(".dishes_name").html();
		var prices=$(this).parent().parent().parent().find(".dishes_prices").find(".dangejiage").html();
		getNum(id,name,prices,num);
		Total();
	});	
	</script>
<script type="text/javascript" src="../qiantai/js/js/classie.js"></script>
<script type="text/javascript" src="../qiantai/js/js/modalEffects.js"></script>
</body>
</html>
