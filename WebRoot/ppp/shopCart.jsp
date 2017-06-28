<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
   <style type="text/css">
body{
	background: #f7f7f7;
}
.content{
	margin-top:50px;
	margin-left:400px;
	width: 600px;
	height: auto;
	min-height:700px;
	background: #fff;
	position:relative;
}
.header{
	position: relative;
	height: 60px;
	line-height: 60px;
	border-bottom: 2px solid #f7f7f7;
}
.header h2{
	
	display: inline-block;
	padding-left: 20px;
	font-size: 22px;
}
#t1 span{
    display: inline-block;
	padding-left: 20px;
	font-size: 18px;  
}
.mall-content{
	width: 100%;
	line-height: 45px;
}
.mall-content thead{
	text-align: center;
}
tr th:first-child{
	text-align: left;
	padding-left: 20px;
	/*padding-left: 20px;*/
}
tbody{
	background: #fcfbf9;
}
tbody tr{
	height: 55px;
}
tr td{
	text-align: center;
	border-bottom: 1px solid #f7f7f7
}
tr td:first-child{
	text-align: left;
	padding-left: 20px;
}
.gw_num{border: 1px solid #dbdbdb;width: 110px;    margin: auto;line-height: 26px;overflow: hidden;}
.gw_num em{display: block;height: 26px;width: 26px;float: left;color: #7A7979;border-right: 1px solid #dbdbdb;text-align: center;cursor: pointer;}
.gw_num .num{display: block;float: left;text-align: center;width: 52px;font-style: normal;font-size: 14px;line-height: 24px;border: 0;}
.gw_num em.add{float: right;border-right: 0;border-left: 1px solid #dbdbdb;}
.foot-content{
	position: relative;
	width: 100%;
	height: 120px;
	border-bottom: 5px dashed #efefef;
}
.foot-content .sum{
	position: absolute;
	bottom: 45px;
	right: 45px;

}
.foot-content .sum h1{
	font-size: 30px;
	color: red
}
.foot-content .sum span{
	font-size: 22px;
}
.del{
    width: 80px;
    height: 35px;
    display:inline-block;
    line-height: 35px;
    background: #fb3b3b;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    cursor: pointer;
}
.ent-btn{
	position:absolute;
	bottom:10px;
	right:50px;
}
.btn{
	width: 120px;
    height: 35px;
    line-height: 35px;
    background: #fb3b3b;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    cursor: pointer;
}
	  </style>
  <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
  </head>
  
  <body>
   <div class="content">
            <div id="t1"><span >桌号:</span><span id="zhuoId">${zhuo}</span><span>员工id:</span><span id="staffid">${staffid }</span><span>顾客id:</span><span></span></div>		
			<div class="header">
				<h2>购物车</h2>		
				
			</div>
			<table class="mall-content">
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>菜名</th>
			      <th>数量</th>
			      <th>单价(元)</th>
			    </tr>
			  </thead>
			  <tbody>
			   <c:forEach items="${shopCartList }" var="shopCart">
			    <tr>
			      <td class="munuid">${shopCart.menuId}</td>
			      <td class="menuname">${shopCart.menuName}</td>
			      <td>
			      	<div class="gw_num">
						<em class="jian">-</em>
						<input type="text" value="${shopCart.num }" class="num"/>
						<em class="add">+</em>
					</div>
			      </td>
			      <td> <span>¥</span><span class="danjia"> ${shopCart.menuPrice }</span></td>
			      <td> <a style="text-decoration:none" href="shopCart_del.action?menuId=${shopCart.menuId }" class="del">删除</a> </td>
			    </tr>
			    </c:forEach>			   
			  </tbody>			
			</table>
			<div class="foot-content">
				<div class="sum">
					<h1><span>¥</span><span id="summoney"></span>  </h1>
				</div>
			</div>
			<div class="ent-btn">
			   
				<div class="btn" style="float:left;margin-left:20" >				   
					<a href="menu_selTyMenu.action" style="text-decoration:none;color: #fff"><span>继续点餐</span></a>
				</div>
				<div class="btn" style="float:left;margin-left:20">				   
					<a href="shopCart_clear.action" style="text-decoration:none;color: #fff"><span>清空购物车</span></a>
				</div>
				<div class="btn" style="float:left;margin-left:120">				   
					<a href="#"style="text-decoration:none;color: #fff" id="getOrder"><span>确认下单</span></a>
				</div>
			    </div>
		</div> 
		
</div>		
  <script type="text/javascript">

 

  $("#getOrder").click(function(){  
	
	  if($("#zhuoId").html() == "" || $("#summoney").html() <=0){		
		 
		  if(confirm("请选择桌号，并点餐！")) {
			  return false;
			}else{
				 return false;
			}
	  }else{
		  window.location.href="shopCart_getOrder.action";
	  }
	 
  })
  
      $(document).ready(function(){
    	  
    	  function Total(){
  	        var money=0;
  	        var txt = $(".num"); 
  	        for (var i = 0; i < txt.length; i++) {
  	            money += (txt.eq(i).val()*1) * (txt.eq(i).parent().parent().parent().find(".danjia").html()*1);
  	        }
  	        
  	      $("#summoney").html(money);
  	    };
    	  Total();
    	  
			//加的效果
			$(".add").click(function(){
				var n=$(this).prev().val();
				var num=parseInt(n)+1;
				$(this).prev().val(num);
				Total();
				var id=$(this).parent().parent().parent().find(".munuid").html();
				getNum(num,id);
				
			});
			//减的效果
			$(".jian").click(function(){
				var n=$(this).next().val();
				var num=parseInt(n)-1;
				if(num<1){num=1;}
				$(this).next().val(num);
				Total();
				var id=$(this).parent().parent().parent().find(".munuid").html();
				getNum(num,id);
				});
		
			
			$(".num").blur(function (){
				var num=$(this).val()*1;
				if(num<1){
					num=1;
				}
				$(this).val(num);
				Total();
				var id=$(this).parent().parent().parent().find(".munuid").html();
				alert(num+";"+id)
				getNum(num,id);
			});
			
			
			 function getNum(num,id){
				    $.ajax({
						type: 'POST',
						url: 'shopOk_setParams.action',		
						data:{num:num,id:id},
						dataType: 'json',
						success: function(data){
						   
						}
					});	
					
			}
			
			
		})
</script>
  </body>
</html>
