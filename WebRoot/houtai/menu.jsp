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
<title>菜谱设置</title>
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body class="pos-r">

<div style="margin-left:0px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
	 <span class="c-gray en">&gt;</span>菜谱管理 <span class="c-gray en">&gt;</span> 菜品列表 
	 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" 
	 href="menu_selMenu.action" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c"> 
		    <form  action="menu_selMhMenu.action" method="post">
			<input type="text" name="menuName" id="mhMenuName" placeholder=" 菜品名称" style="width:250px" class="input-text" onClick="mhSelMenu()">
		  	<button name="" id="" class="btn btn-success" type="submit" > <i class="Hui-iconfont">&#xe665;</i> 搜产品</button>
		    </form>
		</div>
		<%-- <div id="menuSelResult" class="text-c" border="1px">
		     <c:forEach items="${menuList }" var="menu">
		         <span id="mhSelMenuResult">${menu.menuName }</span> <br>
		     </c:forEach>
		</div> --%>
		
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a class="btn btn-primary radius" onclick="product_add('添加产品','menuAdd.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span> <span class="r">共有数据：<strong>${MenuPageUtil.count }</strong> 条</span> </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40"><input name="" type="checkbox" value=""></th>
						<th width="60">菜品ID</th>
						<th width="120">缩略图</th>
						<th width="100">菜品名称</th>
						<th width="100">菜品分类</th>
						<th width="100">制作时间</th>
						<th width="100">可合菜数量</th>
						<th>描述</th>
						<th width="100">单价</th>
						<th width="100">发布状态</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${MenuPageUtil.list }" var="menu">
					<tr class="text-c va-m">
						<td><input name="" type="checkbox" value=""></td>
						<td>${menu.menuId }</td>
						<td><img width="40" height="40" class="product-thumb" src="../fileUpload/5.jpg"></img>${menu.imgUrl }</td>
						<td class="text-l">${menu.menuName} </td>
						<td class="text-l">${menu.menuTypeName }</td>
					    <td class="text-l" >${menu.doTime }</td>
						<td class="text-l">${menu.maxNum }</td> 
						
						<td class="text-l">${menu.menuDescribe }</td>
						<td><span class="price">${menu.menuPrice }</span> 元/份</td>
						<td class="td-status"><span class="label label-success radius">已发布</span></td>
						<td class="td-manage">
						   <a style="text-decoration:none" onClick="product_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
						   <a style="text-decoration:none" class="ml-5" href="menu_selIdMenu.action?menuId=${menu.menuId }" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
						   <a style="text-decoration:none" class="ml-5" onClick="product_del(this,'${menu.menuId }')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>${MenuPageUtil.pageStr }</div>
		</div>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
						

/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*产品-下架*/
function product_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*产品-发布*/
function product_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}


/*产品-删除*/
function product_del(obj,id){
alert(id);
	
		$.ajax({
			type: 'POST',
			url: 'menu_del.action?menuId='+id,
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
 
/* 搜索结果显示*/
/**

function mhSelMenu(){
alert("mh");
     $.ajax({
			type: 'POST',
			url: 'menu_selMhMenu.action',
			data:{menuName:},
			dataType: 'json',
			success: function(data){
				
				
			},
			error:function(data) {
				console.log(data.msg);
			},
		});	

} */


</script>
</body>
</html>