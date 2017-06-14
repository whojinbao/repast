<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<script type="text/javascript" src="../js_who/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../js_who/jquery.treemenu.js"></script>
<link rel="stylesheet" href="../css_who/background.css" type="text/css"></link></head>

<body>
	<div id="left-navigation">
		<ul class="tree">
			<li><a href="" >权限管理</a>
				<ul>
					<li><a href="#" target="">权限管理</a>
					</li>
					
				</ul>
			</li>
			<li><a>Category</a>
				<ul>
					<li><a href="#" target="">jQuery</a>
					</li>
					<li><a href="#" target="">JavaScript</a>
					</li>
					<li><a href="#suits" target="">Golang</a>
					</li>
				</ul>
			</li>
			<li><a href="#about" target="">About</a>
				<ul>
					<li><a href="#" target="">Contact</a>
					</li>
					<li><a href="#" target="">Blog</a>
					</li>
					<li><a href="#" target="myiframe">Jobs</a></li>
				</ul></li>
		</ul>
	</div>
	<div id="top"></div>
	<div id="main_div">
		<iframe name="myiframe"width="100%" height="100%" src="arrange.jsp"></iframe>
	</div>
</body>
</html>