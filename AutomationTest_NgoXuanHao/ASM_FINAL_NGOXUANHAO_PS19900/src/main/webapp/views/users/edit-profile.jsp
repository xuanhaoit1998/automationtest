<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    


  <div class="col-8 offset-2">
                <form action="EditProfile" method="post">
                     <div class="card">
                         <div class="card-header">
                            <b> <strong>Edit Profile</strong> </b>
                         </div>
                         <div class="card-body">
                         <jsp:include page="/common/inform.jsp"></jsp:include>
                             <div class="row">
                                 <div class="col">
                                    <div class="form-group">
                                        <label for="username"> <strong>Username</strong> </label>
                                         <input name="id" value="${user.id}" class="form-control" placeholder="Username" type="text" required="required">
                                        <small id="usernamehelpId" style="color: red;">Vui lòng nhập Username</small> 
                                      </div>
                                      <div class="form-group">
                                        <label for=""> <strong>Fullname</strong> </label>
                                         <input name="fullname" value="${user.fullname}"  class="form-control" placeholder="Fullname" type="text" required="required">                
                                        <small id="fullnamehelpId" style="color: red;">Vui lòng nhập Fullname </small>
                                      </div>
                                       <div class="form-group">
                                        <label for=""> <strong>Email</strong> </label>
                                         <input name="email" value="${user.email}" class="form-control" placeholder="Email" type="email" required="required">
                                        <small id="emailhelpId" style="color: red;">Vui lòng nhập Emai</small>
                                      </div>
                                 </div>
                             </div>
                         </div>
                         <div class="card-footer text-muted">
                             <button class="btn btn-success">Update</button>
                         </div>
                     </div>
                </form>
            </div>
  
