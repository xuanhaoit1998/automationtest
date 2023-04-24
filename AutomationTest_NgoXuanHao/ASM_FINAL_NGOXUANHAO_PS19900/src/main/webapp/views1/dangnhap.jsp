<!doctype html>
<html <%@ page pageEncoding="utf-8"%>>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <main class="container">
        <div class="row">
            <div class="offset-4 col-4">
                <form action="" method="post">
                    <div class="card">
                        <div class="card-header">
                            <b>Login</b>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                              <label for="username">Username</label>
                              <input type="text" class="form-control" name="taikhoan" id="username" aria-describedby="usernameHId" placeholder="Input username"> <!--usernameHelpId-->
                              <small id="usernameHId" class="form-text text-muted" value"${taikhoan}">${thongbaoloi}</small>
                            </div>
                            <div class="form-group">
                              <label for="password">Password</label>
                              <input type="text" class="form-control" name="matkhau" id="password" aria-describedby="passwordHId" placeholder="Input password">
                              <small id="passwordHId" class="form-text text-muted" value"${matkhau}">${thongbaoloi}</small>
                            </div>
                            <div class="form-check form-check-inline">
                                <label><Input type="radio" class="form-check-input" name="remember"></Input>Remember me</label>
                            </div>
                        </div>
                        <div class="card-footer text-muted">
                            <button class="btn btn-success">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>