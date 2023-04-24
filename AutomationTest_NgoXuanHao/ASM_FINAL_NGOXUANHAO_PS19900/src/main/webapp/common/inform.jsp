<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${not empty message }">
	<div class="row">
		<div class="col">
			<div id="message" class="alert alert-success">${message }</div>

		</div>
	</div>
</c:if>

<c:if test="${not empty error }">
	<div class="row">
		<div class="col">

			<div id="messageerror" class="alert alert-danger">${error }</div>
		</div>
	</div>
</c:if>
