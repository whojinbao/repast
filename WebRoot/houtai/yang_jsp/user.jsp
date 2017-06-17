<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    	<form action="auth_save.action" method="post">
    		账号:<input type="text" name="aut.authId"/><br>
    		密码:<input type="text" name="aut.authName"/><br>
    		姓名:<input type="text" name="aut.authPath"/><br>
    		性别:<input type="text" name="aut.parentId"/><br>
    		年龄:<input type="text" name="aut.authDescription"/><br>
    		<!-- 手机:<input type="text" name="pp.phone"/><br>
    		地址:<input type="text" name="pp.addr"/><br>
    		邮编:<input type="text" name="pp.postcode"/><br>
    		权限:<input type="text" name="pp.power"/><br> -->
    		<input type="submit" value="submit"/>
    	</form>
  </body>
</html>
