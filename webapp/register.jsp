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

    <style>
        .eye {
            position: absolute;
            right: 15px;
            top: 70%;
            transform: translateY(-50%);
            cursor: pointer;
            max-width: 20px;
        }

        .filed {
            position: relative;
        }

        .hidden {
            display: none;
        }
    </style>
</head>
<body style="background-color: gainsboro;">
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <img src="https://res.cloudinary.com/diey7k1oh/image/upload/v1698478705/Ecommerce/m4mfmj1hpeihdtawauni.jpg" style="height:715px;">
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
                <div class="col-md-6 filed">
                    <label for="inputPassword4" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control input" id="inputPassword4" name = "pass">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="eye eye-open hidden" viewBox="0 0 16 16">
                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                    </svg>
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="eye eye-close" viewBox="0 0 16 16">
                        <path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/>
                        <path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/>
                    </svg>
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
<script>
    const input = document.querySelector(".input");
    const eyeOpen = document.querySelector(".eye-open");
    const eyeClose = document.querySelector(".eye-close");
    eyeOpen.addEventListener("click", function() {
        eyeOpen.classList.add("hidden");
        eyeClose.classList.remove("hidden");
        input.setAttribute("type", "password");
    });
    eyeClose.addEventListener("click", function() {
        eyeOpen.classList.remove("hidden");
        eyeClose.classList.add("hidden");
        input.setAttribute("type", "text");
    });
</script>