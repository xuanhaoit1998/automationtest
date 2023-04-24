<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ONLINE ENTERTAINMENT</title>
</head>

<body >	
		<nav class="navbar navbar-expand-lg navbar-warning bg-warning" >
	<div class="container-fluid" >
		<a style="color: red;" class="navbar-brand fa fa-film" href="./Home"> <strong>ONLINE ENTERTAINMENT</strong> </a>
		
		<div class="collapse navbar-collapse" style="margin-left: 550px;">								
			
			<div class="nav-item">
               <a class="nav-link" href="./Favorite"><i class="fa fa-comment" aria-hidden="true"></i> <strong>MY FAVORITES</strong></a>
            </div>
		    
		  <div class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-user" aria-hidden="true"></i>
            <strong> MY ACCOUNT</strong>  </a>
           <div class="dropdown-menu" aria-labelledby="dropdownId">
           <c:if test="${ ! isLogin }">
                <a class="dropdown-item " href="./Login"> <strong>Login</strong> </a>
				<a class="dropdown-item" href="./ForgotPassword"> <strong>Forgot Password</strong> </a>
				<a class="dropdown-item" href="./Registration"> <strong>Registration</strong> </a>
				</c:if>
			<c:if test="${isLogin}">
			    <a class="dropdown-item fa fa-angle-double-right" href="./Logoff"> <strong>Log</strong> </a>
				<a class="dropdown-item fa fa-angle-double-right" href="./ChangePassword"> <strong>Change Password</strong> </a>
				<a class="dropdown-item fa fa-angle-double-right" href="./EditProfile"> <strong>Edit Profile</strong> </a>
			</c:if>
            </div>
          </div>	
          	  	<c:if test="${not (empty sessionScope.user) }">
					<c:if test="${sessionScope.user.admin}">						
					<div class="nav-item">
               <a class="nav-link" href="./Videos" id="admin"><i class="fa fa-user" aria-hidden="true" ></i> <strong>ADMIN</strong> </a>
           
            </div>	
					</c:if>
				</c:if>                     
	   </div>
	    <a  ><img src="image/anh.jpg" alt="" width="40px;" height="40px;" style="margin-right: 20px;"></a>
	   <a > <img  src="image/VN.jpg" alt="" width="45px;" height="40px;" > </a>
	</div>
</nav>
</body>
</html>
