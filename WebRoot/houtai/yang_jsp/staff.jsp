<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
table {
	text-align: center;
}

#a1 {
	width: 300px;
}
</style>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />


<link rel="stylesheet" href="../static/h-ui/css/H-ui.css"
	type="text/css"></link>
<link rel="stylesheet" href="../static/h-ui.admin/css/H-ui.admin.css"
	type="text/css"></link>
<link rel="stylesheet" href="../lib/Hui-iconfont/1.0.8/iconfont.css"
	type="text/css"></link>
<link rel="stylesheet" href="../static/h-ui.admin/skin/default/skin.css"
	type="text/css"></link>
<link rel="stylesheet" href="../static/h-ui.admin/css/style.css"
	type="text/css"></link>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
	src="../static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript"
	src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
	src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>


</head>
<body>
<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<nav class="nav navbar-nav">
			</nav>
		</div>
	</header>
	<div class="Hui-article">
		<article class="cl pd-20">
		<div class="text-c">
			日期范围： <input type="text"
				onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
				id="datemin" class="input-text Wdate" style="width:120px;">
			- <input type="text"
				onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
				id="datemax" class="input-text Wdate" style="width:120px;">
			<form action="user_select1.action"method="post">	
			<input type="text" class="input-text" style="width:250px"
				placeholder="输入管理员名称" name="pp.user_name">
			<button type="submit" class="btn btn-success">
				<i class="Hui-iconfont">&#xe665;</i> 搜用户
			</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="admin-add.jsp" onclick="admin_add('添加员工','admin-add.html','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加员工</a>
			<a href="user_select.action"><button type="button" class="btn btn-primary">查询</button> </a>
			</span> 
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="10">员工列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">账号</th>
					<th width="80">用户名</th>
					<th width="100">性别</th>
					<th width="130">年龄</th>
					<th width="100">地址</th>
					<th width="100">权限</th>
					<th width="100">密码</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lq}" var="pp">
					<tr>
					<td width="25"><input type="checkbox" name="" value=""></td>
						<td>${pp.user_id}</td>
						<td>${pp.user_name}</td>
						<td>${pp.user_sex}</td>
						<td>${pp.user_age}</td>
						<td>${pp.user_addr}</td>
						<td>${pp.name}</td>
						<td>${pp.user_pwd}</td>
						<td><a href="user_delete.action?a=${pp.user_id}">
								<button type="button" class="btn btn-primary">删除</button> </a> <!-- Button trigger modal -->
							<button type="button" class="btn btn-primary btn-lg"
								data-toggle="modal" data-target="#myModal">更新</button> <!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body">
											<form action="user_update.action" method="post">
												条件:<input type="text" name="pp.user_id" /><br> <br>
												年龄:<input type="text" name="pp.user_age" /><br><br>
												地址:<input type="text" name="pp.user_addr" /><br><br>
												密码:<input type="text" name="pp.user_pwd" /><br><br>
												<input type="submit" value="提交" />	
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</article>
	</div>
	</section>

	<!--请在下方写此页面业务相关的脚本-->

	<script type="text/javascript">
		/*
		 参数解释：
		 title	标题
		 url		请求的url
		 id		需要操作的数据id
		 w		弹出层宽度（缺省调默认值）
		 h		弹出层高度（缺省调默认值）
		 */
		/*管理员-增加*/

		function admin_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-删除*/
		function admin_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//此处请求后台程序，下方是成功后的前台处理……

				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}
		/*管理员-编辑*/
		function admin_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-停用*/
		function admin_stop(obj, id) {
			layer
					.confirm(
							'确认要停用吗？',
							function(index) {
								//此处请求后台程序，下方是成功后的前台处理……

								$(obj)
										.parents("tr")
										.find(".td-manage")
										.prepend(
												'<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
								$(obj)
										.parents("tr")
										.find(".td-status")
										.html(
												'<span class="label label-default radius">已禁用</span>');
								$(obj).remove();
								layer.msg('已停用!', {
									icon : 5,
									time : 1000
								});
							});
		}

		/*管理员-启用*/
		function admin_start(obj, id) {
			layer
					.confirm(
							'确认要启用吗？',
							function(index) {
								//此处请求后台程序，下方是成功后的前台处理……
								$(obj)
										.parents("tr")
										.find(".td-manage")
										.prepend(
												'<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
								$(obj)
										.parents("tr")
										.find(".td-status")
										.html(
												'<span class="label label-success radius">已启用</span>');
								$(obj).remove();
								layer.msg('已启用!', {
									icon : 6,
									time : 1000
								});
							});
		}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
