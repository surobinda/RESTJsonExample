
	var mainApp = angular.module("personApp", ['ngRoute']);
    
    mainApp.config(['$routeProvider',
       function($routeProvider) {
          $routeProvider.
             when('/addPerson', {
                templateUrl: 'template/addperson.html',
                controller: 'AddPersonController'
             }).
             when('/addAddress', {
                templateUrl: 'template/addaddress.html',
                controller: 'AddAddressController'
             }).
             when('/listPerson', {
                 templateUrl: 'template/listperson.html',
                 controller: 'ListPersonController'
              }).
             otherwise({
            	templateUrl: 'template/default.html',
                controller: 'DefaultPersonController'
             });
    }]);

    mainApp.controller('AddPersonController', ['$rootScope', '$location', '$scope', '$http',function($rootScope, $location, $scope, $http) 
    {
    	$scope.firstName = "";
		$scope.lastName = "";
		$scope.message = "";
		
    	$scope.go = function ( path ) 
		{
			$rootScope.firstName = $scope.firstName;
			$rootScope.lastName = $scope.lastName;
			$scope.reset();
			$location.path( path );
		}
		
		$scope.reset = function() 
		{
			$scope.firstName = "";
			$scope.lastName = "";
			$scope.message = "";
		}
	}]);
    
    
    mainApp.controller('AddAddressController', ['$rootScope','$location', '$scope', '$http',function($rootScope, $location, $scope, $http) 
    {
        $scope.message = " " ;
        $scope.submit = function() 
		{
			var dataObj = 
			{
				firstName: $scope.firstName,
				lastName: $scope.lastName,
				addresses:[{addressLine1:$scope.addressLine1, addressLine2:$scope.addressLine2, city:$scope.city, province:$scope.province, country:$scope.country}]
			};
			
			var res = $http.post('/personweb/rest/api/person', dataObj);
			res.success(function(data, status, headers, config)
			{
				$rootScope.message = "Person details has been successfully saved, person id - " + data.personId;
				$scope.reset();
				$location.path( "/index" );
			});
			
			res.error(function(data, status, headers, config)
			{
				$rootScope.message = "Failed to save person details. Please try after some time." + status;
				$scope.reset();
				$location.path( "/index" );
			});	
		}
        
        $scope.reset = function() 
		{
			$scope.addressLine1 = "";
			$scope.addressLine2 = "";
			$scope.city = "";
			$scope.province = "";
			$scope.country = "";
		}
        
    }]);
	
    mainApp.controller('ListPersonController', ['$rootScope','$location', '$scope', '$http', function($rootScope,$location, $scope, $http) 
    {
        $scope.message = "Back-end code not yet integrated";
        $http.get('/personweb/rest/api/person').
        success(function(data) {
            $scope.persons = data;
        });
        
	}]);
	
	mainApp.controller('DefaultPersonController', ['$rootScope','$location', '$scope', '$http',function($rootScope,$location, $scope, $http) 
	{
        if ($rootScope.message != null)
        {
        	$scope.message = $rootScope.message;
        }
        else
    	{
        	$scope.message = "Welcome to Person-Address Application !";
    	}
		
    }]);
