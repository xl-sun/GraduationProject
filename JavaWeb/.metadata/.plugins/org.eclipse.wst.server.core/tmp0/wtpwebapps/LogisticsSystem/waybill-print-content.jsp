<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印面单</title>
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.qrcode.min.js"></script>
<style>
	.content>div{
		margin:10px;
	}

	.content{
		margin:10px;
		width:400px;
		margin: 0 auto;
	}
	.main{
	}
</style>
<style  media="print" type="text/css">
	.noprint{
		visibility:hidden
	}
</style>

</head>
<body>
<div class="main">

	<div class = "content">
		<div class = "region">
			<% /* = new String(request.getParameter("desmergername").getBytes("ISO-8859-1"),"UTF-8") */%>
			<%= request.getAttribute("desmergername") %>
		</div>
		<div class = "code">
			<div class = "qrcode">
				
			</div>
		</div>
		<div class = "id">
			<%= request.getAttribute("waybillid") %>
		</div>
		<div>
			<button class="noprint" onclick="print()">打印</button>
		</div>

	</div>
</div>

</body>
<script>
function utf16to8(str) {  
    var out, i, len, c;  
    out = "";  
    len = str.length;  
    for (i = 0; i < len; i++) {  
        c = str.charCodeAt(i);  
        if ((c >= 0x0001) && (c <= 0x007F)) {  
            out += str.charAt(i);  
        } else if (c > 0x07FF) {  
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));  
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));  
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));  
        } else {  
            out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));  
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));  
        }  
    }  
    return out;  
}

$(function(){
	var str = '<%=request.getAttribute("qrcode")%>';
	$('.qrcode').qrcode(utf16to8(str));
});

</script>
</html>