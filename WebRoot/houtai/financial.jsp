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
   #DataTables_Table_0_length{
   display:none;
   }
   #DataTables_Table_0_info{
   display:none;
   }
   #DataTables_Table_0_paginate{
   display:none;
   }
   table{
      margin-top:50px;
      text-align:center;
   }
   table th{
     
      font-size:20px;
   }
   table tr td{
      font-size:18px;
   }
</style>

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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 财务报表 <span class="c-gray en">&gt;</span> 营业数据分析<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="#" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="order_getStatistic.action" method="post">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;" name="startTime">
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;" name="endTime">		
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
	</div>
	</form>
	<div class="table-responsive">
		<table class="table table-hover">
		      <th colspan="3">菜品欢迎程度</th>
		      <tr><td colspan="3">最受欢迎菜品(3道)</td></tr>
              <tr> 
                   <td width="200px">菜品</td>
                   <td width="200px">数量</td>
                   <td width="200px">占总销售比例</td>
              </tr>
              <c:forEach items="${goodmenuList }"  var="menu">
                 <tr> 
                   <td width="200px">${menu.menuName }</td>
                   <td width="200px">${menu.num }</td>
                   <td width="200px">${menu.scale }</td>
              </tr>  
              </c:forEach>
              <tr><td colspan="3">不受欢迎产品(3道)</td></tr>
              <tr>
                   <td width="200px">菜品</td>
                   <td width="200px">数量</td>
                   <td width="200px">上次售出时间</td>
              </tr> 
               <c:forEach items="${badmenuList }"  var="menu">
                 <tr> 
                   <td width="200px">${menu.menuName }</td>
                   <td width="200px">${menu.num }</td>
                   <td width="200px">${menu.scale }</td>
              </tr>  
              </c:forEach>           
         </table>
	</div>
	<div class="table-responsive">
		<table class="table table-hover">
		      <th colspan="3">营业额</th>
             <tr> 
                   <td width="200px">营业总额</td>
                   <td width="200px">日均</td>
                  
              <tr>
                   <td width="200px">${orderUtil2.totalPrice }</td>
                   <td width="200px">${orderUtil2.avgPrice }</td>
                   
              </tr>       
         </table>
	</div>
	<div class="table-responsive">
		<table class="table table-hover">
		      <th colspan="3">下单情况</th>
              <tr> 
                   <td width="200px">下单总数</td>
                   <td width="200px">每单平均金额</td>
                  
              </tr>
              <tr>
                   <td width="200px">${orderUtil2.totalOrder }</td>
                   <td width="200px">${orderUtil2.avgorderPrice }</td>
                  
              </tr>
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


</script>
</body>
</html>
