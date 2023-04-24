<html <%@ page pageEncoding="utf-8"%>>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:forEach var="item" items="${items}">
	<div class="col-3 mt-2">
		<div class="card text-center">
			<div class="card-body">
				<img src="${item.anh}" width="90%" alt="" class="img-fluid">
				<div class="row border-top mt-2">
					<b>${item.tieude}</b>
				</div>
			</div>
			<div class="card-footer">
				<a href="" class="btn btn-success">${item.like}</a>
				 <a href="" class="btn btn-info">${item.share}</a>
			</div>
		</div>
	</div>
</c:forEach>