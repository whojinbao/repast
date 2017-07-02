<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  
<style type="text/css">
 body{
	background: #f7f7f7;
}
.content1{
	margin-top:50px;
	margin-left:200px;
	width: 65%;
	min-width:800px;
	background: #fff;
	box-shadow: 1px 1px 15px #ddd;
	position:relative;
}
.header{
	position: relative;
	height: 60px;
	line-height: 60px;
	border-bottom: 1px solid #f7f7f7;
}
.header h1{
	
	display: inline-block;
	padding-left: 20px;
	font-size: 25px;
}
.orderContetn{
    margin-top:20px;

}
.ent-btn{
	position:absolute;
	right:50px;
	bottom:50px;
}
.btn{
	width: 120px;
    height: 35px;
    line-height: 35px;
    background: #fb3b3b;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    cursor: pointer;
}
td{

text-align:left;
height:30px;
}
#xinxishow{
	margin-left:50px;
}
#xinxishow div{
	margin-top:10px;
}
  #ontable{
  	margin-left:20px;
  	font-size: 14px;
  	whith:800px;
  }
  #showorder{
  	width:100%;
  	position: relative;
  	zoom:1;
  }
  #showorder span{
  	display:inline-block;
  	width:100px;
  	height:26px;
  	font-size:15px;
  	text-align: left;
  }
  #newOrder,#oldOrder{
  	margin-left:30px;
  	width:96%;
  	min-height:300px;
  }
  #oldOrder{
  	display:none;
  }
  #newOrdershow button,#oldOrdershow button{
  	width:100%;
  	height:100%;
  	background-color: #1CBB9B;
  	color:white;
  	border:none;
  }
  #oldOrdershow button{
  	background-color:white;
  	color:black;
  }
  .oldorder_xq{
  	display:none;
  }
  
  
  
  
    #showorder1{
  	width:100%;
  	position: relative;
  	zoom:1;
  }
  #showorder1 span{
  	display:inline-block;
  	width:100px;
  	height:26px;
  	font-size:15px;
  	text-align: left;
  }
  #newOrder1,#oldOrder1{
  	margin-left:30px;
  	width:96%;
  	min-height:300px;
  }
  #newOrder1{
  	display:none;
  }
  #newOrdershow1 button,#oldOrdershow1 button{
  	width:100%;
  	height:100%;
  	background-color: #1CBB9B;
  	color:white;
  	border:none;
  }
  #newOrdershow1 button{
  	background-color:white;
  	color:black;
  }
   </style>
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  		<a href="menu_gowaimai.action">返回继续点餐</a>
      	<div class="content1">
      	    <div class="header">
				<h1>我的订单</h1>	
			</div>
			<div class="orderContetn">
				<h4><div id="xinxishow">
					<div>账号 ：<span>${phone }</span></div>
					<div>姓名：<span>${username }</span></div>
				</div></h4>
		   </div>
		   <div id="showorder">
				<span style="width:20px;">&nbsp;</span>
				<span id="newOrdershow${who_okorder }"><button>未完成订单</button></span>
				<span id="oldOrdershow${who_okorder }"><button>已完成订单</button></span>
				<span style="margin-left:25px;width:200px;">联系商家:0371-7812123</span>
				<div id="newOrder${who_okorder }">
					<table id="ontable">
					  	<c:forEach items="${dingdan }" var="dd" varStatus="status">		     
							 <tr>
							  	<td width="100%">${ status.index + 1}.订单编号：${dd.id }&nbsp;&nbsp;下单时间：${dd.time }</td>
							 </tr>
							 <tr>
							  	<td width="100%">&nbsp;&nbsp;&nbsp;&nbsp;姓名：${dd.name }&nbsp;&nbsp;联系电话：${dd.phone }</td>
							 </tr>
							 <tr>
							  	<td width="100%">&nbsp;&nbsp;&nbsp;&nbsp;地址：${dd.address }</td>
							 </tr>
							 	<c:forEach items="${dd.list }" var="ll">
								 	<tr>
								 	<td >&nbsp;&nbsp;&nbsp;&nbsp;
								 		<span  style="margin-left:15px;">${ll.name }</span>
								 		<span>x${ll.num }份</span>
								 		<span>${ll.prices }元/份</span>
								 	</td>
								 	 </tr>	
							 	</c:forEach>	
							
								<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;总价格：${dd.price }&nbsp;&nbsp;&nbsp;&nbsp;
										订单状态：${dd.status }&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="who_order_orderConfirm.action?wmorderId=${dd.id }"><button id="oook">确认收货</button>	</a>
								</td></tr>					
								
							<tr><td><hr></td></tr>
						</c:forEach>	
		  			 </table>
				</div>
				<div id="oldOrder${who_okorder }">
						<c:forEach items="${oldorder_who }" var="dd" varStatus="status">	
						<div style="margin-top:10px;">
							${ status.index+1}.下单时间：${dd.time }&nbsp;&nbsp;&nbsp;&nbsp;收货人：${dd.name }&nbsp;&nbsp;&nbsp;&nbsp;
							订单编号：${dd.id }&nbsp;&nbsp;&nbsp;&nbsp;<button class ="showOldOrder_xq"style="background-color: white;border:1px solid black;">查看详情...</button>
						</div>
						<div class="oldorder_xq">
							<c:forEach items="${dd.list }" var="ll">
								 		<div style="margin-left:15px;"><span>${ll.name }</span>
								 		<span>x${ll.num }份</span>
								 		<span>${ll.prices }元/份</span></div>
								 	 </tr>	
							 </c:forEach>
							 	<div>总价：${dd.price } 元</div>
						</div>
						
						</c:forEach>
					<div><button id="shouye">首页</button>
					<button id="shangyiye">上一页</button>
					<span style="width:46px;">第${oldorder_who_num}页</span>
					<button id="xiayiye">下一页</button><span>共${oldorder_who_num_sun }页</span></div>
					
				</div>
			</div>
	</div>
	<div style="height:150px;"></div>
	<script type="text/javascript">
		$("#newOrdershow").click(function (){
			$("#newOrdershow button").css({"background-color":"#1CBB9B","color":"white"});
			$("#oldOrdershow button").css({"background-color":"white","color":"black"});
			$("#newOrder").show();
			$("#oldOrder").hide();
		});
		$("#oldOrdershow").click(function (){
			$("#oldOrdershow button").css({"background-color":"#1CBB9B","color":"white"});
			$("#newOrdershow button").css({"background-color":"white","color":"black"});
			$("#newOrder").hide();
			$("#oldOrder").show();
		});
		$("#newOrdershow1").click(function (){
			$("#newOrdershow1 button").css({"background-color":"#1CBB9B","color":"white"});
			$("#oldOrdershow1 button").css({"background-color":"white","color":"black"});
			$("#newOrder1").show();
			$("#oldOrder1").hide();
		});
		$("#oldOrdershow1").click(function (){
			$("#oldOrdershow1 button").css({"background-color":"#1CBB9B","color":"white"});
			$("#newOrdershow1 button").css({"background-color":"white","color":"black"});
			$("#newOrder1").hide();
			$("#oldOrder1").show();
		});
		$(".showOldOrder_xq").click(function (){
			$(".oldorder_xq").hide();
			$(this).parent().next().show();
		});
		$("#shouye").click(function (){
			$.ajax({
	 			type:"post",
	 			url:"who_order_oldOrder.action",
	 			data:{yemanum:0},
	 			datatype:"json",
	 			success:function(data){
	 				window.location.href = 'http://localhost:8080/repast/who_order_gogeren.action';
	 			}});
		});
		$("#shangyiye").click(function (){
			$.ajax({
	 			type:"post",
	 			url:"who_order_oldOrder.action",
	 			data:{yemanum:-1},
	 			datatype:"json",
	 			success:function(data){
	 				window.location.href = 'http://localhost:8080/repast/who_order_gogeren.action';
	 				}});
		});
		$("#xiayiye ").click(function (){
			$.ajax({
	 			type:"post",
	 			url:"who_order_oldOrder.action",
	 			data:{yemanum:1},
	 			datatype:"json",
	 			success:function(data){
	 				window.location.href = 'http://localhost:8080/repast/who_order_gogeren.action';
	 			}});
		});
		
	</script>
  </body>
</html>
