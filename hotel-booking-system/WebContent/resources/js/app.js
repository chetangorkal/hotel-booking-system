var hotelBookingApp = angular.module('hotelBookingApp', ['ngRoute']);

hotelBookingApp.config('$routeProvider', $routeProvider){
	$routeProvider.when('/home', {
		templateUrl : 'resources/view/home.html',
		controller : 'HomeController'
	}).when('/booking', {
		templateUrl : 'resources/view/booking.html',
		controller : 'BookingController'
	}).otherwise({
		redirectTo : '/home'
	});
}

hotelBookingApp.controller('HomeController', function($scope) {
	$scope.info = "information";
});


hotelBookingApp.controller('BookingController', function($scope) {
	$scope.info = "booingInformation";
});