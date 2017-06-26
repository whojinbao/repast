<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title></title>
<style type="text/css" >
body{
	background: #f7f7f7;
}
.content{
	margin-top:50px;
	margin-left:250px;
	width: 1000px;
	height: 100%;
	background: #fff;
	box-shadow: 1px 1px 15px #ddd
}
.header{
	position: relative;
	height: 60px;
	line-height: 60px;
	border-bottom: 1px solid #f7f7f7;
}
.header h2{
	
	display: inline-block;
	padding-left: 50px;
	font-size: 22px;
}
.mt-20{
   margin-top:20px;
}
.mall-content{
	width: 100%;
	line-height: 45px;
}
.mall-content thead{
	text-align: center;
}
td{
text-align:center;
}
</style>
  </head>
  
  <body>
     <div class="content">
          <div class="header">
              <h2>订单详情</h2>
          </div>
          <div class="mt-20">
		    <table class="class="mall-content"">
			   <thead>
				<tr >
					
					<th width="200">下单时间</th>
					<th width="200">菜品</th>
					<th width="200">数量</th>
					<th width="200">价格</th>

				
				</tr>
			</thead>
			<tbody>
		      <c:forEach items="${detailedListppp }" var="detailed">
				 <tr >

					<td>${detailed.datetime }</td>
					<td>${detailed.menuName }</td>
					<td>${detailed.num }</td>
					<td>${detailed.menuPrice }</td>

				
				</tr>
				</c:forEach>
			</tbody>
		</table>
     
     </div>
  </body>
</html>
