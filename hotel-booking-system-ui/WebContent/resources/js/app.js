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

hotelBookingApp.controller('BookingController', function($scope, $http,
		$location) {
	$scope.info = "bookingInformation";
	$scope.bookingDto = {};

	$http({
		method : 'GET',
		url : '/hotel-booking-system/booking'
	}).success(function(data, status, headers, config) {
		$scope.cities = data;
		$scope.bookingDto.selectedCity = $scope.cities[0];
	}).error(function(data, status, headers, config) {
	});

	$scope.getHotelsByCity = function() {
		$http(
				{
					method : 'GET',
					url : '/hotel-booking-system/city/'
							+ $scope.bookingDto.selectedCity.cityId,
				}).success(function(data, status, headers, config) {
			$scope.hotels = data;
			$scope.bookingDto.selectedHotel = $scope.hotels[0];
		}).error(function(data, status, headers, config) {
		});
	};

	$scope.bookingDto.checkInDate = new Date();
	$scope.bookingDto.checkInDate.setHours(0, 0, 0, 0);

	$scope.cancelBooking = function() {
		$location.path('/home');
	}
	$scope.validateCheckOutDate = function() {
		if ($scope.bookingDto.checkOutDate < $scope.bookingDto.checkInDate) {
			$scope.errorMessage = 'Error';
		}
	};

	$scope.submitBookingForm = function() {
		var bookingFormDto = {
			"bookingId" : 0,
			"cityId" : $scope.bookingDto.selectedCity.cityId,
			"hotelId" : $scope.bookingDto.selectedHotel.hotelId,
			"noOfRooms" : $scope.bookingDto.noOfRooms,
			"checkInDate" : $scope.bookingDto.checkInDate,
			"checkOutDate" : $scope.bookingDto.checkOutDate
		};
						$http
								.post('/hotel-booking-system/bookRoom/',
										bookingFormDto)
								.then(
										function(data, status, headers, config) {
											$scope.message = "Booking Id is "
												$scope.bookingId = data;

										},
										function(data, status, headers, config) {
										});
		/*$http({
			method : 'POST',
			url : '/hotel-booking-system/bookRoom/',
			params : {
				"bookingFormDto" : {
					"bookingId" : 0,
					"cityId" : $scope.bookingDto.selectedCity.cityId,
					"hotelId" : $scope.bookingDto.selectedHotel.hotelId,
					"noOfRooms" : $scope.bookingDto.noOfRooms,
					"checkInDate" : $scope.bookingDto.checkInDate,
					"checkOutDate" : $scope.bookingDto.checkOutDate
				}
			}
		}).success(function(data, status, headers, config) {
			$scope.message = "Booking confirmed. Booking Id is " + data;

		}).error(function(data, status, headers, config) {
		});*/

		;
	}
});