<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel booking management</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<script src="/hotel-booking-system-ui/resources/js/app.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<div ng-app='hotelBookingApp'>
		<div class='container-fluid'>
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Hotel booking system</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#booking">Book a Room</a></li>
					<li><a href="#home">View Lowest Priced Hotels</a></li>
				</ul>
			</div>
			</nav>
			<div class='col-lg-12'>
				<h1 class='text-center'>Welcome to Hotel booking management
					system {{info}}</h1>
			</div>
			<div>
				<div ng-view class='col-lg-12'></div>
			</div>
		</div>
	</div>
</body>
</html>