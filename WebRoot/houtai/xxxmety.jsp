<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
</head>

<body>
	<form>

		<input type="text" placeholder="分类名称" value="" id="menuTypeName"
			class="input-text" style="width:120px" name="menuType.typeName">

		<input type="submit" class="btn btn-success" id="" name="submit"
			value="添加">

	</form>
	<script type="text/javascript">
	   $("#menuTypeName").blur( 
      function(){
           alert("hello");
       /*  String menuTypeName = $("#menuTypeName").val();  
         alert(menuTypeName);   
         $.ajax({  
			type: 'POST',
			url: 'menuType_add.action',
			data:{typeName:menuTypeName},
			dataType: 'json',
			success: function(data){
		          if(data == 0){
		              $(this).append("<span>菜类名已有！</span>");
		              return false;
		          }
		          if(data == 1){
		              $(this).append("<span>菜类名可用！</span>");
		              return true;
		          }
			},
			error:function(data) {
			
			},
      });  */
   
      });
	
	</script>
</body>
</html>
