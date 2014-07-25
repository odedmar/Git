
$('#plist').ready(function(){
	
		
	var p = $('#splace');
	
	var offset=p.offset();
	
		
	$('#plist').offset({ top: offset.top + 50, left: offset.left +  200 });
	

	/*
	var plp = $('#plist');
	var  pp = plp.position();
	
	alert('list top = ' + pp.top + 'list left = ' +pp.left);
	*/
});