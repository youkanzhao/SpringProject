define(['jquery', 'util/util'], function($, util){
	return {
		sendRequest : function(){
			$.ajax({
				url : "ajax.html",
				type: "POST",
			    data: "data={id : 7, name : 6}",
			    dataType : "json",
				success : function(data) {
					console.info($.jsonToString(data));
				}
			});
		}
	}
});