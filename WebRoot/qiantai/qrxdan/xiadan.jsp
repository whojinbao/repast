<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>确认下单</title>

	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/gouwu.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link href="css/component.css" rel="stylesheet">
<style type="text/css">
	#adddizhi{
		display:none;
	}
	#adddizhi1{
		width:400px;
		height:200px;
		margin-top:9px;
		border:3px dashed #F4F4F4;
	}
	#adddizhi1 div{
		margin-top:10px;
		margin-left:10px;
	}
	#adddizhi1 input{
		border:none;
		border-bottom:1px solid #000;
	}
</style>

<script type="text/javascript"src="http://webapi.amap.com/maps?v=1.3&key=1e0f7c1cdf3a9526dbaf174623808955"></script>
<script type="text/javascript"src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<script type="text/javascript"src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
<script type="text/javascript" src="jquery-2.1.3.min.js"></script>
</head>
<body ><script src="/demos/googlegg.js"></script>

<div class="wrap">
		<div class="wrap-left">
			<div class="header">
				<h2>订单详情</h2>
				<a href="menu_gowaimai.action" ><span>返回商家修改</span></a>
			</div>
			<table class="mall-content">
			  <thead>
			    <tr>
			      <th>商品</th>
			      <th>数量</th>
			      <th>小计(元)</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <c:forEach items="${shopCartList }" var="shopCart">
			  
			  
			    <tr>
			    <td class="munuid" style="display: none;">${shopCart.menuId}</td>
			      <td>${shopCart.menuName}</td>
			      <td>
			      	<div class="gw_num">
						<em class="jian">-</em>
						<input type="text" value="${shopCart.num }" class="num"/>
						<em class="add">+</em>
					</div>
			      </td>
			      <td><span>¥</span><span class="danjia"> ${shopCart.menuPrice }</span></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			  <%--<tfoot>
			    <tr>
			      <td colspan="2">餐盒</td>
			      <td >¥180</td>
			    </tr>
			    <tr>
			      <td colspan="2">配送费</td>
			      <td >¥180</td>
			    </tr>
			  </tfoot>
			--%></table>
			<div class="foot-content">
				<div class="sum">
					<h1><span>¥</span><span id="summoney"></span>  </h1>
				</div>
			</div>
		</div>
		<div class="wrap-right">
			<div class="right-content">
				<div class="item">
					<div class="right-header">
						<h2>收货地址</h2>
					</div>
					<p>账户：${username }</p>
					
						<div id="oldAddress"></div>
					<div id="addposition">
						<a href="javascript:;" class="md-trigger btn-sm" data-modal="modal-13">
							<button>+新地址</button>
						</a>
						<button id="delectAddress">删除此地址</button>
						<%--<a href="who_order_deleteAddress.action"></a>	--%>
						<div id="adddizhi${kongzhiadd}">
							<div>地址：${newdizhi }</div>
							<div>详细地址：<input type="text" id="addxxdz" size="30px" value="${xiangxi }"></div>
							<div>姓名：<input type="text" id="addname"value="${newmingzi }"></div>
							<div>电话：<input id="adddianhua"size="20px" value="${dianhua }"></div>
							<div>
								<a href="who_order_addDizhi.action"><button>确认保存</button></a>&nbsp;&nbsp;
								<button id="qingkong">清空退出</button>
							</div>
						</div>
					<div>
				</div>

				<div class="item">
					<div class="right-header">
						<h2>付款方式<span>推荐使用在线方式，不用找零，优惠更多</span></h2>
					</div>
					<div class="right-way">
						<div class="way  active">
							<p>在线支付</p>
							<p class="way-pat">支持微信，支付宝，QQ钱包等大部分银行卡</p>
						</div>
						<div class="way way-wei">
							<p>货到付款</p>
							<p class="way-pat">送货上门后在付款</p>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="right-header">
						<h2>其他信息</h2>
					</div>
					<div class="other"><span>配送方式</span><span>本订单由蜂鸟配送提供</span></div>
					<div class="other"><span>发票信息</span><input type="" placeholder="商家不支持开具发票" name=""></div>
					<div class="other"><span>其他备注</span><input type="" name=""></div>
				</div>
			<div class="ent-btn">
				<div class="btn" id="xiadan">
					<span>确认下单</span>
				</div>
			</div>
			</div>
		</div>
	</div>
	</div>
	</div>











<div style="width:100%; height:100%; padding-left:450px;">
  <div class="md-modal md-effect-13" id="modal-13">
    <div class="md-content">
      <div>
						  <input type="text" id='input' placeholder="点击地图显示地址/输入地址显示位置"
								onkeydown="showMsg()" />
							<input type="button" value="搜索" id="soso" onclick="hah()" />
							<div id='container'></div>
							<div id="tip"></div>
							<input type="text" id="message" size="50px"/>
							<input type="button" id="btn" value="确认保存" class="md-close" /><%-- class="md-close"	--%>
							<br />
      </div>
    </div>
  </div>
  
  
  <div class="md-overlay"></div>
  <!-- the overlay element --> 
</div>



<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.1/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			function refresh() 
			{ 
				history.go(0); 
			} 
			setTimeout("refresh()",1000); 
			
			
			function getAddress(){
				$.ajax({
	 	 			type:"post",
	 	 			url:"who_order_getAddress.action",
	 	 			datatype:"json",
	 	 			success:function(data){
	 	 				data = data.slice(1, data.length);
	 	 	 			data = data.slice(0, data.length-1);
	 	 	 			var strs= data.split(",");
	 	 	 			if(strs!=""){
		 	 	 			var id=[];
		 	 	 			var address=[];
		 	 	 			var name=[];
		 	 	 			var phone=[];
		 	 				for(var i=0;i<strs.length;i++){
		 	 					if(i%4==0){
		 	 						id[id.length]=strs[i];
		 	 					}else if(i%4==1){
		 	 						address[address.length]=strs[i];
		 	 					}else if(i%4==2){
		 	 						name[name.length]=strs[i];
		 	 					}else{
		 	 						phone[phone.length]=strs[i];
		 	 					}
		 	 				}
		 	 				for(var i=0;i<id.length;i++){
		 	 					var str=$("#oldAddress").html();
		 	 					if(i==0){
		 	 						str="<div><input type='radio' name='selectAddress' value='"+id[i]+"'checked/> 地址：<span>"+address[i]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;姓名：<span>"+name[i]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;电话：<span>"+phone[i]+"</span></div>";
		 	 					}else{
		 	 						str +="<div><input type='radio' name='selectAddress' value='"+id[i]+"'/> 地址：<span>"+address[i]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;姓名：<span>"+name[i]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;电话：<span>"+phone[i]+"</span></div>";
		 	 					}
		 	 					$("#oldAddress").html(str);
		 	 				}
	 	 	 			}
	 	 			}
	 	 		});
			};
			getAddress();
		    	  
		    	  function Total(){
		  	        var money=0;
		  	        var txt = $(".num"); 
		  	        for (var i = 0; i < txt.length; i++) {
		  	            money += (txt.eq(i).val()*1) * (txt.eq(i).parent().parent().parent().find(".danjia").html()*1);
		  	        }
		  	        
		  	      $("#summoney").html(money);
		  	    };
		    	  Total();
		    	  
					//加的效果
					$(".add").click(function(){
						var n=$(this).prev().val();
						var num=parseInt(n)+1;
						$(this).prev().val(num);
						Total();
						var id=$(this).parent().parent().parent().find(".munuid").html();
						getNum(num,id);
						
					});
					//减的效果
					$(".jian").click(function(){
						var n=$(this).next().val();
						var num=parseInt(n)-1;
						if(num<1){num=1;}
						$(this).next().val(num);
						Total();
						var id=$(this).parent().parent().parent().find(".munuid").html();
						getNum(num,id);
						});
				
					
					$(".num").blur(function (){
						var num=$(this).val()*1;
						if(num<1){
							num=1;
						}
						$(this).val(num);
						Total();
						var id=$(this).parent().parent().parent().find(".munuid").html();
						getNum(num,id);
					});
					
					
					 function getNum(num,id){
						    $.ajax({
								type: 'POST',
								url: 'shopOk_setParams.action',		
								data:{num:num,id:id},
								dataType: 'json',
								success: function(data){
								   
								}
							});	
							
					}
			$("#addxxdz").blur(function(){
				$.ajax({
	 	 			type:"post",
	 	 			url:"who_order_saveXiangxi.action",
	 	 			data:{xiangxi:$("#addxxdz").val()},
	 	 			datatype:"json",
	 	 			success:function(data){
	 	 			}
	 	 		});
			});
			$("#addname").blur(function(){
				$.ajax({
	 	 			type:"post",
	 	 			url:"who_order_saveName.action",
	 	 			data:{mingzi:$("#addname").val()},
	 	 			datatype:"json",
	 	 			success:function(data){
	 	 			}
	 	 		});
			});
			$("#adddianhua").blur(function(){
				$.ajax({
	 	 			type:"post",
	 	 			url:"who_order_saveDianhua.action",
	 	 			data:{dianhua:$("#adddianhua").val()},
	 	 			datatype:"json",
	 	 			success:function(data){
	 	 			}
	 	 		});
			});
			
			
		});
		$("#delectAddress").click(function(){
			var id = $("#oldAddress input[name='selectAddress']:checked").val();
			$.ajax({
 	 			type:"post",
 	 			url:"who_order_deleteAddress.action",
 	 			data:{deleteid:id},
 	 			datatype:"json",
 	 			success:function(data){
 	 				window.location.href = 'http://localhost:8080/repast/qiantai/qrxdan/xiadan.jsp';
 	 			}
 	 		});
		});
		$("#qingkong").click(function(){
			$("#adddizhi1").hide();
			$.ajax({
 	 			type:"post",
 	 			url:"who_order_qingAddress.action",
 	 			datatype:"json",
 	 			success:function(data){
 	 			}
 	 		});
		});
		$("#xiadan").click(function (){
			var id = $("#oldAddress input[name='selectAddress']:checked").val();
			$.ajax({
 	 			type:"post",
 	 			url:"who_order_orderok.action",
 	 			data:{addressid:id},
 	 			datatype:"json",
 	 			success:function(data){
 	 				window.location.href = 'http://localhost:8080/repast/qiantai/qrxdan/orderok.jsp';
 	 			}
 	 		});
		});
	</script>

<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>
<script type="text/javascript" src="js/god.js"></script>
</body>
</html>
