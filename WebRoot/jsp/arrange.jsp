<%@page import="com.who.struts.ArrangeAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
<style type="text/css">
.col-xs-6 {
	border: 1px solid red;
}

* {
	margin: 0px;
	padding: 0px;
}

a {
	text-decoration: none;
}

ul,li {
	list-style: none;
	float: left;
}

#top {
	height: 60px;
	color: white;
	background: url("../image/paican.png") no-repeat 80px 0px;
	background-color: #222;
	position: relative;
}

#top a {
	color: red;
}

#user {
	position: absolute;
	top: 20px;
	right: 50px;
	width: 120px;
	height: 30px;
}

.row {
	width: 101%;
}

#nav {
	height: 30px;
	color: white;
	background-color: #EEEEEE;
	position: relative;
}

#nav_sort {
	position: absolute;
	top: 2px;
	right: 20px;
	color: red;
	width: 300px;
	height: 30px;
}

#nav_sort .btn {
	height: 25px;
	line-height: 12.5px;
}

.buttom {
	height: 80%;
	border: 10px solid #EEF9F0;
	border-left: 5px solid #EEF9F0;
	border-right: 5px solid #EEF9F0;
	position: relative;
}

.sortname {
	margin-top: 5px;
	margin-left: 5px;
}

.sortname_left .form-control,.sortname_left .btn-default {
	height: 20px;
	font-size: 10px;
	line-height: 10px;
}

.sortname_left .input-group {
	width: 180px;
}

.sortname_left {
	position: absolute;
	top: 5px;
	right: 0px;
	width: 230px;
}

#sortname_table {
	width: 100%;
	margin-top: 10px;
}

#sortname_table td {
	font-size: 12px;
	text-align: center;
}
</style>

</head>

<body>
	<div class="row">
		<div class="col-xs-12 col-sm-12" id="top">
			<div id="user">
				欢迎&nbsp;&nbsp;<span>郑飞</span>&nbsp;&nbsp;<a href="#">注销</a>
			</div>
		</div>
		<div class="col-xs-12 col-sm-12" id="nav">
			<div id="nav_sort">
				<span>排餐方式</span>&nbsp;
				<button class="btn btn-default">全单</button>
				<button class="btn btn-default">依次</button>
				<button class="btn btn-default">智能</button>
			</div>
		</div>
		<div class="col-xs-12 col-sm-3 buttom">
			<div class="sortname">
				<span>&nbsp;&nbsp;&nbsp;桌子</span>
				<div class="sortname_left">
					<div class="col-lg-8">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="输入桌号进行查询">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">查询</button> </span>
						</div>
					</div>
				</div>
				<div>
					<table id="sortname_table">
						<tr>
							<td>桌号</td>
							<td>总数量</td>
							<td>已上</td>
							<td>最后上餐时间</td>
							<td>预计等待时间</td>
						</tr>
						
					</table>
				</div>
				<div  style="width:100%;height:88%;overflow: auto;">
				<table  id="sortname_table">
					<tr><td width=10% ></td><td width=10% ></td><td width=10% ></td><td  width=22% ></td><td  width=22% ></td></tr>
					<c:forEach items="${total}"var="dishes">
			    		<tr>
			    			<td>${dishes.seatId }</td>
			    			<td>${dishes.countNum }</td>
			    			<td>${dishes.have }</td>
			    			<td>${dishes.lastTime }</td> 
			    			<td>${dishes.waitTime }</td>
			    			
			    		</tr>
    				</c:forEach>
				</table></div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-5 buttom">
			<div class="sortname">炒菜</div>
			<div>
				<table id="sortname_table">
					<tr>
						<td  width=10% >菜品名称</td>
						<td  width=10% >数量（份）</td>
						<td  width=10% >等待时间</td>
						<td  width=30% >操作</td>
						<td  width=10% >所属桌台号</td>
					</tr>
				</table>
			</div>
			<div  style="width:100%;height:88%;overflow: auto;">
				<table  id="sortname_table">
					<tr><td width=10% ></td><td width=10% ></td><td width=10% ></td><td  width=30% ></td><td  width=10% ></td></tr>
				
					<c:forEach items="${dishesing}"var="dishes">
			    		<tr>
			    			<td>${dishes.menuName }</td>
			    			<td>
			    				<c:forEach items="${dishes.detailednum }"var="detailednum">
			    				${detailednum}、
			    				</c:forEach>
			    			</td>
			    			<td>${dishes.EWT }</td>
			    			<td>${dishes.startTime }</td> 
			    			<td>${dishes.seatId }</td>
			    			
			    		</tr>
    				</c:forEach>
				</table>
			</div>

		</div>
		<div class="col-xs-12 col-sm-2 buttom">
			<div class="sortname">非炒菜</div>
			<div>
				<table id="sortname_table">
					<tr>
						<td>桌号</td>
						<td>菜品名</td>
						<td>操作</td>
					</tr>
				</table>
			</div>
			<div  style="width:100%;height:88%;overflow: auto;">
				<table  id="sortname_table">
					<tr><td width=10% ></td><td width=10% ></td><td width=10% ></td></tr>
					<tr><td>1</td><td>2</td><td>3</td></tr>
				</table>
			</div>
		</div>
		<div class="col-xs-12 col-sm-2 buttom">
			<div class="sortname">其他</div>
			<div>
				<table id="sortname_table">
					<tr>
						<td>桌号</td>
						<td>菜品名</td>
						<td>操作</td>
					</tr>
				</table>
			</div>
			<div  style="width:100%;height:88%;overflow: auto;">
				<table  id="sortname_table">
					<tr><td width=10% ></td><td width=10% ></td><td width=10% ></td></tr>
					<tr><td>1</td><td>2</td><td>3</td></tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
