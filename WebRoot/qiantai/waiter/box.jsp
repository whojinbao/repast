<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/box.js"></script>
<link rel="stylesheet" type="text/css" href="../css/box.css">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="../css/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../css/bootstrap.min.js"></script>
<style type="text/css">
	body{
		background:url(../image/10.jpg.jpg) no-repeat;
		background-size:100% 100%;
	}
</style>
</head>
<body>
	<c:forEach items="${ld}" var="d">
		<div class="a2">
			<img src="${d.src}" height="110" width="141"/>${d.seatid}号桌<br/>
			<button type="button" class="btn btn-primary">${d.staticName}</button>
		</div>
		</c:forEach>
</body>
</html>
