<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="url" value="/" />

<div class="col mt-4" style="bottom: 25px;">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="home"
			aria-selected="true"> <strong>Video Editing</strong></a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="profile" aria-selected="false"> <strong>Video List</strong></a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card" >

					<div class="card-body"  >
					<jsp:include page="/common/inform.jsp"></jsp:include>
						<div class="row">
							<div class="col-3">
								<div class="border p-3" > 
								<%-- <img src="${video.poster != null?video.poster: 'image/hinhreset.jpg' }" alt="" class="img-fluid">             --%>              								
									<c:if test="${not(empty(video.poster))}">
										<img src="<c:url value="/image/${video.poster} "/>" alt="" height="200px" width="250px">	
									</c:if> 
									<c:if test="${empty(video.poster)}">
										<img src="<c:url value="/image/hinhreset.jpg"/>" alt="" height="200px" width="250px">	
									</c:if>
									<div class="input-group mb-3 mt-3" >
									<div class="input-group-prepend">																			
									</div>
									<div class="custom-file">		
									<input type="file" class="custom-file-input" id="cover" name="cover" required="required"/>						 
								<!-- 	<input style="margin:10px; border: 3px solid orange;  border-radius: 7px; "  type="file" class="" id="cover" name="cover" required="required">	 -->								
									<label for="cover" style="margin-right: 150px; border: 3px solid orange; border-radius: 7px; background-color: orange;" >Choose Poster</label>								
									</div>									
									</div>
									<small style="color: red; ">Vui lòng chọn hình trong image </small>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group" >
									<label for="youtubeId"> <strong>Youtube ID</strong></label> <input type="text"
										class="form-control" name="id" id="youtubeId" value="${video.id }"
										aria-describedby="youtubeIdhelpId" placeholder="YoutubeId" required="required">
									<small id="youtubeIdhelpId" style="color: red;">Vui lòng nhập Youtube ID </small>
								</div>
								<div class="form-group">
									<label for="videoTitle"> <strong>Video Title</strong></label> <input type="text"
										class="form-control" name="title" id="videoTitle" value="${video.title }"
										aria-describedby="videoTitle" placeholder="VideoTitle" required="required">
										<small id="videoTitile" style="color: red;">Vui lòng nhập VideoTitle</small>
								</div>
								<div class="form-group" >
									<label for="viewCount"> <strong>View Count</strong></label> <input type="text"
										class="form-control" name="views" id="viewCount"value="${video.views}"
										aria-describedby="viewCounthelpId" placeholder="viewCount" required="required" disabled="disabled">
									<!-- <small id="viewCounthelpId" style="color: red;">Vui lòng nhập View Count</small> -->
								</div>
								<div class="form-check form-check-inline" >
									<label> <input type="radio" class="form-check-input"
										value="true" name="active" id="status" ${video.active? 'checked':'' }  > <strong>Active</strong>
									</label> <label> <input type="radio" class="form-check-input"
										value="false" name="active" id="status" ${! video.active? 'checked':'' }> <strong>Inactive</strong>
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description"> <strong>Description</strong></label>
								<textarea name="description" id="description" cols="8" rows="2" class="form-control">${video.description}</textarea>
							</div>
						</div>
					</div>
					
					<div class="card-footer text-muted" >
						<button class="btn btn-primary" formaction="Videos/create">Create</button>
						<button class="btn btn-warning" formaction="Videos/update">Update</button>
						<button class="btn btn-danger" formaction="Videos/delete">Delete</button>
						<button class="btn btn-info" formaction="Videos/reset">Reset</button>
					</div>					
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab" style="margin-top: 20px; right: 30px; height:  600px;  overflow-x: hidden;">
			<table class="table table-stripe">
				<tr>
					<td > <strong>Youtube ID</strong> </td>
					<td > <strong>Video Title</strong> </td>
					<td > <strong>View Count</strong></td>
					<td > <strong>Status</strong></td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${videos }">
				<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>${item.views }</td>
					<td>${item.active? 'Active': 'Inactive' }</td>									
					<td><a  style="border: 2px solid; color:white; border-radius:4px; padding: 5px; background-color: orange; text-decoration: none;"
					 href="Videos/edit?id=${item.id }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>				
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>