<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
     <a href="menuType_sel.action">查询</a><br/>
     ${menu.menuId }<br>
     ${menu.menuName }
    <c:forEach items="${menuTypeList }" var="menuType">
					    <option value="${menuType.typeId }">${menuType.typeName }</option>					
	</c:forEach>
  </body>
</html>
