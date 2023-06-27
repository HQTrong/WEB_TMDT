<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Đăng ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body style="background-color: gainsboro;">
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <img src="Image/register.jpg" style="height:715px;">
        </div>
        <div class="col-sm-8" style="background-color: white; padding-top: 80px;">
            <br><br><br>
            <h1 style="text-align: center; font-size: 40px;">ĐĂNG KÝ</h1>
            <h5 style="color: red">${status}</h5>
            <form class="row g-3" action="register" method="post">

                <div class="col-6">
                    <label for="inputAddress" class="form-label">Tên tài khoản</label>
                    <input type="text" class="form-control" id="inputAddress" name="username" >
                </div>
                <div class="col-md-6">
                    <label for="inputPassword4" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="inputPassword4" name = "pass">
                </div>
                <div class="col-6">
                    <label for="inputAddress2" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputAddress2" name ="email">
                </div>
                <br>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Đăng ký</button>
                    <button type="submit" class="btn btn-danger"> <a href="home.jsp" style="color: white; text-decoration: none">Thoát</a></button>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>