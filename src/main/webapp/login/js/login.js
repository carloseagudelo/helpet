/**
 * 	login.js
 * 	@autor Laura Martinez Londoño
 * 	Descripción: Modulo de AngularJS que nos permite hacer la autenticación del usuarion
 */


var appUser = angular.module("Usuarios", []);

var URL_SERVICIO_AUTENTICACION = "http://localhost:11901/EjemploJersey/rest/ServicioUsuario";
var URL_SERVICIO_LISTA_CLIENTES = "http://localhost:11901/EjemploJersey/rest/ServicioCliente";


/**
 * Define los servicios necesario para la autenticación del usuario
 */
appUser.service('Usuario', function($http){

	/**
	 * Llama el servicio web para autenticar.
	 */
	this.autenticar = function(usuario, pws){
		return $http({
			method: 'GET',
			url: URL_SERVICIO_AUTENTICACION,
			params: {
				login: usuario,
				clave: pws
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
	
	$routeProvider.when('/clientes', {
		templateUrl: "listaClientes.html",
		controller: "contClientes"
	});
	
	$routeProvider.when('/cliente', {
		templateUrl: "cliente.html",
		controller: "contCliente"
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
						$location.url("/clientes");
					}
					$scope.nombreUsuario = "";
					$scope.contrasena = "";
				  }, function errorCallback(response) {
				    alert(data);
				  });
	};
});
