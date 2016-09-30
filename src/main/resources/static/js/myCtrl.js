app.controller("myCtrl", function($scope, $http) {
	$http({
		method: "GET",
		url: "http://localhost:8080/api/products"
	}).then(function success(products) {
		console.log(products);
		$scope.products = products.data;
	}, function error(response) {
		console.log(response);
	});
	
	$http({
		method: "GET",
		url: "http://localhost:8080/api/productslists?showEmptyValues=false"
	}).then(function success(productsLists) {
		console.log(productsLists);
		$scope.productsLists = productsLists.data;
	}, function error(response) {
		console.log(response);
	});
	
	$http({
		method: "GET",
		url: "http://localhost:8080/api/personData"
	}).then(function success(personData) {
		console.log(personData);
		$scope.personData = personData.data;
	}, function error(response) {
		console.log(response);
	});
});