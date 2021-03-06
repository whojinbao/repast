<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>

<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />

<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="page-container">
		<form action="menu_addMenu.action" method="post"
			class="form form-horizontal" id="form-article-add"
			enctype="multipart/form-data">


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>菜品Id：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="menuId" name="menu.menuId">
				</div>
				<div class="span" id="spanId"></div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">图片：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="uploader-thum-container">
						选中图片：<input type="file" name="menuFile"><br />
					</div>

				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>菜品名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="menuName" name="menu.menuName">
				</div>
				<div class="span" id="spanName"></div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>菜品分类：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"> <select name="menu.menuTypeId"
						class="select">
							<c:forEach items="${MenuTypeList }" var="menuType">
								<option value="${menuType.typeId }">${menuType.typeName
									}</option>
							</c:forEach>
					</select> </span>

				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>制作时间：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id=""
						name="menu.doTime">
				</div>
				<div class="span"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>合菜最大数量：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id=""
						name="menu.maxNum">
				</div>
				<div class="span"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>菜品价格：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id=""
						name="menu.menuPrice">
				</div>
				<div class="span"></div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="submit" value="提交" class="btn btn-primary radius">
					<button onClick="layer_close();" class="btn btn-default radius"
						type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</div>
		</form>
	</div>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/ueditor.config.js"></script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">

 
 $("#menuId").blur(
   function(){
	   if( $(this).val()==""){
           $("#spanId").html("内容不能为空");
       }else{
         $("#spanId").html();
          var menuId = $("#menuId").val();
          $.ajax({  
			type: 'POST',
			url: 'menu_verifyId.action',
			data:{menuId:menuId},
			dataType: 'json',
			success: function(data){
		          if(data == false){
		             $("#spanId").html("菜品ID已有");
		              return false;
		          }
		          if(data == true){
		              $("#spanId").html("菜品ID可用");
		              return true;
		          }
			},
			error:function(data) {  
			    
			},
        })
       }
   });
   
 $("#menuName").blur(
   function(){
	   if( $(this).val()==""){
           $("#spanName").html("内容不能为空");
       }else{
         $("#spanName").html();
        var menuName = $("#menuName").val();
        $.ajax({  
			type: 'POST',
			url: 'menu_verifyName.action',
			data:{menuName:menuName},
			dataType: 'json',
			success: function(data){
		          if(data == false){
		             $("#spanName").html("菜品名已有");
		              return false;
		          }
		          if(data == true){
		              $("#spanName").html("菜品名可用");
		              return true;
		          }
			},
			error:function(data) {  
			    
			},
       });
        
     }
	   
 }) 
 

</script>
</body>
</html>
