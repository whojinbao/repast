<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"charset="UTF-8"></script>
<link href="../css/topanv.v1.0.css" rel="stylesheet" type="text/css" />
<script src="../js/topanv.js"></script>
<script type="text/javascript" src="../bootstrap/css/jquery-3.1.1.min.js"></script>
<style type="text/css">
.s1 {
	height: 100%;
	margin-left: 70px;
	margin-top: 40px;	
}
ul {
	list-style: none;
}

li {
	margin-left: 70px;
	float: left;
}

a {
	text-decoration: none;
}

#A1{
	background: white;
}

button {
	height: 30px;
}

.lq1:hover {
	background: black;
}

#button1 {
	position: absolute;
	left: 800px;
	top: 8px;
}

#button2 {
	position: absolute;
	left: 850px;
	top: 8px;
}

#button3 {
	position: absolute;
	left: 750px;
	top: 8px;
}
#b1{
	position: absolute;
	left: 900px;
	top: 8px;
	width:100px;
	margin:-5px;
}
#button5{
	position: absolute;
	left: 700px;
	top: 8px;
}
span{
	background:yellow;
}
</style>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link></head>
<body>

	<div id="topnavbar" style="display: block;">
	<input style="position:absolute;top:500px;left:400px;display:none;z-index:99999999;" type="text" id="myinput">
	<input style="position:absolute;top:500px;left:400px;display:none;z-index:99999999;" type="text" id="ppinput">
		<div id="topnanv" style="width: 980px;">
			<div id="anvlfteb">
				<div selec="store" class="posbox">
					<a href="#" class="lq1">餐桌<i><i>
					</a>
				</div>
				<div class="posbox">
					<a href="i_select.action" class="lq1">刷新</a>
				</div>
				<div id="seledbox" class="posiabox" style="display: none; left:1px;">
					<div></div>
				</div>
			</div>
			<!-- 查询座的人数和桌子状态的桌子 -->
			<form action="i_select1.action" method="post">
				<input type="submit" value="查询" id="A1">: 
				<span>可坐人数:</span>
				<select
					name="pp.maxPerson">
					<option>2</option>
					<option>6</option>
				</select> 
				<span>桌子状态:</span>
				<select name="pp.statusName">
					<option>可用</option>
					<option>占用</option>
					<option>待扫</option>
					<option>损坏</option>
				</select>
			</form>
			<!-- 查看订单 -->
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="b1">
			  	查看订单
			</button>	
			<div class="modal fade" tabindex="-1" role="dialog"id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        		  
      </div>
      	<div class="modal-body">
     	 <a href="order.jsp" target="a1">查看</a>
      	<iframe width="80%" height="50%" src="order.jsp" name="a1" id="wer" >
      	</iframe>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
	
	<!-- 显示的桌子 -->
		</div>
		<!-- 开台，清扫，结账 -->
		<form action="" method="post">
			<div class="s1">
				<ul>
					<c:forEach items="${pl}" var="pe">
						<li><label><input type="radio" style="display:none"
								value="${pe.seatid}" name="pp.seatid">
								<div>
									<img src="${pe.imgSrc}" width="100" height="100" />
								</div>
								<div>
									<div>
										<input type="text" class="pl" value="${pe.seatid}"style="display:none">${pe.seatid} 
										<input type="text" class="cckk" value="${pe.statusName}"
										style="display:none">${pe.statusName}
									</div>
								</div></label></li>
					</c:forEach>
				</ul>
				
			</div>
			<input type="submit"onclick="alert3()"id="button1" value="清扫">
			<input type="submit"onclick="alert2()"id="button2" value="结账">
			<input type="submit"onclick="alert1()"id="button3" value="开台">	
			<input type="submit"onclick="#"id="button5" value="催菜">
		</form>
		
	</div>
	<script>
		$("li").click(function() {
			$("li").css('background','none');
			$(this).click(function() {
				$(this).css('background', '#996666')
				$("#myinput").val($(this).find(".cckk").val());
				/* 开台*/
				if($("#myinput").val()=="可用"){
					$("#button3").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=1';");
					$("#button2").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=3';");
					$("#button1").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=3';");
				}
				/*结账 */
				else if($("#myinput").val()=="占用"){
					$("#button2").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=2&pp.orderStatus=1';");
					$("#button3").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=1';");
					$("#button1").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=1';");		
				}
				/* 清扫 */
				else if($("#myinput").val()=="待扫"){
					$("#button1").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=3';");
					$("#button2").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=2';");
					$("#button3").attr("onclick","javascript:this.form.action='i_updateStatus.action?pp.seatStatusId=2';");
				}
			})
		})
		function alert1(){
			alert("当前桌子非可用状态，请选择其他可用桌台进行操作");
		}
		function alert2(){
			alert("当前桌子不需要结账");
		}
		
		function alert3(){
			alert("当前桌子不需要打扫");
		}	
		
		$("#b1").click(
		function(){
		
			var a=$("#ppinput").val();
		
		 $.ajax({
				type: "post",
				url: "ko_selectOrder.action",		
				data:{name:a},
				dataType: "json",
				success: function(data){
						
				}
				});
						
			});
		$("li").click(function() {
			$("li").css('background','none');
			$(this).click(function() {
				$(this).css('background', '#996666')
				$("#ppinput").val($(this).find(".pl").val());
					
			})
		})
	</script>
<script type="text/javascript"src="../bootstrap/css/bootstrap.min.js"></script>
</body>
</html>
