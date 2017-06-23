<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
      	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="100">订单Id</th>				
					<th width="100">下单时间</th>
					<th width="130">桌号（或客户id）</th>
					<th width="100">员工Id</th>
					<th width="100">订单状态（是否结账）</th>
					<th width="100">订单类别（外卖，线下）</th>
					<th width="100">总价</th>
					<th width="100">订单详情表</th>
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody>
		      <c:forEach items="${orderList }" var="order">
				 <tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${order.orderId }</td>				
					<td>${order.orderTimes }</td>
					<td>${order.seatId }</td>
					<td>${order.staffId }</td>
					<td>${order.orderStatus }</td>
					<td>${order.orderSort }</td>
					<td>${order.totalPrice }</td>
					<td><a href="detailed_selDetailed.action?orderId=${order.orderId }"/>订单详情表</a></td>
					
					<td class="f-14">
					    <a title="删除" href="javascript:;" onclick="user_del(this,'${order.orderId }')" class="ml-5" style="text-decoration:none">
					    <i class="Hui-iconfont">&#xe6e2;</i></a>
					    
					    </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
  </body>
</html>
