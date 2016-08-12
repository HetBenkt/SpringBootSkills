app.controller("myCtrl", function($scope, $http) {
	$http({
		method: "GET",
		url: "http://localhost:8080/api/showAllProducts"
	}).then(function success(products) {
		console.log(products);
		$scope.products = products.data;
	}, function error(response) {
		console.log(response);
	});
	
	$http({
		method: "GET",
		url: "http://localhost:8080/api/showAllProductsLists"
	}).then(function success(productsLists) {
		console.log(productsLists);
		$scope.productsLists = productsLists.data;
	}, function error(response) {
		console.log(response);
	});
});