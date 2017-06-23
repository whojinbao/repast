<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
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
<title>品牌管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 
 <span class="c-gray en">&gt;</span>菜谱设置
 <span class="c-gray en">&gt;</span>菜品分类
 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="menuType_sel.action?" title="刷新" >
 <i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form class="Huiform" method="post" action="menuType_add.action" target="_self">
		
			<input type="text" placeholder="分类名称" value="" class="input-text" style="width:120px" name="menuType.typeName">
			
			<input type="submit" class="btn btn-success" id="" name="submit" value="添加">
			<!-- <button type="submit" class="btn btn-success" id="" name="submit" onClick="picture_colume_add(this);"> 添加</button> -->
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"></span>每页${MenuTypePageUtil.maxPage }  条 <span class="r">共有数据：<strong>${MenuTypePageUtil.count }</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg ">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="70">ID</th>
					
					<th width="120">分类名称</th>
			
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			   <c:forEach items="${MenuTypePageUtil.list }" var="menuType">
			      <tr class="text-c">
				    	<td><input name="" type="checkbox" value=""></td>
					    <td>${menuType.typeId }</td>					
					    <td class="text-l"> ${menuType.typeName }</td>										
					    <td class="f-14 product-brand-manage">					  
					       <a style="text-decoration:none" class="ml-5" onClick="product_del(this,'${menuType.typeId }')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
					    </td> 
				   </tr>
			   </c:forEach>
								
			</tbody>
			
		</table>
		<div>${MenuTypePageUtil.pageStr }</div>
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
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
});


/**
*菜类删除
*
*/


function product_del(obj,id){
if(confirm("确认要删除吗？")){
		$.ajax({
			type: 'POST',
			url: 'menuType_del.action',
			data:{menuTypeId:id},
			dataType: 'json',
			success: function(data){
				
				$(obj).parents("tr").remove();	
					
			},
			error:function(data) {
				console.log(data.msg);
				
			},
			
		});		
}
}
</script>
</body>
</html>

