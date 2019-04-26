
$(function () {
	
	
	//alert("Hello");
	
	$('.login-button').click(function(){
		login();
	});

    //ajax验证登录请求
    function login() 
    {
    	if(formVerify){
	        var username=document.getElementById('username').value;
	        var password=document.getElementById('password').value;
	        var code=document.getElementById('code').value;
	        var param = "username="+username+"&password="+hex_md5(password)+"&code="+code;
	        var xmlHttp = new XMLHttpRequest();
	        xmlHttp.open("POST","AdminLogin");
	        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	        xmlHttp.send(param);      //alert(param);
	        xmlHttp.onreadystatechange=function () { 
	            if(xmlHttp.readyState==4&&xmlHttp.status==200){
	            	var result =xmlHttp.responseText;
	                if ("登录成功!" == result) 
	                {
	                	window.location.href="./";
	                }
	                else
	                {
		            	alert(result);
	                    $("#code").attr("style","border: 2px solid red");
	                    document.getElementById('result').innerHTML=xmlHttp.responseText;
	                    $('#result').attr("style","color: fuchsia;");
	                }
	            }
	        }
    	}
    }
    
    function formVerify()
    {
    	return true;
    }


    $('.yzm-button').click(function(){
		$(this).attr("disabled", true);  
		var httprequst = new XMLHttpRequest();
		var id = document.getElementById('username').value;
		httprequst.open("GET","AdminLogin?id="+id);
		httprequst.send();
		httprequst.onreadystatechange=function () { 
		if(httprequst.readyState==4&&httprequst.status==200){
			var result = httprequst.responseText;
		    if ("success" == result)
		    {
		    	//发送成功，开启倒计时
		    	timeout(30)
		    }
		    else
		    {
		    	yzmbtn.attr("disabled",false); 
		    	alert(result);
		    }
		}
		}
});
	

	var countdown;  
    var yzmbtn = $('.yzm-button');  
    function timeout(s){
    	countdown=s;
  	  	yzmbtn.attr("disabled", true);  
    	setInterval(settime,1000);
    }
    
    function settime() {
      if (countdown == 0) {  
    	  clearInterval(); 
    	  yzmbtn.attr("disabled",false);  
    	  $('.yzm-button span').text("获取验证码"); 
      } else {  
    	  $('.yzm-button span').text("已发送(" + countdown + ")");  
    	  countdown--;  
      }
    }  
	
	
	
})