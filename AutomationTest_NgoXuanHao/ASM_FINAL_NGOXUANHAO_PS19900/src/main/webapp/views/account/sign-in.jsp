<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>LOGIN</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">

<!--Custom styles-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/style.css"></c:url>">
</head>
<body>
	<div class="container">
		<div id="dialog" title="Dialog box">
		</div>
		<div class="d-flex justify-content-center h-100">
			<div class="card" style="height: 400px;" >
				<div class="card-header">
					<h3>Sign In</h3>
					<div class="d-flex justify-content-end social_icon">
						<span ><i class="fab fa-facebook-square"></i></span> <span><i
							class="fab fa-google-plus-square"></i></span> <span><i
							class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
				<jsp:include page="/common/inform.jsp"></jsp:include>
					<form action="" method="post">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username"
								name="username" value="${username}" required="required">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input  class="form-control"
								placeholder="password" name="password" type="password" value="${password}"required="required">
						</div>
						<div class="row align-items-center remember">
							<input name="remember" type="checkbox">Remember me?
						</div>
						<div class="form-group">
							<button 
								class="btn float-right login_btn" name="login">Login</button>
						</div>
					</form>
				</div>
				
				<div class="card-footer" >
					<div class="d-flex justify-content-center links">
						<a href="/asm/account/sign-up">Sign Up</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="/asm/account/forgot-password">ForgotPassword</a>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>