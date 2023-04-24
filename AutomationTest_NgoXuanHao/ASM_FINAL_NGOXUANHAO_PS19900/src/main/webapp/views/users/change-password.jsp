<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
   

 <div class="offset-3 col-6 mt-4">
	<form action="ChangePassword" method="post">
		<div class="card">
			<div class="card-header">
				<b>Change Password</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username"> <strong>Username</strong> </label> <input type="text"
								class="form-control" name="username" id="username" value="${user.id}" disabled="disabled"
								aria-describedby="usernamehelpId" placeholder="username">
						<!-- 	<small id="usernamehelpId" style="color: red;"> Vui lòng nhập Username </small> -->
						</div>
						<div class="form-group">
							<label for=""> <strong>Password</strong> </label> <input type="password"
								class="form-control" name="oldpassword" id="password"
								placeholder="password" required="required">
						<small style="color: red;" id="passwordhelpId" >Vui lòng nhập Password</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentpassword"> <strong>Current Password</strong></label> <input
								type="password" class="form-control" name="password"
								id="currentpassword" placeholder="current password" required="required">
				<small style="color: red;" id="currentpasswordhelpId" >Vui lòng nhập Current password</small>
						</div>
						<div class="form-group">
							<label for="confirmpassword"> <strong>Confirm Password</strong></label> <input
								type="password" class="form-control" name="confirmpassword"
								id="confirmpassword" placeholder="confirm password" required="required">
				<small style="color: red;" id="confirmpasswordhelpId" >Vui lòng nhập Confirm password</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success"> <strong>ChangePassword</strong></button>
			</div>
		</div>
	</form>
</div>
  
