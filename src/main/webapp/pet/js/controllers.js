app.controller("appController", function appController($scope){
	//añadimos mascotas por defecto
	$scope.mascotas = [
        {
            nombre : "Charlotte",
            edad : "6 años",
            raza : "Criollo",
            estado: 4,
            observaciones: "Gata blanca con amarrillo",
            usuario: "Laura Martinez",
            fecha: "2010-01-25"
        },
        {
            nombre : "Bagheera",
            edad : "3 meses",
            raza : "Criollo",
            estado: 4,
            observaciones: "Gata negra con ojos amarrillos",
            usuario: "David Londoño",
            fecha: "2016-09-10"
        }
    ]
})
//route params es para identificar los segmentos de la url, en este caso, para reconocer mascotas
app.controller("infoController", function infoController($scope,$routeParams){
	$scope.mascota = $scope.mascotas[$routeParams.id];
});

//creamos el controlador addController para guardar mascotas nuevos con push
app.controller("addController", function addController($scope,$location){
	$scope.textButton = "Añadir una nueva mascota";
	$scope.mascota = {};
	$scope.newPet = function(){
		$scope.mascotas.push($scope.mascota);
		$location.url("/");
	}
})

app.controller("editController", function editController($scope,$routeParams,$location){
	//obtenemos el mascota a editar con routeParams
	$scope.textButton = "Editar mascota";
	$scope.mascota = $scope.mascotas[$routeParams.id];
	$scope.editPet = function(){
		//actualizamos la información de la mascota con el id que lleva $routeParams
		$scope.mascotas[$routeParams.id] = $scope.mascota;
		$location.url("/");
	}
})

//eliminamos la mascota dependiendo de su id
app.controller("removeController", function removeController($scope,$routeParams,$location){
	$scope.mascota = $scope.mascotas[$routeParams.id];
	$scope.removePet = function(){
		//con splice  eliminamos un mascota del array mascotas, en este caso le decimos que debe eliminar 
		//el que tenga el id que le pasamos con $routeParams, y con el 1, le decimos que sólo 
		//debe eliminar 1, la función splice, como primer parámetro necesita la posición, que en este caso
		//es la id, y el segundo debe ser el número de elementos a eliminar, cabe decir que splice tiene
		//más variantes, y que sirve para añadir y eliminar elementos en un array, pero eso para otro momento
		$scope.mascotas.splice($routeParams.id, 1);
		$location.url("/");
	}
})
