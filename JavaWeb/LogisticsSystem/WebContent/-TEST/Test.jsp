<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>

<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="./js/jquery.slides.js"></script>

<Style>
.index_banner{
	float:left;
	position:relative;
	margin-left:7px;
	width:689px;
	height:250px;
	box-shadow:3px 3px 5px #bbb;
	overflow:hidden;
}

.search_no{
	width:205px;
	height:125px;
	line-height:25px;
	font-size:14px;
	overflow-y: auto;
	border:1px #dddddd solid;
	border-top:2px #ffce00 solid;
	background:url(img/bg_text.png);
	resize: none;
}


</Style>












</head>
<body>
<div class="index_banner">
	<img src="5c8f60214ca3f.jpg" width="689" height="225" alt="">
	<img src="5c8f6008cf147.jpg" width="689" height="225" alt="">
	<img src="/153110011/the_end/yanzhenma_0418/code.php" width="689" height="225" alt="">
</div>
<div id="qrcodediv" class="login-button">div内容

<canvas id="qrcode" width="256" height="256"></canvas>



</div>
<%
String qr = request.getAttribute("qrcode").toString();
System.out.println(qr);
%>




test







打印二维码:<input name="b_print" type="button" class="ipt" onClick="printdiv('qrcode');" value=" Print ">
<script>
$(document).ready(function() { 
	$('.index_banner').slidesjs({
        width: 680,
        height: 225,
        generateNextPrev: true,
        navigation: true,
        play: {
          active: true,
          auto: true,
          interval: 6000,
          swap: true
        }
	});
});


function printdiv(printpage)
{
var headstr = "<html><head><title></title></head><body>";
var footstr = "</body>";
var newstr = document.all.item(printpage).innerHTML;
var oldstr = document.body.innerHTML;
document.body.innerHTML = headstr+newstr+footstr;
window.print(); 
document.body.innerHTML = oldstr;
return false;
}

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


	$('.login-button').click(function(){
		alert("Hello");
	});

jQuery(function(){

	jQuery('#qrcode').qrcode(utf16to8(<c:out value="\"&lt要显示的数据对象&gt\"" escapeXml="false" ></c:out>));
	var str = '<%=qr%>';
	jQuery('#qrcodediv').qrcode(utf16to8(str));
})



	//printdiv("qrcode");

</script>



</body>
</html>