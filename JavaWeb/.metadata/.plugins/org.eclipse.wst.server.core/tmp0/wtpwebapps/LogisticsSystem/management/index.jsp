<!DOCTYPE html>
<html>
	<% 	if (null == request.getSession().getAttribute("name")){
			response.sendRedirect("login.html");
		}
	%>
	<head>
		<meta charset="utf-8" />
		<title>首页</title>
		<link rel="stylesheet" href="css/page.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/index.js" ></script>
	</head>

	<body>
		<div class="left">
			<div class="bigTitle">职员管理后台</div>
			<div class="lines">
				<div id="employee" onclick="pageClick(this)" class="active"><img src="img/icon-1.png" />职员管理</div>
				<div id="permission" onclick="pageClick(this)"><img src="img/icon-2.png" />权限配置</div>
				<div id="logout" onclick="pageClick(this)"><img src="img/icon-3.png" />注销</div>
			</div>
		</div>
		<div class="top">
			<div class="leftTiyle" id="flTitle">职员管理</div>
			<div class="thisUser">当前用户：<%=request.getSession().getAttribute("name") %></div>
		</div>
		<div class="content"><img src='../img/loading.gif'/></div>
		
		<div style="text-align:center;">
</div>
		
	</body>

</html>