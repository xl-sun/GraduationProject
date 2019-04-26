$(function () {
	$(".sheng").change(function(){
		regionAjax($(this));

		$(this).next().next().html("<option  value='' selected hidden>-区-</option>");
		$(this).next().next().attr("disabled","disabled"); 
	});
	
	$(".shi").change(function(){
		regionAjax($(this));
	});
	
	$(".qu").change(function(){
		sheng=$(this).siblings(".sheng").find("option:selected").text();
		shi=$(this).siblings(".shi").find("option:selected").text();
		qu=$(this).find("option:selected").text();
		value = sheng+"-"+shi+"-"+qu;
		$(this).next().next().attr("value",value);
	});
	
	function regionAjax(select){
		var pid = select.val();
		htmlobj=$.ajax({url:"RegionServlet?pid="+pid,async:false});
		var result = "<option  value='' selected hidden>-请选择-</option>";
		var json=eval('(' + htmlobj.responseText + ')');

		$.each(json,function(i){
			result+="<option  value='"+ i +"'>"+ json[i] +"</option>";
		});
		select.next().html(result);
		select.next().removeAttr("disabled"); 
	};
	
	$(".querycode").change(function(){
		code = $(this).next();
		switch ($(this).find("option:selected").text()){
		case "不使用":
			code.attr("type","hidden");
			code.attr("value","");
			break;
		case "设置查询码":
			code.attr("type","text");
			code.attr("value","");
			break;
		}
	});
})
