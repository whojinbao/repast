<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/style.css" />
<style type="text/css">
#a6 {
	width: 150px；
}
</style>
</head>

<body>
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
	桌子管理 <span class="c-gray en">&gt;</span> 桌子数据 </nav>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<a href="p_select1.action?">
			<button type="button" class="btn btn-primary">查询全部</button> </a>
		<button type="button" class="btn btn-primary btn-lg"
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
						<form action="p_add.action" method="post">
							桌子号:<input type="text" name="pp.seatid"><br /> <br />
							能座人数:<input type="text" name="pp.maxPerson"><br /> <br />
							桌子状态：<input type="text" name="pp.seatStatus"><br /> <br />
							服务员号:<input type="text" name="pp.staffId"><br /> <br />
							桌子图片:<input type="text" name="pp.imgid"><br /> <br />
							桌子房间:<input type="text" name="pp.rid"><br /> <br />
							<input type="submit" value="提交" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mt-20">
		<table
			class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value="">
					</th>
					<th width="80">桌子编号</th>
					<th>能座人数</th>
					<th width="105">桌子状态</th>
					<th width="105">服务员编号</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lz}" var="pp">
					<tr class="text-c">
						<td><input type="checkbox" value="" name="">
						</td>
						<td>${pp.seatid}</td>
						<td>${pp.maxPerson}</td>
						<td>${pp.seatStatus}</td>
						<td>${pp.staffId}</td>

						<td><button type="button" class="btn btn-primary btn-lg"
								data-toggle="modal" data-target="#myModal1">&#xe6df;</button>
							<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content" id="a6">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<form action="p_update.action" method="post" id="a1">
												桌子编号:<input type="text" name="pp.seatid"><br /> <br />
												桌子状态:<input type="text" name="pp.seatStatus"><br />
												<br /> <input type="submit" value="提交" />
											</form>
										</div>
									</div>
								</div>
							</div><a title="删除" href="p_delete.action?a=${pp.seatid}"><i
								class="Hui-iconfont"id="de1">&#xe6e2;</i>
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="../static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 5 ]
			} // 制定列不参与排序
			]
		});
		/*数据字典-编辑*/
		function system_data_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*数据字典-删除*/
		function system_data_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '',
					dataType : 'json',
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
	//删除的样式；
		$("#de1").click(
			function(){
				var a=confirm("确认要删除吗");
				if(a==true){
					return true;
				}else if(a==false){
					return false
				}
				
			}
		)
	</script>
</body>
</html>
