<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>

<style type="text/css">
   #DataTables_Table_0_filter{
   display:none;
   }
   #btn btn-danger radius{
    display:none;
   }
</style>

<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>查询订单</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 查询订单<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="order_selOrder.action" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="order_selMhOrder.action" method="post">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;" name="startTime">
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;" name="endTime">
		<input type="text" class="input-text" style="width:250px" placeholder="桌号" id="" name="mhOredrSeatId">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
	</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="100">订单Id</th>				
					<th width="100">下单时间</th>
					<th width="130">桌号</th>
					<th width="100">桌号</th>
					<th width="100">订单状态（是否结账）</th>
					<th width="100">订单类别（外卖，线下）</th>
					<th width="100">总价</th>
					<th width="100">订单详情表</th>
				</tr>
			</thead>
			<tbody>
		      <c:forEach items="${orderList }" var="order">
		      
				 <tr class="text-c">
					<td>${order.orderId }</td>				
					<td>${order.orTimes  }</td>
					<td>${order.seatId }</td>
					<td>${order.seatId }</td>
					<td>${order.orderStatus }</td>
					<td>${order.orderSort }</td>
					<td>${order.totalPrice }</td>
					<td><a href="detailed_selDetailed.action?orderId=${order.orderId }"/>订单详情表</a></td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
});
<%--
/*用户-删除*/
function user_del(obj,id){
		$.ajax({
			type: 'POST',
			url: 'order_delOrder.action?',
			data:{orderId:id},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	
}

--%>
</script>
</body>
</html>
