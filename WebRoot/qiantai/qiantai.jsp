
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="../css/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../css/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"
	type="text/css">
<nk> <script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
.diamond {
	width: 120px;
	height: 120px;
	border: none;
	transform: rotate(45deg);
	-ms-transform: rotate(45deg); /* Internet Explorer */
	-moz-transform: rotate(45deg); /* Firefox */
	-webkit-transform: rotate(45deg); /* Safari 和 Chrome */
	-o-transform: rotate(45deg); /* Opera */
}

#top {
	position: absolute;
	background-color: red;
	top: 500px;
	left: 500px;
}

#bottom {
	position: absolute;
	background-color: red;
	top: 400px;
	left: 400px;
}

#left {
	position: absolute;
	background-color: red;
	top: 300px;
	left: 500px;
}

#right {
	position: absolute;
	background-color: red;
	top: 400px;
	left: 600px;
}

#dianmond_boss {
	height: 500px;
	width: 500px;
	position: absolute;
	left: -180px;
	top: -30px;
}

#hgh {
	width: 400px;
	height: 150px;
	margin-left: 100px;
	display: none;
}

#tab_c {
	width: 500px;
	position: absolute;
	left: 60%;
	top: 50%;
}

.reg {
	margin-left: 19px;
}

.paly {
	margin-left: 170px;
	color: #0033CC;
}

#begin {
	position: absolute;
	top: 55%;
	left: 35%;
	width: 200px;
	height: 50px;
	font-size: 20px;
}

#begin input {
	width: 200px;
	height: 50px;
	opacity: 0.7;
	filter: alpha(opacity =   70); /* 针对 IE8 以及更早的版本 */
}

.selectnum {
	position: absolute;
	top: 20px;
	left: 20px;
}

.selectnum input {
	width: 90px;
}

.shownum {
	position: absolute;
	top: 20px;
	left: 20px;
	display: none;
}

.shownum span {
	color: red;
	font-size: 20px;
}

#master_memu_tel {
	position: absolute;
	top: 300px;
	right: 10px;
	width: 30px;
	POSITION: fixed;
	z-index: 200;
}
</style>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
</HEAD>
<BODY>

	<div id="dianmond_boss">
		<button class="diamond" id="bottom" onclick="shoe1()" type="button"
			class="btn btn-primary btn-lg" data-toggle="modal"
			data-target="#myModal">登录</button>
		<button class="diamond" id="left">注册</button>
		<button class="diamond" id="right">点开</button>
		<button class="diamond" id="top">按钮</button>
		<div>
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
						<div class="modal-body">...</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				var hah = document.getElementById("hgh");
				function shoe() {
					hah.style.display = "block";

				}
				/* 注册  */

				var hah1 = document.getElementById("hgh1");
				function shoe1() {
					hah1.style.display = "block";

				}
			</script>
</BODY>
</HTML>
