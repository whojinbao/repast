<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <a href="shopCart_del.action">xx</a>
     <c:forEach items="${MenuTypeList }" var="menuType">
       ${menuType.typeName}
    </c:forEach>
  </body>
</html>
