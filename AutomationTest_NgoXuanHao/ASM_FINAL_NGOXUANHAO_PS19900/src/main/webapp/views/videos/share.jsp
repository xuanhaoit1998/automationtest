<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="offset-3 col-6" style="margin-top: 150px;">
                  <form action="${root}sendmail?v=${param.v}" method="post">
                  <input type="hidden" value="${param.v}" name='id'/>
                     <div class="card">
                         <div class="card-header"> <strong>Send video to your friend</strong></div>
                         <div class="card-body">
                          <jsp:include page="/common/inform.jsp"></jsp:include>
                         <div class="row">
                         <div class="col">
                          <div class="form-group">
                              <label for="email"> <strong>Your Friend'semail:</strong></label>
                              <input type="email" class="form-control" id="email" name="email" placeholder="Emails" required="required">
                              <small id="emailhelpId" style="color: red;">Vui lòng nhập Email</small>
                            </div>
                            
                         </div>
                         </div>
                           
                         </div>
                         <div class="card-footer">
                             <button type="submit" class="btn btn-success"> <strong>Send</strong></button>
                         </div>
                     </div>
                  </form>
              </div>