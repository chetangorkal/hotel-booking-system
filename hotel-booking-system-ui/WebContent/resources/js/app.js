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
	
	$scope.getHotels = function(){
		$http({
			method : 'GET',
			url : '/hotel-booking-system/cities'
		}).success(function(data, status, headers, config) {
			$scope.info = data;
		}).error(function(data, status, headers, config) {
		});
	}

	$scope.getHotelByCity = function() {
		$scope.hotels = [ {
			"hotelId" : 1,
			"name" : "hotel1Name",
			"address" : "hotel1Address",
			"phone" : "hotel1Phone"
		}, {
			"hotelId" : 2,
			"name" : "hotel2Name",
			"address" : "hotel2Address",
			"phone" : "hotel2Phone"
		}, {
			"hotelId" : 3,
			"name" : "hotel3Name",
			"address" : "hotel3Address",
			"phone" : "hotel3Phone"
		}, {
			"hotelId" : 4,
			"name" : "hotel4Name",
			"address" : "hotel4Address",
			"phone" : "hotel4Phone"
		}, {
			"hotelId" : 5,
			"name" : "hotel5Name",
			"address" : "hotel5Address",
			"phone" : "hotel5Phone"
		}, {
			"hotelId" : 6,
			"name" : "hotel6Name",
			"address" : "hotel6Address",
			"phone" : "hotel6Phone"
		} ];

		$scope.selectedHotel = {
			"hotelId" : 1,
			"name" : "hotel1Name",
			"address" : "hotel1Address",
			"phone" : "hotel1Phone"
		};
	};

	$scope.getRoomsByHotel = function() {
		$scope.rooms = [ {
			"roomId" : 1,
			"roomType" : "AC"
		}, {
			"roomId" : 2,
			"roomType" : "Non-AC"
		}, {
			"roomId" : 3,
			"roomType" : "AC"
		} ];

		$scope.selectedRoom = {
			"roomId" : 1,
			"roomType" : "AC"
		};
	};

	$scope.selectedCity = {
		"cityId" : 1,
		"name" : "Bengaluru"
	};

	$scope.cities = [ {
		"cityId" : 1,
		"name" : "Bengaluru"
	}, {
		"cityId" : 2,
		"name" : "Mysore"
	}, {
		"cityId" : 3,
		"name" : "Hubli"
	} ];

	$scope.checkInDate = new Date();
	$scope.checkInDate.setHours(0, 0, 0, 0);

	$scope.validateCheckOutDate = function() {
		if ($scope.checkOutDate < $scope.checkInDate) {
			$scope.errorMessage = 'Error';
		}
	};

	$scope.submitBookingForm = function() {
		$scope.submitSuccessMessage = "Form submitted successfully";
	}
});