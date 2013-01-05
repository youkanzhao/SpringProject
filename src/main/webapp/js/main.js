require.config({
	paths: {
		// Alias for CSS plugin
		JQUERY_UI:  '../jquery-ui',
		CSS_HOME :  '../css',
		JS_HOME  :  './',
		'css'    :	'./lib/require-css'
	}
});

requirejs([
   'jquery', 
   'index',
   'JQUERY_UI/js/jquery-ui',
   'css!CSS_HOME/reset',
   'css!JQUERY_UI/css/jquery-ui',
   'css!CSS_HOME/index'
], function($, index, juqeryUI){
	index.sendRequest();
	$("#datepicker").datepicker({
		showOtherMonths: true,
		selectOtherMonths: true
	});
});