/**
 * 	controller.js
 * 	@autor Laura Martinez, Carlos Agudelo
 * 	Descripción: Modulo de AngularJS que contiene los controladores de las diferentes vistas de los usuarios
 */

app.controller("appController", function appController($scope){
	//añadimos usuarios por defecto
	$scope.usuarios = [
        {
            nombre : "Laura",
            apellido : "Martinez",
            ciudad : "Medellin",
            direccion: "Cll 94A # 63A 80",
            email: "laumarlon@gmail.com",
            cedula: "1017159480",
            fecha: "1988-04-12"
        },
        {
        	nombre : "Carlos",
            apellido : "Agudelo",
            ciudad : "Medellin",
            direccion: "Cll 51B 24",
            email: "carloskike@gmail.com",
            cedula: "1234567890",
            fecha: "1990-07-22"
        }
    ]
})
//route params es para identificar los segmentos de la url, en este caso, para reconocer usuarios
app.controller("infoController", function infoController($scope,$routeParams){
	$scope.usuario = $scope.usuarios[$routeParams.id];
});

//creamos el controlador addController para guardar usuarios nuevos con push
app.controller("addController", function addController($scope,$location){
	$scope.textButton = "Añadir un nuevo usuario";
	$scope.usuario = {};
	$scope.newUser = function(){
		$scope.usuarios.push($scope.usuario);
		$location.url("/");
	}
})

app.controller("editController", function editController($scope,$routeParams,$location){
	//obtenemos el usuario a editar con routeParams
	$scope.textButton = "Editar usuario";
	$scope.usuario = $scope.usuarios[$routeParams.id];
	$scope.editUser = function(){
		//actualizamos la información del usuario con el id que lleva $routeParams
		$scope.usuarios[$routeParams.id] = $scope.usuario;
		$location.url("/");
	}
})

//eliminamos el usuario dependiendo de su id
app.controller("removeController", function removeController($scope,$routeParams,$location){
	$scope.usuario = $scope.usuarios[$routeParams.id];
	$scope.removeUser = function(){
		//con splice  eliminamos un usuario del array usuarios, en este caso le decimos que debe eliminar 
		//el que tenga el id que le pasamos con $routeParams, y con el 1, le decimos que sólo 
		//debe eliminar 1, la función splice, como primer parámetro necesita la posición, que en este caso
		//es la id, y el segundo debe ser el número de elementos a eliminar
		$scope.usuarios.splice($routeParams.id, 1);
		$location.url("/");
	}
})
