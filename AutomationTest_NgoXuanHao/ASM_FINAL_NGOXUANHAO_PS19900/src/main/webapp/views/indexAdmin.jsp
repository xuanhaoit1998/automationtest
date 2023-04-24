<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINISTRATION TOOL</title>
<!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <base href="/asm/HomeAdmin"/> 
 <base href="/asm/"/>


</head>
<body >	
 <header style = "height : 300px ; background : red" 
  <h3><mark style="color: red;"></mark></h3>
  <marquee  width="1440px" class="fw-bold" scrollamount="10"> <h3 style="color: white;">Web lỏd của duy ăn cắp đủ thứ nên hơi dảk bủn lmao @@</h3> </marquee>>   
  <img src="image/background-header2.jpg" alt="" width="1475" height="300">		
  </header>
		 <jsp:include page="navAdmin.jsp"></jsp:include>	
	 <div class ="row" style="height: 680px; background-color: pink ; margin : 0;"> 
	 <jsp:include page="${VIEW}"></jsp:include>	</div>	
        <footer class="footer" style = "background-color:gray;">
        <div class="container">
            <div class="footer__top">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="footer__top__logo">
                            <a  href="./Videos" class="navbar-brand" href="#" style="color: white;">
                                <i class="fa fa-film mr-2"></i>
                          <strong>ADMINISTRATION TOOL</strong>      
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="footer__top__social">
                            <a style="color: white;" href="https://facebook.com"><i class="fa fa-facebook"></i></a>
                            <a style="color: white;" href="https://twitter.com"><i class="fa fa-twitter"></i></a>
                            <a style="color: white;" href="https://pinterest.com"><i class="fa fa-pinterest"></i></a>
                            <a style="color: white;" href="https://instagram.com"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer__option">
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="footer__option__item">
                            <h5>About us</h5>
                            <p>Formed in 2006 by Matt Hobbs and Cael Jones, Videoprah is an award-winning, full-service
                                production company specializing.</p>
                            <a style="color: white;" href="#" class="read__more">Read more <span class="arrow_right"></span></a>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3">
                        <div class="footer__option__item">
                            <h5>Who we are</h5>
                            <ul>
                                <li><a style="color: white;" href="#">Team</a></li>
                                <li><a style="color: white;" href="#">Carrers</a></li>
                                <li><a style="color: white;" href="#">Contact us</a></li>
                                <li><a style="color: white;" href="#">Locations</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3">
                        <div class="footer__option__item">
                            <h5>Our work</h5>
                            <ul>
                                <li><a style="color: white;" href="#">Feature</a></li>
                                <li><a style="color: white;" href="#">Latest</a></li>
                                <li><a style="color: white;" href="#">Browse Archive</a></li>
                                <li><a style="color: white;" href="#">Video for web</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="footer__option__item">
                            <h5>Newsletter</h5>
                            <p>Videoprah is an award-winning, full-service production company specializing.</p>
                            <form action="#">
                                <input type="text" placeholder="Email">
                                <button type="submit"><i class="fa fa-send"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer__copyright">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p class="footer__copyright__text">Copyright &copy; 2022
                            All rights reserved | This template is made with <i class="fa fa-heart-o"
                            aria-hidden="true"></i> by <a style="color: white;" href="https://www.facebook.com/profile.php?id=100009628209260" target="_blank">Nguyễn Thành Đức Duy</a>
                        </p>
                              <div class="col text-center border-top" style="">
				<strong>FPT Poly &copy; to 2022 is designed by <a href="https://www.facebook.com/profile.php?id=100009628209260" style="color: white;">IT17202</a></strong>
			<br><strong>Giảng Viên: <a style="color: white;"></a> </strong>
				<div class="">				
                           <strong>Liên hệ: <a style="color: red; font-size: 20px; margin-left: 10px;">0901470994  </a>                         
                            <a style="color: white; font-size: 20px; margin-left: 10px;" href="https://facebook.com"><i class="fa fa-facebook"></i></a>
                            <a style="color: white; font-size: 20px; margin-left: 10px;" href="https://twitter.com"><i class="fa fa-twitter"></i></a>
                            <a style="color: white; font-size: 20px; margin-left: 10px;" href="https://pinterest.com"><i class="fa fa-pinterest"></i></a>
                            <a style="color: white; font-size: 20px; margin-left: 10px;" href="https://instagram.com"><i class="fa fa-instagram"></i></a>
                             <a style="color: white; font-size: 20px; margin-left: 10px;" href="https://youtube.com/"><i class="fa fa-youtube"></i></a>
                            </strong>                      
                           </div>
	                 	</div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>