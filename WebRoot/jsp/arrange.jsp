<%@page import="com.who.struts.ArrangeAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
a:HOVER{
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
	width: 230px;
}

.sortname_left {
	position: absolute;
	top: 5px;
	right: 0px;
	width: 270px;
}

#sortname_table {
	width: 100%;
	margin-top: 10px;
	position:relative;
}

#sortname_table td {
	font-size: 12px;
	text-align: center;
	padding-left: 5px;
}
#sortname_table tr {
	margin-top:10px;
	height:23px;
}
.table_caozuo {
	width: 80%;
	height: 18px;
	position: relative;
}

.table_caozuo_shangcai {
	border: none;
	width: 60px;
	height: 100%;
	background-color: #51D862;
	position: absolute;
	top: 0px;
	right: 0px;
}
.table_caozuo_pengren {
	border: none;
	width: 60px;
	height: 100%;
	background-color:#FFFF00;
	position: absolute;
	top: 0px;
	right: 0px;
}

.lanren {
	width: 80%;
	border: 1px solid #2BB7E4;
	height: 18px;
	color: red;
}

.bar {
	display: block;
	background: #2BB7E4;
	float: left;
	height: 100%;
	text-align: center;
	line-height: 18px;
	color: #fff;
}

.bar1,.bar2 {
	display: none;
}
table tr{
	
  text-align: center;
}
table tr td {
  background: #eaf3f5;
}

table tr:nth-of-type(2n+2) td {
  background: #ffffff;
}
#updatehearth{
	position:absolute;top:0px;left:0px;background-color:white;display:none;
}
#hearthxiugai_hidden{
	display:none;
}
#hearthxiugai_show{
	display:block;
}
#updateDsihes_error_hidden{
	display:none;
}
#updateDsihes_error_show{
	display:block;
}
.othes_cool{
	width:35px;
	height:18px;
	background-color:#51D862;
	border:none;
}
#sortColor1{
	background-color: #33FFFF;
}
#sortColor2{
	background-color: none;
}
td{
	border:2px solid white;
	text-align: center;
}
.you2{
	width:300px;
}
.zhuo{
	width:300px;
}
.chao{
	width:630px;
}
</style>

<script type="text/javascript" src="../js_who/jquery-2.1.3.min.js"></script>
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
				<a  href="arr_updateSort.action?sortid=1"><button id="sortColor${sortColor1}" class="btn btn-default">排1</button></a>
				<a  href="arr_updateSort.action?sortid=2"><button id="sortColor${sortColor2}" class="btn btn-default">排2</button></a>
				<a  href="arr_updateSort.action?sortid=3"><button id="sortColor${sortColor3}" class="btn btn-default">排3</button></a>
			</div>
		</div>
		<div class="col-xs-12 col-sm-2 buttom zhuo">
			<div class="sortname">
				<span>&nbsp;&nbsp;&nbsp;桌子</span>
				<div class="sortname_left">
					<div class="col-lg-8">
						<!-- <div class="input-group">
							<input type="text" class="form-control" placeholder="输入桌号进行查询">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">查询</button> </span>
						</div> -->
					</div>
				</div>
				<div>
					<table id="sortname_table">
						<tr>
							<td width=10%>桌号</td>
							<td width=10%>总数量</td>
							<td width=10%>已上</td>
							<td width=22%>上一道出菜时间</td>
							<td width=22%>下道出菜时间(预计)</td>
						</tr>

					</table>
				</div>
				<div style="width:100%;height:88%;overflow: auto;">
					<table id="sortname_table">
						<tr  style="height:0px">
							<td width=10%></td>
							<td width=10%></td>
							<td width=10%></td>
							<td width=22%></td>
							<td width=22%></td>
						</tr>
						 <c:forEach items="${total}"var="dishes">
			    		<tr>
			    			<td>${dishes.seatId }</td>
			    			<td>${dishes.countNum }</td>
			    			<td>${dishes.have }</td>
			    			<td>${dishes.lastTime }</td> 
			    			<td>${dishes.waitTime }</td>
			    			
			    		</tr>
    				</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 buttom chao">
			<div class="sortname">炒菜</div>
			<div class="sortname_left">
					<div class="col-lg-8">
						<div id="changeHearth_boss" class="input-group" style="font-size:10px;line-height:25px;">
							<span>共有灶台&nbsp;&nbsp;&nbsp;</span><span style="color:#0000FF;">${hearth }&nbsp;&nbsp;</span>
							<span>当前空闲&nbsp;&nbsp;&nbsp;</span><span style="color:red;">${hearthNum }&nbsp;&nbsp;</span>
							<span><button class="btn btn-default" id="changeHearth">更改灶台数量</button></span>
							<div id="${hearthxiugai }"style="color:red;position:absolute;top:14px;">
								非法数量，修改失败
							</div>
						</div>
						<div class="input-group" id="updatehearth">
						<form action="arr_updateHearth.action" method="post">
							<input type="text" class="form-control" style="width:164px;" name="hearthNum" placeholder="请输入不小于当前占用灶台数量">
							<span class="input-group-btn">
								<input class="btn btn-default" type="submit"value="确认更改"></input></span>
						</form>
						</div>
					</div>
				</div>
			<div>
				<table id="sortname_table">
					<div id="${updateDsihes_error}" style="color:red;position:absolute;top:14px;left:120px;">
						烹饪失败，当前没有空余的灶台</div>
					<tr >
						<td width=10%>菜品名称</td>
						<td width=10%>数量（份）</td>
						<td width=10%>出菜时间（预计）</td>
						<td width=8%>操作</td>
						<td width=10%>所属桌台号</td>
					</tr>
				</table>
			</div>
			<div style="width:100%;height:88%;overflow: auto;">
				<table id="sortname_table">
					<tr style="height:0px">
						<td width=10%></td>
						<td width=10%></td>
						<td width=10%></td>
						<td width=8%></td>
						<td width=10%></td>
					</tr>
					<c:forEach items="${dishesing}" var="dishes">
						<tr>
							<td>${dishes.menuName }</td>
							<td><c:forEach items="${dishes.detailednum }"var="detailednum">
			    				${detailednum}份&nbsp;
			    				</c:forEach>
							</td>
							<td>${dishes.waitTime }</td>
							<td>
								<div class="table_caozuo">
									<button class="table_caozuo_shangcai">
									<a href="arr_updateStatus.action?menuId=${dishes.menuId}<c:forEach items="${dishes.detailednum }"var="detailednum">&detailednum=${detailednum}</c:forEach><c:forEach items="${dishes.detailedId}" var="arr">&detailedId=${arr }</c:forEach>">上菜</a>
									</button>
								</div>
							</td>
							<td><c:forEach items="${dishes.seatId}" var="arr">
								${arr }号&nbsp;
							</c:forEach></td>

						</tr>
					</c:forEach>
					
					<c:forEach items="${dishes}" var="dis">
						<tr>
							<td>${dis.menuName }</td>
							<td>
								 <c:forEach items="${dis.quantity }" var="num">
			    					${num}份&nbsp;
			    				</c:forEach>
							</td>
							<td>${dis.waitTime }</td>
							<td>
								<div class="table_caozuo">
									<button class="table_caozuo_pengren">
									<a href="arr_updateData.action?menuId=${dis.menuId }<c:forEach items="${dis.seatId}" var="arr">&seatId=${arr }</c:forEach><c:forEach items="${dis.detailedId }" var="num">&detailedId=${num}</c:forEach><c:forEach items="${dis.quantity }" var="num">&dishesNum=${num}</c:forEach>">烹饪</a>
									</button>
								</div>
							</td>
							<td><c:forEach items="${dis.seatId}" var="arr"  >
								${arr }号&nbsp;
							</c:forEach></td>

						</tr>
					</c:forEach>

				</table>
			</div>

		</div>
		<div class="col-xs-12 col-sm-3 buttom you2">
			<div class="sortname">凉菜</div>
			<div>
				<table id="sortname_table">
					<tr>
						<td  width=10%>桌号</td>
						<td  width=10%>菜品名</td>
						<td width=10%>数量</td>
						<td width=8%>操作</td>
					</tr>
				</table>
			</div>
			<div style="width:100%;height:88%;overflow: auto;">
				<table id="sortname_table">
					<tr  style="height:0px">
						<td width=10%></td>
						<td width=10%></td>
						<td width=10%></td>
						<td width=8%></td>
					</tr>
					 <c:forEach items="${cool}"var="cl">
						<tr>
							<td>${cl.seatId }</td>
							<td>${cl.menuName }</td>
							<td>${cl.quantity }</td>
							<td><button  class="othes_cool">
								<a href="arr_setOthes.action?menuId=${cl.menuId}<c:forEach items="${cl.quantity }"var="detailednum">&detailednum=${detailednum}</c:forEach><c:forEach items="${cl.detailedId}" var="arr">&detailedId=${arr }</c:forEach>">
								出菜</a>
							</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="col-xs-12 col-sm-3 buttom you2">
			<div class="sortname">其他</div>
			<div>
				<table id="sortname_table">
					<tr>
						<td width=10%>桌号</td>
						<td width=10%>菜品名</td>
						<td width=10%>数量</td>
						<td width=8%>操作</td>
					</tr>
				</table>
			</div>
			<div style="width:100%;height:88%;overflow: auto;">
				<table id="sortname_table">
					<tr  style="height:0px">
						<td width=10%></td>
						<td width=10%></td>
						<td width=10%></td>
						<td width=8%></td>
					</tr>
					<c:forEach items="${othes}"var="cl">
						<tr>
							<td>${cl.seatId }</td>
							<td>${cl.menuName }</td>
							<td>${cl.quantity }</td>
							<td><button  class="othes_cool">
								<a href="arr_setOthes.action?menuId=${cl.menuId}<c:forEach items="${cl.quantity }"var="detailednum">&detailednum=${detailednum}</c:forEach><c:forEach items="${cl.detailedId}" var="arr">&detailedId=${arr }</c:forEach>">
								出菜</a>
							</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
