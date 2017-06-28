
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"><nk>
  <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  <style type="text/css"> 
.diamond{   
	width: 120px;   
	height: 120px;  
	border:none;
	transform:rotate(45deg);   
	-ms-transform:rotate(45deg); /* Internet Explorer */  
	-moz-transform:rotate(45deg); /* Firefox */   
	-webkit-transform:rotate(45deg); /* Safari 和 Chrome */  
	-o-transform:rotate(45deg); /* Opera */  
}
#top{
	position:absolute;
	
	background-color: red;  
	top:500px;left:500px;
}
#bottom{
	position:absolute;
	background-color: red;  
	top:400px;left:400px;
}
#left{
	position:absolute;
	background-color: red;  
	top:300px;left:500px;
}
#right{
	position:absolute;
	background-color: red;  
	top:400px;left:600px;
}
#dianmond_boss{
	height:500px;
	width:500px;
	position:absolute;
	left:-180px;
	top:-30px;
}
#hgh{
	width:400px;
	height:150px;
	margin-left:100px;
	display:none;
}


#tab_c{
		width:500px;		
		position:absolute;
		left:60%;
		top:50%;
	
	}
	.reg{
		margin-left:19px;
	}
	.paly{
		margin-left:170px;
		color:#0033CC;
	}
	#begin{
		position:absolute;
		top:55%;
		left:35%;
		width:200px;
		height:50px;
		font-size:20px;
	}
	#begin input{
		width:200px;
		height:50px;
		opacity:0.7;
		filter:alpha(opacity=70); /* 针对 IE8 以及更早的版本 */
	}
	.selectnum{
		position:absolute;
		top:20px;
		left:20px;
	}.selectnum input{
		width:90px;
	}
	.shownum{
		position:absolute;
		top:20px;
		left:20px;
		display:none;
	}
	.shownum span{
		color:red;
		font-size:20px;
	}
	#master_memu_tel{
			position:absolute;
			top:300px;right:10px;
			width:30px;
			POSITION: fixed; 
			z-index:200;
	}
</style>
 <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
 </HEAD>
 <BODY>
 <div id=tab_c>
		<div id="hgh">
			<form action="QT_select.action" method="post">
			<div class="col-xs-8">
			
				 <div class="input-group">
				  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
				  <input type="text" class="form-control" nameplaceholder="请设置用户名" aria-describedby="basic-addon1">
				</div>
				 <div class="input-group">
				  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
				  <input type="text" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
				</div>
				<div class="reg">
					<div class="btn-group" role="group" aria-label="...">
					  <button class="logIn" type="button" class="btn btn-default">登录</button>
					</div>
				</div>
 			</div>
 			</form>
 			</div>
 			</div>
 			
 
 <div id="dianmond_boss">
 
  <button  class="diamond" id="top" onclick="shoe()">按钮<tton></span>
  
  <button class="diamond" id="bottom" onclick="shoe1()"><tton>
  <button class="diamond" id="left"><tton>
  <button class="diamond" id="right"><tton>
  <div>
  <script type="text/javascript">
  	var hah=document.getElementById("hgh");
  	function shoe(){
  	hah.style.display="block";
  	
  	}
  /* 注册  */
  	
  	var hah1=document.getElementById("hgh1");
  	function shoe1(){
  	hah1.style.display="block";
 
  	
  	}
  </script>
 </BODY>
</HTML>
