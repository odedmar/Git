/**
 * Module wich will be hold the app controllers.
 */


(function(){
	
	
	var appContrl = angular.module('appContrl',[]);
	
	appContrl.controller('pohoneList',['$http',function($http){
		
	
	var currentScope = this;	
	this.orderProp='name';	
	
		
	$http.get('phones/phones.json').success(function(data){
		
		currentScope.phones = data;
	});
	
			
	}]);	
	
appContrl.controller('phoneDetailCtl',['$routeParams',function($routeParams){
		
	
		
		this.phoneId = $routeParams.phoneId;
		
		
	}]);
	
	
})();