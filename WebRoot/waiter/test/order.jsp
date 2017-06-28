<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  	<table>	
  				<tr>
  				<td width="200">订单号</td>		
  				<td>该单的价格</td>
  				</tr>
  				<c:forEach items="${mn}" var="pp">
  				<tr>	
        		<td>${pp.id}</td>
        		<td>${pp.totalPrice}</td>	
        		</tr>
        		</c:forEach>
     </table>
     	<c:forEach items="${mm}" var="po">
        		<td>${po.menuName}的价格为${po.caiPrice}元</td><br/>	
        </c:forEach>
      
  
       
        
        
  </body>
</html>
