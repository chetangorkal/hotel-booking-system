<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel booking management</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="/hotel-booking-system/resources/js/app.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div ng-app='hotelBookingApp' ng-controller="HomeController">
		<div class='col-lg-4'>
			Welcome to Hotel booking management system <a
				href="/hotel-booking-system/booking">Book a Room</a> <a href="#">View
				Lowest Priced Hotels</a> {{info}}
		</div>
		<div class='col-lg-4'></div>
	</div>
</body>
</html>