<!doctype html>
<html <%@ page pageEncoding="utf-8"%>>

<head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

<body>
	<main class="container">
		<header class="row pt-5 pb-2">
			<jsp:include page="trangcon/header.jsp"></jsp:include>
		</header>
		<nav class="row">
			<jsp:include page="trangcon/menu.jsp"></jsp:include>
		</nav>
		<section class="row">
			<div class="col-9">
				<div class="row p-2">
					<jsp:include page="trangcon/sanpham.jsp"></jsp:include>
				</div>
				<div class="row">
					<jsp:include page="trangcon/qualai.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-3">
				<jsp:include page="trangcon/slidebar.jsp"></jsp:include>
			</div>
		</section>
		<footer class="row">
			<jsp:include page="trangcon/footer.jsp"></jsp:include>
		</footer>
	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>