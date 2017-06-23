<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
</style>

</head>

<body>
	<div id="dianmond_boss">
		<button class="diamond" id="top">按钮</button>
		<button class="diamond" id="bottom">登录</button>
		<button class="diamond" id="left">注册</button>
		<button class="diamond" id="right">点开</button>
		<div>
</body>
</html>
