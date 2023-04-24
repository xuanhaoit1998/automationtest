<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="root" value="/" />

<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="home"
			aria-selected="true"> <strong>Favorites</strong></a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false"> <strong>Favorites
					Users</strong></a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="shareFriends-tab" data-toggle="tab" href="#shareFriends"
			role="tab" aria-controls="shareFriends" aria-selected="false"> <strong>Share
					Friends</strong></a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab"
			style="margin-top: 20px; right: 30px; height: 480px; overflow-x: hidden;">
			<table class="table table-bordered mt-3">
				<tr>
					<td><strong>Video Title</strong></td>
					<td><strong>Favorties Count</strong></td>
					<td><strong>Lasted Date</strong></td>
					<td><strong>Oldest Date</strong></td>
				</tr>
				<c:forEach var="item" items="${favList}">
					<tr>
						<td>${item.videoTitle }</td>
						<td>${item.favoriteCount }</td>
						<td>${item.newestDate }</td>
						<td>${item.oldestDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label> <strong>Video Title</strong> <select
									name="videoUserId" id="videoUserId" class="form-control ml-3">
										<c:forEach var="item" items="${vidList}">
											<option value="${item.id }"
												${item.id == videoUserId?'selected':'' }>${item.title }</option>
										</c:forEach>
								</select>
								</label>
								<button class="btn btn-danger">
									<strong>Report</strong>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3"
						style="margin-top: 20px; right: 10px; height: 480px; overflow-x: hidden;">
						<table class="table table-bordered">
							<tr>
								<td><strong>Username</strong></td>
								<td><strong>Fullname</strong></td>
								<td><strong>Email</strong></td>
								<td><strong>Favorite Date</strong></td>
							</tr>
							<c:forEach var="item" items="${favUsers}">
								<tr>
									<td>${item.id}</td>
									<td>${item.fullname }</td>
									<td>${item.email }</td>
									<td>${item.likeDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		
		<div class="tab-pane fade" id="shareFriends" role="tabpanel"
			aria-labelledby="videoList-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label> <strong>Video Title</strong> <select
									name="userSends" id="userSends" class="form-control ml-3">
										<c:forEach var="item" items="${vidList}">
											<option value="${item.id }"
												${item.id == videoUserId?'selected':'' }>${item.title }</option>
										</c:forEach>
								</select>
								</label>
								<button class="btn btn-danger">
									<strong>Report</strong>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3"
						style="margin-top: 20px; right: 10px; height: 480px; overflow-x: hidden;">
						<table class="table table-bordered">
							<tr>
								<td><strong>Sender Name</strong></td>
								<td><strong>Sender Email</strong></td>
								<td><strong>Receiver Email</strong></td>
								<td><strong>Sent Date</strong></td>
							</tr>
							<c:forEach var="item" items="${sendUsers}">
								 <tr>
								   <td>${item.fullname}</td>
									<td>${item.email}</td>
									<td>${item.emails}</td>
									<td>${item.shareDate}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>	
</div>