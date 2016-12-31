var hotelBookingApp = angular.module('hotelBookingApp', [ 'ngRoute' ]);

hotelBookingApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'resources/view/home.html',
		controller : 'HomeController'
	}).when('/booking', {
		templateUrl : 'resources/view/booking.html',
		controller : 'BookingController'
	}).when('/best_prices', {
		templateUrl : 'resources/view/best_prices.html',
		controller : 'PriceController'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);

hotelBookingApp.controller('HomeController', function($scope) {
	$scope.info = "information";
});

hotelBookingApp.controller('PriceController',
		function($scope, $http, $location) {
			$http({
				method : 'GET',
				url : '/hotel-booking-system/booking'
			}).success(function(data, status, headers, config) {
				$scope.cities = data;
				$scope.selectedCity = $scope.cities[0];
			}).error(function(data, status, headers, config) {
			});

			$scope.getLowestPricedHotelsByCity = function() {
				$http(
						{
							method : 'GET',
							url : '/hotel-booking-system/best_prices/'
									+ $scope.selectedCity.cityId,
						}).success(function(data, status, headers, config) {
					$scope.hotels = data;
					$scope.selectedHotel = $scope.hotels[0];
				}).error(function(data, status, headers, config) {
				});
			};
		});

hotelBookingApp
		.controller(
				'BookingController',
				function($scope, $http, $location) {
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
								})
								.success(
										function(data, status, headers, config) {
											$scope.hotels = data;
											$scope.bookingDto.selectedHotel = $scope.hotels[0];
										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.bookingDto.checkInDate = new Date();
					$scope.bookingDto.checkInDate.setHours(0, 0, 0, 0);

					$scope.cancelBooking = function() {
						$location.path('/home');
					}
					$scope.validateCheckOutDate = function() {
						if ($scope.bookingDto.checkOutDate <= $scope.bookingDto.checkInDate) {
							$scope.hasInvalidCheckOutDate = true;
						} else {
							$scope.hasInvalidCheckOutDate = false;
						}
					};

					$scope.submitBookingForm = function() {
						$scope.bookingDetails = {};
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

											if (data.data.bookingId > 0) {
												$scope.message = "Booking is confirmed. Booking reference is "
												$scope.bookingDetails = data.data;
												$scope.amountMessage = "Booking amount is "
											} else if (data.data.bookingId = -1) {
												$scope.message = "Rooms are not available for the selected dates. Please try to book rooms in a different hotel"
											} else {
												$scope.message = "Booking failed. Please try again after some time."
											}

										},
										function(data, status, headers, config) {
										});
					}
				});