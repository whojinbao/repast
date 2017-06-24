<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css"></link>
<link rel="stylesheet" href="../css/component.css" type="text/css"></link>
<style type="text/css">
.dsss{
	display: none;
}
.diamond {
	width: 120px;
	height: 120px;
	transform: rotate(45deg);
	-ms-transform: rotate(45deg); /* Internet Explorer */
	-moz-transform: rotate(45deg); /* Firefox */
	-webkit-transform: rotate(45deg); /* Safari 和 Chrome */
	-o-transform: rotate(45deg); /* Opera */
}

.diamond:focus {
	outline: 0;
}

#top {
	position: absolute;
	top: 500px;
	left: 500px;
}

#bottom {
	position: absolute;
	top: 400px;
	left: 400px;
}

#left {
	position: absolute;
	top: 300px;
	left: 500px;
}

#right {
	position: absolute;
	top: 400px;
	left: 600px;
}

#dianmond_boss {
	height: 500px;
	width: 500px;
	position: absolute;
	left: -240px;
	top: 0px;
}

.button {
	line-height: 38px;
	text-align: center;
	font-weight: bold;
	color: #fff;
	text-shadow: 1px 1px 1px #333;
	border-radius: 5px;
	margin: 0 20px 20px 0;
	position: relative;
	overflow: hidden;
}

.button.gray {
	color: #8c96a0;
	text-shadow: 1px 1px 1px #fff;
	border: 1px solid #dce1e6;
	box-shadow: 0 1px 2px #fff inset, 0 -1px 0 #a8abae inset;
	background: -webkit-linear-gradient(top, #fefefe, #ebeced);
	background: -moz-linear-gradient(top, #f2f3f7, #ebeced);
	background: linear-gradient(top, #f2f3f7, #ebeced);
}

.gray:hover {
	background: -webkit-linear-gradient(top, #f2f3f7, #e4e8ec);
	background: -moz-linear-gradient(top, #f2f3f7, #e4e8ec);
	background: linear-gradient(top, #f2f3f7, #e4e8ec);
}

button div {
	transform: rotate(-45deg);
	-ms-transform: rotate(-45deg); /* Internet Explorer */
	-moz-transform: rotate(-45deg); /* Firefox */
	-webkit-transform: rotate(-45deg); /* Safari 和 Chrome */
	-o-transform: rotate(-45deg); /* Opera */
}

button div img {
	margin-left: -20px;
}

body {
	background: url("../image/zhuyebeijing.jpg") no-repeat;
	background-size: 100% 100%;
	overflow: hidden;
}

#gushi {
	width: 120px;
	position: absolute;
	bottom: 40px;
	right: 40px;
}

.table {
	border: 1px solid red;
	position: absolute;
	top: 10px;
	left: 100px;
}



.zhucewidth {
	width: 380px;
	float: right;
}

#shoujihao,#passworddouble,#password,#name {
	margin-top: -20px;
	color: red;
	display: none;
}
.mimacuowu{
	position:absolute;
	top:280px;
	left:580px;
	display:none;
}
#mimacuowu1,#dengluok2,.displayselect1,.displayse2{
	display:none;
}
#mimacuowu2,#dengluok1,.displayselect2,.displayse1{
	display:block;
}
.dengluok{
	color:green;
	position: absolute;
	top:50px;
	left:80px;
	font-size:18px;
	display:none;
}

#selectseat{
	z-index: 9999999999;
	width:200px;
	position: absolute;
	top:10px;
	left:800px;
}

</style>
<link rel="stylesheet" href="../css/zzsc.css" type="text/css"></link>
<script type="text/javascript" src="../../js_who/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
	function aaa(){
		$.ajax({
 	 			type:"post",
 	 			url:"qtlogin_selectzhuozi.action",
 	 			data:{},
 	 			datatype:"json",
 	 			success:function(data){
 	 			data = data.slice(1, data.length);
 	 			data = data.slice(0, data.length-1);
 	 			var strs= data.split(",");
 	 			for(var i=0; i<strs.length;i++){
 	 				$("#selectId").append("<option value='"+strs[i]+"'>"+strs[i]+"</option>");
 	 			}
 	 			}});
 	 }
 	 aaa();
</script>
</head>
<body>
	<script src="/demos/googlegg.js"></script>

	<div Style="margin-left:150px;margin-top:50px;">
		<img src="../image/shouyeguanquelou.png"></img>
	</div>
	<div class="mimacuowu" id="mimacuowu${mimacuowu }"><img src="../image/mimacuowu.png"></img></div>
	<div class="dengluok" id="dengluok${mimacuowu }">欢迎&nbsp;&nbsp;${username }</div>
	<div id="gushi">
	
		<img src="../image/gushi.png"></img>
	</div>
	<div id="selectseat"> 
		<form action="qtlogin_zhuoyixuanze.action" class="displayselect${who_select1 }">
		选择桌号<select id="selectId"  name="sselectseat"> 
			     
 			</select>
 			<input type="submit" value="确认">
		</form>
		<div class="dsss displayse${who_select1 }">已选桌号:${zhuo }</div>
	</div>
	<div id="dianmond_boss">
		<button class="diamond button gray" id="top">
			<div>
				<img src="../image/waimaidiancan.png"></img>
			</div>
		</button>
		<a href="javascript:;" class="md-trigger btn btn-primary btn-sm"
			data-modal="modal-3">
			<button class="diamond button gray" id="bottom">
				<div>
					<img style="margin-left:0px;" src="../image/zhuce.png"></img>
				</div>
			</button> </a>
		<a href="${who_qiantai }"  disabled="disabled">
			<button class="diamond button gray" id="left" >
				<div>
					<img src="../image/kaishidiancan.png"></img>
				</div>
			</button>
		</a> <a href="javascript:;" class="md-trigger btn btn-primary btn-sm"
			data-modal="modal-2">
			<button class="diamond button gray" id="right">
				<div>
					<img style="margin-left:0px;" src="../image/denglu.png"></img>
				</div>
			</button> </a>
	</div>

	<div style="width:1000px; height:500px; padding-left:450px;">
		

		<!-- 登陆 -->

		<div class="demo form-bg md-modal md-effect-13" id="modal-2">
			<div class="container ">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<form class="form-horizontal" action="qtlogin_logindenglu.action" method="post">
							<span class="heading">用户登录</span>
							<div class="form-group">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="请输入手机号码" name="phone"> <i class="fa fa-user"></i>
							</div>
							<div class="form-group help">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="请输入密码"name="password"> <i class="fa fa-lock"></i> <a
									href="#" class="fa fa-question-circle"></a>
							</div>
							<div class="form-group">
								<div class="main-checkbox">
									<input type="checkbox" value="None" id="checkbox1" name="check" />
									<label for="checkbox1"></label>
								</div>
								<span class="text">记住我</span>
								<button type="submit" class="btn btn-default">立刻登录</button>
								<button class=" btn btn-default  md-close  btn-sm btn-primary" style="display: none;">立即注册</button>

							</div>
						</form>
					</div>
				</div>

			</div>
		</div>

		<!-- 注册 -->


		<div class="demo form-bg md-modal md-effect-13" id="modal-3">
			<div class="container ">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<form class="form-horizontal" action="qtlogin_login.action" method="post"  id="form1">
							<span class="heading">用户注册</span>
							<div class="form-group">
								<span>手机号</span><input type="text" name="phone"
									class="form-control zhucewidth" id="inputmobile"
									placeholder="手机号">
							</div>
							<div id="shoujihao">手机号格式不正确</div>
							<div class="form-group help">
								<span>姓名</span><input type="text" name="name"
									class="form-control zhucewidth" id="inputname"
									placeholder="请输入您的姓名">

							</div>
							<div id="name">请输入您的姓名</div>
							<div class="form-group help">
								<span>密&nbsp;&nbsp;码</span><input type="password" name="password"
									class="form-control zhucewidth" id="inputPassword1"
									placeholder="请输入6-16位密码">
							</div>
							<div id="password">密码长度不正确</div>
							
							<div class="form-group help">
								<span>重复密码</span><input type="password"
									class="form-control zhucewidth" id="inputPassword2"
									placeholder="请重复输入密码">

							</div>
							<div id="passworddouble">两次密码不一致</div>
							<div class="form-group">
								<button type="submit" id="zhucesubmit" class="btn btn-default" disabled="value">提交注册</button>
								<button class=" btn btn-default  md-close  btn-sm btn-primary"style="display: none;">返回登陆</button>

							</div>
						</form>
					</div>
				</div>

			</div>
		</div>



		<div class="md-overlay"></div>
		<!-- the overlay element -->
	</div>

	<script type="text/javascript" src="../js/js/classie.js"></script>
	<script type="text/javascript" src="../js/js/modalEffects.js"></script>
	<script type="text/javascript">
	window.onload=function(){
		var mobile=false;
		var psw=false;
		var psw2=false;
		var name=false;
		$("#inputname").blur(function (){
			if($("#inputname").val()!=""){
				 $("#name").css("display","none");
				 name=true;
			}else{
				 $("#name").css("display","block");
				 name=false;
			}
			
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		});
		$("#inputmobile").blur(function(){
		 if ((/^1[34578]\d{9}$/).test($("#inputmobile").val())){
		    $("#shoujihao").css("display","none");
		    mobile=true;
		  }else {
		    $("#shoujihao").css("display","block");
		    mobile=false;
		  }
	        
	        var menuName=$("#inputmobile").val();
 	 		 $.ajax({
 	 			type:"post",
 	 			url:"qtlogin_jiaoyan.action",
 	 			data:{name:menuName},
 	 			datatype:"json",
 	 			success:function(data){
 	 				if(!data){
 	 					$("#shoujihao").html("手机号已存在");
 	 				 	$("#shoujihao").css("display","block");
 	 				 	 mobile=false;
 	 				}else{
 	 					$("#shoujihao").css("display","none");
 	 					mobile=true;
 	 				}
 	 				
 	 			}
 	 		});
 	 		 
		  if(mobile&&psw&&psw2&&name){
	           $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        }; 
	        
		});
		$("#inputPassword1").blur(function(){
		 
		  if ((/^[a-z0-9_-]{6,16}$/).test($("#inputPassword1").val())){
		    $("#password").css("display","none");
		    psw = true;
		  }else {
		   $("#password").css("display","block");
		    psw = false;
		  }
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	        }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		});

		$("#inputPassword2").blur(function(){
		if(!$("#inputPassword2").val()==""){
			 if (($("#inputPassword1").val())==($("#inputPassword2").val())){
		    $("#passworddouble").css("display","none");
		     psw2 = true;
		     
		  }else {
		   $("#passworddouble").css("display","block");
		    psw2 = false;
		  }
		  if(mobile&&psw&&psw2&&name){
	            $("#zhucesubmit").attr("disabled",false);
	       }else{
	        	 $("#zhucesubmit").attr("disabled",true);
	        };
		}
		 
		});	
		
		
		
		
		
		
		
		
		
		
		
	        
	};
		
		
		
		
		
	</script>

</body>
</html>
