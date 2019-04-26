$(document).ready(function() {
	$(".content").html($.ajax({url:"Employee",async:false}).responseText);
});
function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	
	$(".content").html("<img src='../img/loading.gif'/>");
	switch ($(k).attr('id')){
		case "employee":
			htmlobj=$.ajax({url:"Employee",async:false});break;
		case "permission":
			htmlobj=$.ajax({url:"permission.jsp",async:false});break;
		case "logout":
			htmlobj=$.ajax({url:"logout.jsp",async:false});break;
	}
	$(".content").html(htmlobj.responseText);
}
