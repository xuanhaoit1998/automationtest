<!doctype html>
<html <%@ page pageEncoding="utf-8"%>>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<main class="container">
		<section class="row">
			<div class="col-8 offset-2">
				<form action="" method="post">
					<div class="card">
						<div class="card-header">
							<b>Registration</b>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="username">Username</label> <input type="text"
											class="form-control" name="username" id="username"
											aria-describedby="usernameHId" placeholder="Input username">
										<small id="usernameHId" class="form-text text-muted">Username
											is required!</small>
									</div>
									<div class="form-group">
										<label for="fullname">Fullname</label> <input type="text"
											class="form-control" name="fullname" id="fullname"
											aria-describedby="fullnameHId" placeholder="Input fullname">
										<small id="fullnameHId" class="form-text text-muted">Fullname
											is required!</small>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label for="password">Password</label> <input type="password"
											class="form-control" name="password" id="password"
											placeholder="Input password"> <small id="passwordHId"
											class="form-text text-muted">Password is required!</small>
									</div>
									<div class="form-group">
										<label for="email">Email</label> <input type="text"
											class="form-control" name="email" id="email"
											aria-describedby="emailHId" placeholder="Input email">
										<small id="emailHId" class="form-text text-muted">Email
											is required!</small>
									</div>
								</div>
							</div>
						</div>