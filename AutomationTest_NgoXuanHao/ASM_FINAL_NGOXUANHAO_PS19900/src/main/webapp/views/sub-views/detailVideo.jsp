<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="root" value="/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body >
	<article class="col-sm-8" style="margin-top: 20px">
		<div class="card" style="width: 940px;">
		<%-- 	<iframe width="940" height="600" src="https://www.youtube.com/embed/${video.id}" ></iframe> --%>
		<iframe width="940" height="600" src="https://www.youtube.com/embed/${video.id}" title="YouTube video player" frameborder="0" 
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>		
	</article>
 
  <aside class="col-sm-4" style="margin-top: 20px; right: 30px; height: 600px;  overflow-x: hidden;">
		<c:forEach var="v" items="${lichsu}">
				<div class="list-group-item " style="height: 130px;" >
					<div class="row">
						<div class="col-md-4">
							<a href="${root}video?v=${v.id}"><img class="d-flex align-self-start" src="${root}image/${v.poster}" alt="" width='150px'>
							</a>
						</div>
						<div class="col-md-8" style="font-weight: bold;">
							<a href="${root}video?v=${v.id}" style="color: black; text-decoration: none; margin-left: 15px;"> ${v.title } </a>
							<div><div class="fa fa-eye" style="margin-left: 15px;">${v.views } Views</div></div>
							<a  style="margin-left: 15px;" class="btn btn-outline-danger" href="${root}share?v=${v.id}"><img src="${root}image/share.png" width="15"/></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</aside>
</body>
</html>