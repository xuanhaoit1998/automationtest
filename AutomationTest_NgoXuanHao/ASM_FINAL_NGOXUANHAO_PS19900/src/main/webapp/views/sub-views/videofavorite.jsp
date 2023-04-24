<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="root" value="/" />

	<div style="border: 2px solid black; border-radius: 5px; height: 260px;  margin-top: 15px; width:465px;">		
		<a href="${root}video?v=${param.id}">			
		   <img src="${param.img}" width="460" height="170"/>									
		  <strong> <a style=" color:black; text-decoration: none; font-size: 17px; " >${param.video_title}</a></strong>		   
		</a>
		<p class='text-right' style="margin-right: 20px;">
		     <a class="btn btn-outline-primary fa fa-eye">${param.views} Views</a>
			<c:choose>			
				<c:when test="${likeid.contains(param.id)}"><a class="btn btn-outline-success" href="${root}dislike1?v=${param.id}"><img src="${root}image/liked.png" width="20"/></a></c:when>
				<c:otherwise>
				<a class="btn btn-outline-primary" href="${root}like?v=${param.id}"><img src="${root}image/like.png" width="20" /></a></c:otherwise>
			</c:choose>
			<a  class="btn btn-outline-danger" href="${root}share?v=${param.id}"><img src="${root}image/share.png" width="20"/></a>
		</p>
	</div>
