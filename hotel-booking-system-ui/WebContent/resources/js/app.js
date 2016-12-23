var hotelBookingApp = angular.module('hotelBookingApp', [ 'ngRoute' ]);

hotelBookingApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'resources/view/home.html',
		controller : 'HomeController'
	}).when('/booking', {
		templateUrl : 'resources/view/booking.html',
		controller : 'BookingController'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);

hotelBookingApp.controller('HomeController', function($scope) {
	$scope.info = "information";
});

hotelBookingApp.controller('BookingController', function($scope, $http) {
	$scope.info = "bookingInformation";

	$http({
		method : 'GET',
		url : '/hotel-booking-system/booking'
	}).success(function(data, status, headers, config) {
		$scope.cities = data;
		$scope.selectedCity = $scope.cities[0];
	}).error(function(data, status, headers, config) {
	});

	$scope.getHotelsByCity = function() {
		$http({
			method : 'GET',
			url : '/hotel-booking-system/city/' + $scope.selectedCity.cityId,
		}).success(function(data, status, headers, config) {
			$scope.hotels = data;
			$scope.selectedHotel = $scope.hotels[0];
		}).error(function(data, status, headers, config) {
		});
	};

	$scope.getRoomsByHotel = function() {
		$http(
				{
					method : 'GET',
					url : '/hotel-booking-system/hotel/'
							+ $scope.selectedHotel.hotelId,
				}).success(function(data, status, headers, config) {
			$scope.rooms = data;
			$scope.selectedRoom = $scope.rooms[0];
		}).error(function(data, status, headers, config) {
		});
	};

	$scope.checkInDate = new Date();
	$scope.checkInDate.setHours(0, 0, 0, 0);

	$scope.validateCheckOutDate = function() {
		if ($scope.checkOutDate < $scope.checkInDate) {
			$scope.errorMessage = 'Error';
		}
	};

	$scope.submitBookingForm = function() {
		$http({
			method : 'POST',
			/*
			 * url : '/hotel-booking-system/' + $scope.selectedCity.cityId + '/' +
			 * $scope.selectedHotel.HotelId,
			 */
			url : '/hotel-booking-system/bookRoom/',
			params : {
				roomId : $scope.selectedRoom.roomId
			}
		}).success(function(data, status, headers, config) {
			$scope.bookingId = data;
			
		}).error(function(data, status, headers, config) {
		});

		$scope.submitSuccessMessage = "Form submitted successfully";
	}
});