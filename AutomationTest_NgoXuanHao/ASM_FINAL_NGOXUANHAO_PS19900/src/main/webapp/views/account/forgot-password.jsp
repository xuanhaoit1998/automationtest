<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> QUÊN MẬT KHẨU</title>
<!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body style="background-image: url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg'); background-size: cover;
background-repeat: no-repeat;
height: 100%;
font-family: 'Numans', sans-serif;">	
	<div class="offset-4 col-4" style="margin-top: 150px">
	<form action="" method="post">
		<div class="card mt-5">
			<div class="card-header">
				<b style="color: red; font-size: 30px;">Forgot Password</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div>
							<label for="username"> <strong>Username</strong></label>
							<div class="input-group">
								<span class="input-group-text"> <i class="fa fa-user"></i></span> 
								<input type="text" class="form-control" name="id" id="username" placeholder="username" required="required">
							</div>
							<small style="color: red;" id="usernamehelpId">Vui lòng nhập Username</small>
						</div>
						
						<div>
							<label for=""> <strong>Email</strong></label>
							<div class="input-group">
								  <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
								<input type="text" class="form-control" name="email" id="email" placeholder="email" required="required"> 
							</div>
							<small id="emailhelpId" style="color: red;">Vui lòng nhập Email</small>
						</div>
					</div>
				</div>

			</div>
			<div class="card-footer text-muted">
				<button type="submit" class="btn btn-success" style="margin-left: 150px">Quên Mật Khẩu</button>
				<div class="d-flex justify-content-center links">
					<a href="/asm/Login">Login</a>
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>
    
