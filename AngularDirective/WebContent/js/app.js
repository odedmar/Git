(function(){
	
	
	var data =1;
	var app = angular.module('appm',[]);
		
	app.controller('appC',function(){
		
		this.name = data;
		 /*$http.get('/../index.html', function(data) {
		       $scope.name = 1;
		    });
	
		*/
	});
	
})();