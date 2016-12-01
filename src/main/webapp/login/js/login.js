/**
 * 	login.js
 * 	@autor Laura Martinez, Carlos Agudelo
 * 	Descripción: Modulo de AngularJS que nos permite hacer la autenticación del usuario
 */


var appUser = angular.module("Usuarios", ["ngRoute"]);

var URL_SERVICIO_AUTENTICACION = "http://localhost:8080/helpet/rest/UserService";


/**
 * Define los servicios necesario para la autenticación del usuario
 */
appUser.service('Usuario', function($http){

	/**
	 * Llama el servicio web para autenticar.
	 */
	this.autenticar = function(email, password){
		return $http({
			method: 'POST',
			url: URL_SERVICIO_AUTENTICACION,
			params: {
				email: email,
				password: password
			} 
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
appUser.controller("contLogin", function($scope, $location, Usuario){
	$scope.nombreUsuario = "";
	$scope.contrasena = "";
	
	$scope.autenticar = function(){
		Usuario.autenticar($scope.nombreUsuario, 
				$scope.contrasena).then(function successCallback(response) {
					if(response.data != ''){
						alert(response.data);
						return;
					}else{
						alert("Datos correctos");
						$cookies.nombreUsuario = $scope.nombreUsuario;
						$location.url("../pet/index_pet");
					}
					$scope.nombreUsuario = "";
					$scope.contrasena = "";
				  }, function errorCallback(response) {
				    alert(data);
				  });
	};
});
