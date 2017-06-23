<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>购物车</title>

  </head>
  
  <body>
   
          <table>
              <tr><td>桌号:${seatId }</td><td>员工id:${staffId }</td><td>顾客id</td></tr>
              <tr> <td></td><td></td><td></td></tr>
              <tr> <td>购物车</td><td></td><td><a href="diancan.jsp">继续点餐</a></td><td><a href="shopCart_del.action?ip=clear">清空购物车</a></td></tr>
                <tr> <td>菜品id</td><td>菜名</td><td>价格</td><td>数量</td><td></td><td></td></tr>
              <c:forEach items="${shopCartList }" var="shopCart">
              <tr><td>${shopCart.menuId}</td> <td>${shopCart.menuName}</td><td>${shopCart.menuPrice }</td><td>${shopCart.num }</td><td></td><td> <a style="text-decoration:none" href="shopCart_del.action?menuId=${shopCart.menuId }" >删除</a> </td></tr>
              </c:forEach>
              <tr> <td></td><td></td><td></td><td>共计 ${totalPrice } 元</td><td></td><td><a href="shopCart_getOrder.action"><button>下单</button></a></td></tr>        
          </table>
    
     
  <script type="text/javascript">
   
  </script>
  </body>
</html>
