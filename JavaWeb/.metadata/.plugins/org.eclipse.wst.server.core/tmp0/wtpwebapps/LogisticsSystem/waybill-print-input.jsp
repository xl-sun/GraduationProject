<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印面单</title>
<style>
	body{
		background:#efefef;
	}

	.main{
		margin: 0 auto;
		width: 200px;
		height:140px;
		position:absolute;
		left:50%;
		top:50%; 
		margin-left:-100px;
		margin-top:-70px;
		border:1px solid #ffF; 
		border-radius: 10px;
		padding:15px;
		background:#FFF;
	}
	.txt{
	    border-radius: 3px;
	    height:30px;
	    border: 1px solid #dcdfe6;
	}
	.submit{    
		width: 80px;
	    height: 30px;
	    float:right;
	}
	form div{
		margin:15px;
	}
</style>
</head>
<body>
	<div class = "main">
		<div class = "input">
			<form action="./WaybillPrint" method="get">
				<div>
					<lable>请输入运单号：</lable>
				</div>
				<div>
					<input type="text" class="txt" name="id"></input>
				</div>
				<div>
					<input type="submit" value="确认" class="submit"></input>
				</div>
			</form>
		</div>
	</div>
</body>
</html>