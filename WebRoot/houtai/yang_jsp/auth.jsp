<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="Bookmark" href="favicon.ico" >
	<link rel="Shortcut Icon" href="favicon.ico" />

  
  <link rel="stylesheet" href="../static/h-ui/css/H-ui.min.css" type="text/css"></link>
  
  <link rel="stylesheet" href="../static/h-ui.admin/css/H-ui.admin.css" type="text/css"></link>
  
  <link rel="stylesheet" href="../lib/Hui-iconfont/1.0.8/iconfont.css" type="text/css"></link>
  
  <link rel="stylesheet" href="../static/h-ui.admin/skin/default/skin.css" type="text/css"></link>
  
  <link rel="stylesheet" href="../static/h-ui.admin/css/style.css" type="text/css"></link>
  <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
  
  <script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
  
  <script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
  
  <script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script>
  
  <script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
  
  <script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
  
  <script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
  </head>
  
  <body>
    <section class="Hui-article-box">
	
	<div class="Hui-article">
		<article class="cl pd-20">
			
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="auth_select.action"><button type="button" class="btn btn-primary">查询</button></a>&nbsp<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">增加</button>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form action="auth_save.action" method="post">
									id:<input type="text" name="aut.authId"><br /> <br />
									名字:<input type="text" name="aut.authName"><br /> <br />
									路径：<input type="text" name="aut.authPath"><br /> <br />
									父节点:<input type="text" name="aut.parentId"><br /> <br />
									描述:<input type="text" name="aut.authDescription"><br /> <br />
									<input type="submit" value="提交" />
								</form>
							</div>
						</div>
					</div>
				</div>
 </span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="80">ID</th>
							<th>名字</th>
							<th width="105">路径</th>
							<th width="105">父节点</th>
							<th width="105">功能描述</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
						
						<%--<tr class="text-c">
							<td><input type="checkbox" value="" name=""></td>
							<td>0001</td>
							<td>城市</td>
							<td>city</td>
							<td>city</td>
							<td>city</td>
							<td class="f-14"><a style="text-decoration:none" onclick="system_data_edit('角色编辑','system-data-edit.html','0001','400','310')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="system_data_del(this,'10001')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					--%>
				
					<c:forEach items="${lv}" var="tt">					
						<tr>						
						<td><input type="checkbox" value="" name=""></td>
						<td>${tt.authId}</td>
						<td>${tt.authName}</td>
						<td>${tt.authPath}</td>
						<td>${tt.parentId}</td>
						<td>${tt.authDescription}</td>
						<td>
					<a href="auth_delete.action?a=${tt.authId}">
						<button type="button" class="btn btn-primary">删除</button> 
					</a>
						<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">更新</button>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form action="auth_update.action" method="post">
									条件:<input type="text" name="tt.authId"><br /> <br />
									名字:<input type="text" name="tt.authName"><br /> <br />
									路径：<input type="text" name="tt.authPath"><br /> <br />
									父点:<input type="text" name="tt.parentId"><br /> <br />
									描述:<input type="text" name="tt.authDescription"><br /> <br />
									<input type="submit" value="提交" />
								</form>
							</div>
						</div>
					</div>
				</div>
				</td>
				</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>



<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
	]
});
/*数据字典-编辑*/
function system_data_edit(title,url,id,w,h){
  layer_show(title,url,w,h);
}
/*数据字典-删除*/
function system_data_del(obj,id){
  layer.confirm('确认要删除吗？',function(index){
    $(obj).parents("tr").remove();
    layer.msg('已删除!',{icon:1,time:1000});
  });
}
</script> 
  </body>
</html>
