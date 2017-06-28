<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
	width: 1200px;
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

   
   </style>
  <body>
      	<div class="content">
      	    <div class="header">
				<h1>您的订单</h1>		
				
			</div>
			<div class="orderContetn">
		       <table >
			    <thead>
				   <tr class="">
					<th width="200">订单Id</th>				
					<th width="150">下单时间</th>
					<th width="130">桌号</th>
					<th width="150">员工Id</th>
					<th width="100">是否结账</th> <!--  -->
					<!-- <th width="100">订单类别</th>（外卖，线下）  -->
					<th width="150">总价</th>
					<th width="200">订单详情表</th>
				 </tr>
			   </thead>
			  <tbody		     
				  <tr class="">
					<td width="200">${orderResult.orderId }</td>				
					<td width="150">${orderResult.orTimes }</td>
					<td width="130">${orderResult.seatId }</td>
					<td width="150">${orderResult.staffId }</td>
					<td width="100">${orderResult.orderStatus }</td>
			<%-- 		<td>${orderResult.orderSort }</td> --%>
					<td width="150">${orderResult.totalPrice }</td>
					<td width="200"><a href="shopCart_detailedList?orderId=${orderResult.orderId }"/>订单详情</a></td>									
				  </tr>				
			  </tbody>
		   </table>
		   </div>
		  <div class="ent-btn">
			   
				<div class="btn" style="float:left;margin-left:20" >				   
					<a href="shopCart_clear.action?ip=clear"  style="text-decoration:none;color: #fff">加菜</a>
				</div>
				<div class="btn" style="float:left;margin-left:20" >				   
					<a href="shopCart_settle.action"  style="text-decoration:none;color: #fff">结账</a>
				</div>
		 </div>	
	</div>
  </body>
</html>
