<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-warning bg-warning" >
	<div class="container-fluid" >
		<a style="color: red;" class="navbar-brand fa fa-film" href="./Videos"> <strong>ADMINISTRATION TOOL</strong></a>
		
		<div class="collapse navbar-collapse" style="margin-left: 450px;">
	     	<div class="nav-item">
			  <a class="nav-link" href="./Home"><i class="fa fa-home" aria-hidden="true"></i> <strong>HOME</strong> </a>
			</div>
			
			<div class="nav-item">
			  <a class="nav-link" href="./Videos"><i class="fa fa-camera" aria-hidden="true"></i> <strong>VIDEOS</strong>  </a>
			</div>	
			
			<div class="nav-item">
               <a class="nav-link" href="./user/index" id="user"><i class="fa fa-id-card" aria-hidden="true"></i> <strong>USERS</strong> </a>
            </div>
			
			<div class="nav-item">
                <a class="nav-link" href="./Reports"><i class="fa fa-comments" aria-hidden="true"></i> <strong>REPORTS</strong>  </a>
             </div>
             <div class="nav-item">
                <a class="nav-link" href="./Logoff"><i class="fa fa-angle-double-right" aria-hidden="true"></i> <strong>Logoff</strong>  </a>
             </div>
	</div>
	   <a ><img src="image/anh.jpg" alt="" width="40px;" height="40px;" style="margin-right: 20px;"></a>
	   <a > <img  src="image/VN.jpg" alt="" width="45px;" height="40px;" > </a>
	</div>
</nav>