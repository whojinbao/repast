<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/frame.css">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="../css/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../css/bootstrap.min.js"></script>
</head>
<body>
	<div id="tab">
		<div id="map">
			<ul>
				<li id="li1" class="tabStyle" onclick="showDiv('1')"><a
					href="k_select.action">所有桌子<a />
				</li>
				<li id="li2" onclick="showDiv('2')"><a href="k_selecd.action">大厅<a />
				</li>
				<li id="li3" onclick="showDiv('3')"><a href="k_selecb.action">包箱<a />
				</li>
			</ul>
			<form action="k_select3.action" method="post">
				<button type="submit" class="btn btn-warning">查询</button>
				: <input type="text" name="jz.MaxPerson" value="" /> 
				<select
					name="jz.staticName">
					<option>可用</option>
					<option>占用</option>
					<option>损坏</option>
					<option>待扫</option>
				</select>
			</form>
		</div>
		<div id="content">
			<div id="div1">
				<iframe width="100%" height="80%" src="allcan.jsp" name="a1">
					
				</iframe>
			</div>
			<div id="div2">
				<iframe width="100%" height="80%" src="hall.jsp" name="a1">

				</iframe>
			</div>
			<div id="div3">
				<iframe width="100%" height="80%" src="box.jsp" name="a1">

				</iframe>
			</div>
		</div>
		<div id="bb1">
			<button type="button" class="btn btn-success btn-lg"
				data-toggle="modal" data-target="#myModal">开台</button>
			<br /> <br /> <br />
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
							<form action="k_update.action" method="post">
								桌子编号:<input type="text" name="jz.seatid"> 								
								桌子状态: <select
									name="jz.staticName">
									<option>可用</option>
									<option>占用</option>
								</select> <input type="submit" value="提交">
							</form>
						</div>
					</div>
				</div>
			</div>
			<button type="button" class="btn btn-success">催菜</button>
			<br /> <br /> <br />
			<button type="button" class="btn btn-success">加菜</button>
			<br /> <br /> <br />
			<button type="button" class="btn btn-success btn-lg"
				data-toggle="modal" data-target="#myModal2">清扫</button>
			<br /> <br /> <br />
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
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
							<form action="k_update.action" method="post">
								桌子编号:<input type="text" name="jz.seatid"> 桌子状态: <select
									name="jz.staticName">
									<option>可用</option>
									<option>占用</option>
									<option>待扫</option>
								</select> <input type="submit" value="提交">
							</form>
						</div>
					</div>
				</div>
			</div>
			<button type="button" class="btn btn-success btn-lg"
				data-toggle="modal" data-target="#myModal1">结账</button>
			<br /> <br /> <br />
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
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
							<form action="k_update.action" method="post">
								桌子编号:<input type="text" name="jz.seatid"> 桌子状态: <select
									name="jz.staticName">
									<option>占用</option>
									<option>可用</option>
								</select> <input type="submit" value="提交">
							</form>
						</div>
					</div>
				</div>
			</div>
			<br /> <br /> <br />
		</div>
	</div>
	<div></div>
	<script type="text/javascript">
		function showDiv(id){
			 for ( var i = 1; i <= 3; i++) 
			{
				document.getElementById("li" + i).className = "";
				document.getElementById("div" + i).style.display = "none";
			} 
			document.getElementById("li" + id).className = "tabStyle";
			document.getElementById("div" + id).style.display = "block";
		}
	</script>
</body>
</html>
