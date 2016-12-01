/**
 * 	login.js
 * 	@autor Laura Martinez Londoño, Carlos Agudelo
 * 	Descripción: Modulo de AngularJS que nos permite hacer la autenticación del usuarion
 */


var appUser = angular.module("user", []);

var URL_SERVICIO_AUTENTICACION = "http://localhost:8080/helpet/rest/UserService/login";

/**
 * Define los servicios necesario para la autenticación del usuario
 */
appUser.service('Usuario', function($http){

	/**
	 * Llama el servicio web para autenticar.
	 */
	this.autenticar = function(us, pas){
		alert('pepe');
		return $http({
			method: 'POST',
			url: URL_SERVICIO_AUTENTICACION,
			params: {
				user: us,
				pas: pas
			} // login y clave tal cual como se llama en el servicio
		});
	};
});



/**
 * Configura el route de la aplicación para trabajar con Single Page Application
 */
appUser.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: "login.html",
		controller: "contLogin"
	});	
}]);


/**
 * Controlador para funcionalidad de la autenticación del usuario
 */
appUser.controller("contLogin", function($scope, $location, User){
	$scope.email = "";
	$scope.password = "";
	
	$scope.autenticar = function(){
		User.autenticar($scope.email, 
		$scope.password).then(function successCallback(response) {
			if(response.data == Faile){
				alert(response.data);
				return;
			}else{
				alert("Datos correctos");
				$cookies.email = $scope.email;
				$location.url("/users");
			}
			$scope.user = "";
			$scope.password = "";
		  }, function errorCallback(response) {
		    alert(data);
		  });
	};
});
