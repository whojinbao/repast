<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
<style type="text/css">
 body{
	background: #f7f7f7;
}
.content{
	margin-top:50px;
	margin-left:200px;
	width: 65%;
	min-width:800px;
	height: 100%;
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

text-align:center;
height:30px;
}
#xinxishow{
	margin-left:50px;
}
#xinxishow div{
	margin-top:10px;
}
  th,td{
  	border:1px solid red;
  } 
   </style>
  <body>
      	<div class="content">
      	    <div class="header">
				<h1>个人中心</h1>	
			</div>
			<div class="orderContetn">
				<h4><div id="xinxishow">
					<div>账号 ：<span>${phone }</span></div>
					<div>姓名：<span>${username }</span></div>
				</div></h4>
		       <table >
			    <thead>
				   <tr class="">
					<th width="200">编号</th>				
					<th width="150">时间</th>
					<th width="150">价格</th>
					<th width="150">状态</th>
				 </tr>
			   </thead>
			  <tbody
			  	<c:forEach items="${dingdan }" var="dd">		     
				  <tr class="">
					<td width="200">${dd.id }</td>				
					<td width="150">${dd.time }</td>
					<td width="150">${dd.price }</td>
					<td width="150">${dd.status }</td>
					</tr>
				</c:forEach>				
			  </tbody>
		   </table>
		   </div>
		  <!-- <div class="ent-btn">
			   
				<div class="btn" style="float:left;margin-left:20" >				   
					<a href="shopCart_clear.action?ip=clear"  style="text-decoration:none;color: #fff">加菜</a>
				</div>
				<div class="btn" style="float:left;margin-left:20" >				   
					<a href="shopCart_settle.action"  style="text-decoration:none;color: #fff">结账</a>
				</div>
		 </div>	 -->
	</div>
  </body>
</html>
