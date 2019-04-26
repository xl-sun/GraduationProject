<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物流追踪</title>
<style type="text/css">
	body>div{
		width:800px;
		margin: 0 auto;
	}
	.main{
		min-height:200px;
		background: #efe;
		border-radius: 5px;
		box-sizing: border-box;
		padding:10px;
		margin-top:5px;
	}
	.time{
		width:100px;
	}
	.content{
		
	}
	li span{
		height:30px;
		font-size:14px;
		margin:10px;
	}
</style>
</head>
<body>
	<jsp:include page="header.html" />
	
	<div class="main">
		<div class="content">
			<h3>物流追踪：<%=request.getAttribute("id") %></h3>
			<ul>
				<c:forEach var="log" items="${logs}"  >
					<li>
						<span class="time"><c:out value="${log.time}"/></span>
						<span class="info"><c:out value="${log.info}"/></span>
					</li>
				</c:forEach>
			</ul>	
		</div>
	</div>
	
	<jsp:include page="footer.html" />
</body>
</html>