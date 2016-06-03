function requestService(reqUrl, reqParam, rslFunction) {
	var request = $.ajax({
		url : "http://"+location.host+"/"+reqUrl
		, method : "POST"
		, data : reqParam
		, dataType : "JSON"
	});
	
	request.done(rslFunction);
	
	request.fail(function(jqXHR, textStatus) {
		console.log(textStatus);
	});
}