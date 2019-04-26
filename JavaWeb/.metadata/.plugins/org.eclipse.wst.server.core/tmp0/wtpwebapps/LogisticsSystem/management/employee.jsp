<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职员管理</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>

<style type="text/css">
	table{
		text-align: left;
		width:90%;
		border-right:2px solid #666;
		border-bottom:2px solid #666;
		table-layout:fixed;
		margin:20px;
    	font-size: 20px;
    	cellspacing:0;
	}
	table td,table th{
		border-left:2px solid #666;
		border-top:2px solid #666;
		padding:8px;
	}
</style>
</head>
<body>
	<div class="main">
		<table cellspacing="0">
			<tr>
				<th >编号</th>
				<th>姓名</th>
				<th >电话</th>
				<th>职务</th>
				<th width="100px">操作</th>
			</tr>
			<c:forEach var="employee" items="${list}"  >
				<tr>
					<td><c:out value="${employee.id}"/></td>
					<td><c:out value="${employee.name}"/></td>
					<td><c:out value="${employee.phone}"/></td>
					<td><c:out value="${employee.jobTitle}"/></td>
					<td>
						<button id='<c:out value="${employee.id}"/>' onClick="Edit(this.id)">编辑</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
<script type="text/javascript" >
	function Edit(id){
		var url = "employee-info.jsp?id="+id;
		window.open(url);
	}
</script>
</html>


<!-- page errorPage="/error.jsp  -->