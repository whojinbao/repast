<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>购物车</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/gouwu.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link href="css/component.css" rel="stylesheet">
	<script type="text/javascript"src="http://webapi.amap.com/maps?v=1.3&key=1e0f7c1cdf3a9526dbaf174623808955"></script>
	<script type="text/javascript"src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
	<script type="text/javascript"src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
	<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
	<style type="text/css">
	</style>
</head>
<body><script src="/demos/googlegg.js"></script>
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
		<div class="wrap-right">
			<div class="right-content">
				<div class="item">
					<div class="right-header">
						<h2>收货地址</h2>
					</div>
					<p>郑飞<span>先生</span>1000000000</p>
					<p>北京海淀区北京大学万柳公寓</p>
				</div>
				<div id="addposition"><a href="javascript:;" class="md-trigger  btn-sm" data-modal="modal-13"><button>+新加地址</button></a></div>
				

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


		<div style="width:1000px; height:500px; padding-left:450px;">
		  <div class="md-modal " id="modal-13" style="width:1000px; height:500px; ">
			<div class="md-content ">
			  <div>
					<input type="text" id='input' placeholder="点击地图显示地址/输入地址显示位置"
						onkeydown="showMsg()" />
					<input type="button" value="搜索" onclick="hah()" />
					<div id='container'></div>
					<div id="tip"></div>
					<input type="text" id="message" size="100px" />
					<input type="button" id="btn" value="确认保存" />
					<br />
					<input type="text" id="successLng" />
					<input type="text" id="successLat" />
				<button class="md-close btn-sm btn-primary">Close me!</button>
			  </div>
			</div>
		  </div>
		  
		  
		  <div class="md-overlay"></div>
		  <!-- the overlay element --> 
		</div>








  