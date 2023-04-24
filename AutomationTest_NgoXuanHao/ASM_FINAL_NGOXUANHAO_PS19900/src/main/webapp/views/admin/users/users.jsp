<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<c:url var="url" value="/user" />
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="home"
			aria-selected="true"> <strong>User Edition</strong></a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false"> <strong>User
					List</strong></a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="POST">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username"> <strong>Username</strong></label> <input
										class="form-control" type="text" value="${users.id}" name="id"
										placeholder="Username" required="required" /> <small
										id="usernamehelpId" style="color: red;">Vui lòng nhập
										Username</small>
								</div>
								<div class="form-group">
									<label for=""> <strong>Fullname</strong></label> <input
										class="form-control" type="text" value="${users.fullname}"
										name="fullname" placeholder="Fullname" required="required" />
									<small id="fullnamehelpId" style="color: red;"> Vui
										lòng nhập Fullname</small>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for=""> <strong>Password</strong></label> <input
										class="form-control" type="password" value="${users.password}"
										name="password" placeholder="Password" required="required" />
									<small id="passwordhelpId" style="color: red;">Vui lòng
										nhập Password</small>
								</div>
								<div class="form-group">
									<label for=""> <strong>Email</strong></label> <input
										class="form-control" type="email" value="${users.email}"
										name="email" placeholder="Email?" required="required" /> <small
										id="emailhelpId" style="color: red;">Vui lòng nhập
										Email</small>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="admin"
										id="admin" value="true" ${users.admin? "checked" : ""}>
									<label class="form-check-label" for="admin">Admin</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="admin"
										id="user" value="false" ${users.admin? "" : "checked"}>
									<label class="form-check-label" for="user">User</label>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary" formaction="${url}/create"
							name="btnCreate">Create</button>
						<button class="btn btn-warning" formaction="${url}/update"
							name="btnUpdate">Update</button>
						<button class="btn btn-danger" formaction="${url}/delete"
							name="btnDelete">Delete</button>
						<button class="btn btn-info" formaction="${url}/index"
							name="btnReset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab"
			style="margin-top: 20px; right: 30px; height: 480px; overflow-x: hidden;">
			<table class="table table-stripe">
				<tr>
					<td><strong>Username</strong></td>
					<td><strong>Password</strong></td>
					<td><strong>Fullname</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Role</strong></td>
				</tr>
				<c:forEach var="user" items="${list}">
					<tr>
						<td>${user.id }</td>
						<td>${user.password }</td>
						<td>${user.fullname }</td>
						<td>${user.email }</td>
						<td>${user.admin ? "Admin":"User" }</td>
						<td><a
							style="border: 2px solid; color: white; border-radius: 4px; padding: 5px; background-color: orange; text-decoration: none;"
							href="${url}/edit/${user.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>