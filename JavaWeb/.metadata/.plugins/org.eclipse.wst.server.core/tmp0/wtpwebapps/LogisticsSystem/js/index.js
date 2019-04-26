$(document).ready(function() { 
	$('.div_banner').slidesjs({
        width: 600,
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
function clear_waybill(){
	$("#waybill_text").val('');
};