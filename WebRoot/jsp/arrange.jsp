<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="../css_who/arrange.css" type="text/css"></link>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
</head>

<body>
	<div id="top">
		<div id="top_login">
			<span>欢迎</span>&nbsp;
			<span id="top_login_show">郑飞</span>&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">注销</a>
		</div>
		<div id="top_sort">
			<span>排餐方式</span>&nbsp;
			<button class="btn btn-default">全单</button>
			<button class="btn btn-default">依次</button>
			<button class="btn btn-default">智能</button>
		</div>
		<div id="top_name">黄鹤楼派菜系统</div>
		
	</div>
	<div id="bottom">
		<div id="left">
			<div id="main_font_show">餐桌总计</div>
			<table id="table">
				<tr  id="table_zhuo">
					<td>&nbsp;桌号&nbsp;&nbsp;</td>
					<td>总数&nbsp;&nbsp;</td>
					<td>已上&nbsp;&nbsp;</td>
					<td>上次上菜时间&nbsp;&nbsp;</td>
					<td>等待时间（热菜）</td>
				</tr>
				<tr>
					<td>1</td>
					<td>8</td>
					<td>3</td>
					<td>19:40</td>
					<td>19:50</td>
				</tr>
				<tr>
					<td>2</td>
					<td>9</td>
					<td>2</td>
					<td>19:45</td>
					<td>19:54</td>
				</tr>
				<tr>
					<td>3</td>
					<td>15</td>
					<td>7</td>
					<td>19:55</td>
					<td>19:59</td>
				</tr>
			</table>
		</div>
		<div id="center">
			<div id="main_font_show">热菜</div>
			<div id="center_top">
				<div>已上桌</div>
				<div>未上桌</div>
			</div>
			
			<div id="center_left">
				<ul  id="center_left_ul">
					<li>菜品名</li>
					<li>份</li>
					<li>所需时间</li>
					<li>操作</li>
				</ul>
				<table width=100% border=1>
					<tr>
						<td>红烧茄子</td>
						<td width=40px>2</td>
						<td width=40px>7</td>
						<td>
							<input type="button" value="开炒"/>
							<input type="button" value="出菜"/>
							<input type="button" value="置顶"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="center_right">
				<ul  id="center_right_ul">
					<li>所属桌台号</li>
				</ul>
			</div>
		</div>
		<div id="right_left">
			<div id="main_font_show">凉菜</div>
			<div id="center_top">
				<div>已上桌</div>
				<div>未上桌</div>
			</div>
			<div id="right_left_bottom">
				<ul id="center_left_ul">
						<li>菜品名</li>
						<li>操作</li>
				</ul>
			</div>
		</div>
		<div id="right_right">
			<div id="main_font_show">汤类</div>
			<div id="center_top">
				<div>已上桌</div>
				<div>未上桌</div>
			</div>
			<div id="right_left_bottom">
				<ul id="center_left_ul">
						<li>菜品名</li>
						<li>操作</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
