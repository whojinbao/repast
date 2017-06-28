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
				<span>返回商家修改</span>
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
			    <tr>
			      <td>酸菜鱼米线</td>
			      <td>
			      	<div class="gw_num">
						<em class="jian">-</em>
						<input type="text" value="1" class="num"/>
						<em class="add">+</em>
					</div>
			      </td>
			      <td>¥100</td>
			    </tr>
			    <tr>
			      <td>麻辣米线</td>
			      <td>
			      	<div class="gw_num">
						<em class="jian">-</em>
						<input type="text" value="1" class="num"/>
						<em class="add">+</em>
					</div>
			      </td>
			      <td>¥100</td>
			    </tr>
			  </tbody>
			  <tfoot>
			    <tr>
			      <td colspan="2">餐盒</td>
			      <td >¥180</td>
			    </tr>
			    <tr>
			      <td colspan="2">配送费</td>
			      <td >¥180</td>
			    </tr>
			  </tfoot>
			</table>
			<div class="foot-content">
				<div class="sum">
					<h1><span>¥</span>145.00</h1>
				</div>
			</div>
		</div>
		<form action="">
		<div class="wrap-right">
			<div class="right-content">
				<div class="item">
					<div class="right-header">
						<h2>收货地址</h2>
					</div>
					<p>郑飞<span>先生</span>1000000000</p>
					
						<div id="oldAddress"></div>
					<div id="addposition">
						<a href="javascript:;" class="md-trigger btn-sm" data-modal="modal-13">
							<button>+新地址</button>
						</a>
						<button>删除此地址</button>	
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
				<div class="btn">
					<span>确认下单</span>
				</div>
			</div>
			</div>
		</div>
	</div>
	</div>
	</form>
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
			//加的效果
			$(".add").click(function(){
				var n=$(this).prev().val();
				var num=parseInt(n)+1;
				if(num==0){ return;}
					$(this).prev().val(num);
			});
			//减的效果
			$(".jian").click(function(){
				var n=$(this).next().val();
				var num=parseInt(n)-1;
			if(num==0){ return}
				$(this).next().val(num);
				});
			
			function getAddress(){
				$.ajax({
	 	 			type:"post",
	 	 			url:"who_order_getAddress.action",
	 	 			datatype:"json",
	 	 			success:function(data){
	 	 				data = data.slice(1, data.length);
	 	 	 			data = data.slice(0, data.length-1);
	 	 	 			var strs= data.split(",");
	 	 	 			var id=[];
	 	 	 			var name=[];
	 	 				for(var i=0;i<strs.length;i++){
	 	 					if(i%2==0){
	 	 						id[id.length]=strs[i];
	 	 					}else{
	 	 						name[name.length]=strs[i];
	 	 					}
	 	 				}
	 	 				for(var i=0;i<id.length;i++){
	 	 					var str=$("#oldAddress").html();
	 	 					if(i==0){
	 	 						str="<div><input type='radio' name='selectAddress' value='"+id[i]+"'checked/><span>"+name[i]+"</span></div>";
	 	 					}else{
	 	 						str +="<div><input type='radio' name='selectAddress' value='"+id[i]+"'/><span>"+name[i]+"</span></div>";
	 	 					}
	 	 					$("#oldAddress").html(str);
	 	 				}
	 	 			}
	 	 		});
			};
			getAddress();
		});
		
	</script>

<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>
<script type="text/javascript" src="js/god.js"></script>
</body>
</html>
