/**
 * Configura el route de la aplicación para trabajar con Single Page Application
 */

var appUser = angular.module("Usuarios", ["ngRoute"]);

appUser.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: "login.html",
		controller: "contLogin"
	});
	
}]);