/** 
 * New node file
 */


(function(){
	
	
	var appPhone = angular.module('appPone',['appContrl','ngRoute','ng']);
	appPhone.config(['$routeProvider',function($routeProvider){
		
		//alert('url = ' + $location.absUrl());
		
		$routeProvider.when('/phones',
							{  
								templateUrl: 'partials/phone-list.html',
								controller : 'pohoneList as phoneList'
							}
		
		
		).when('/phones/:phoneId',
							{
								templateUrl: 'partials/phone-detail.html',
								controller: 'phoneDetailCtl as pctl'	
							}
				
		).otherwise({
						redirectTo: '/phones'
					}
		);
		
		
	}]);
	
})();




