<html <%@ page pageEncoding="utf-8"%>>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="row mt-3 mb-3">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<i class="fa fa-thumbs-up" aria-hidden="true"></i> Favorites
							</div>
							<ul class="list-group list-group-flush">
								<c:forEach var="i" begin="0" end="8">
									<li class="list-group-item">sản phẩm</li>
								</c:forEach>
								
								
							</ul>
						</div>
					</div>
				</div>