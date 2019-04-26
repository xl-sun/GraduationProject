<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>隐私安全快递 - 基于Java的隐私安全物流分拣、派送系统设计与实现</title>
	<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/jquery.slides.js"></script>
	<script type="text/javascript" src="./js/index.js"></script>
	<link href="./css/index.css" rel="stylesheet" type="text/css">
</head>
<body>

	<jsp:include page="header.html" />
	
	<div class="main">
		<div class="div_banner">
			<img src="img/banner01.jpg" width="600" height="225" alt="">
			<img src="img/banner02.jpg" width="600" height="225" alt="">
			<img src="img/banner03.jpg" width="600" height="225" alt="">
			<img src="img/banner04.jpg" width="600" height="225" alt="">
		</div>
		<div class="index_box" style="float:right">
	        <ul Style="margin:0px">
				<h3 Style="margin:5px">快件查询</h3>
				
	            <form id="form" name="form" enctype="application/x-www-form-urlencoded" action="./Tracking" method="get" target="_blank">
	            	<textarea name="id" id="waybill_text" class="search_no"></textarea>
		            <div>
		                <input type="submit" value="查 询" class="index_botton_sumbit" id="waybill_search"">
		                <input type="button" value="清 除" class="index_botton_sumbit" id="waybill_clear" onclick="clear_waybill()">
		            </div>
	            </form>
	        </ul>
	    </div>
	</div>

	<jsp:include page="footer.html" />

</body>
</html>