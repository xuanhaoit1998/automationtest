<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="root" value="/" />
<div class="col-sm-12" >
	<div class="row">
		<c:forEach var="v" items="${videofavorite}">
		<div class="col-sm-4">
			<jsp:include page="videofavorite.jsp">
				<jsp:param name="id" value="${v[0]}" />
				<jsp:param name="img" value="${root}image/${v[2]}" />
				<jsp:param name="video_title" value="${v[1]}" />
				<jsp:param name="views" value="${v[4]}" />
			</jsp:include>
		</div>
		</c:forEach>
	</div>
	</div>
	 <div class="col-sm-4">
	<footer class=" text-center ">
    <div class="row" style="margin-left: 750px; " >
                <div class="col">
                         <nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link" href="?page=1">Prev</a></li>							
							<c:forEach var='p' begin="1" end="${totalPage}" step="1">
								<li class="page-item"><a class="page-link"
									href="?page=${p}">${p}</a></li>
							</c:forEach>							
							<li class="page-item"><a class="page-link"						
								href="?page=${totalPage}">Next</a></li>
						</ul>
					</nav>
                </div>
      </div>	
     </footer>
  </div>
