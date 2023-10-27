<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title> Quên Mật Khẩu </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <style>
        #submenu {
            position: absolute;
            top: 100%;
            left: 0;
            opacity: 0;
            visibility: hidden;
            z-index: 1;
            background-color: #fff;
            padding: 10px;
            text-align: center;
            border-radius: 10px;
            border: 1px solid #ccc;
            background: gainsboro;

        }

        #menu li {
            position: relative;
            display: inline-block;
            margin-right: 10px;
        }

        #menu li:hover #submenu {
            opacity: 1;
            visibility: visible;
        }
        #userWelcomeLink {
            height: 45px;
            display: inline-flex;
            align-items: center;
            justify-content: center;
        }
        #menu a{
            text-decoration: none;
        }
        .rounded-image {
            width: 130px;
            height: 130px;
            border-radius: 50%;
            object-fit: cover;
        }
        .eye {
            position: absolute;
            right: 15px;
            top: -30%;
            transform: translateX(-2320%);
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

<body style="background-color: lavenderblush">

<div class="container">
    <nav class="navbar ">

        <div class="container">
            <a class="navbar-brand">

                <img src="Image/logo.jpg" class="rounded-image" alt="Logo">

            </a>

            <form class="d-flex" style="font-family: 'DejaVu Sans';font-size: 20px">
                <div id="header_home">
                    <ul class="nav justify-content-center">

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="home.jsp">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="show">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="contact.jsp" tabindex="-1" aria-disabled="true">Liên hệ</a>
                        </li>
                        <form >

                            <div class="btn-group">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.user}">
                                        <ul id="menu">
                                            <li>
                                                <a href="login.jsp" style="font-size: 20px;" class="btn btn-primary" aria-current="page" id="userWelcomeLink">Welcome, ${sessionScope.user}!</a>
                                                <ul id="submenu">
                                                    <li><a href="updateAccount">Tài khoản</a></li>
                                                    <li><a href="purchase?user=${sessionScope.user}" >Đơn mua</a></li>
                                                    <li><a href="logout">Đăng xuất</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="login.jsp" style="font-size: 20px;" class="btn btn-primary" aria-current="page">Đăng nhập</a>
                                    </c:otherwise>
                                </c:choose>
                                &nbsp;
                                <a href="cart.jsp" style="font-size: 20px;" class="btn btn-success" > <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg> Giỏ hàng</a>

                            </div>

                        </form>

                    </ul>
                </div>

            </form>
        </div>
    </nav>
    <h4 class="text" style="text-align:center;  color:red;">Để quên mật khẩu vui lòng làm theo hướng dẫn bên dưới:</h4>
    <br>
    <br>
    <center>
        <h5>${status}</h5>
    </center>
    <br>
    <h5>Bước 1: Nhập địa chỉ email mà bạn đã đăng ký</h5>
    <form action="sendMail" method="post">
        <label>Email:</label>
        <input type="text" placeholder="" name="email" style="width: 300px"/>
        <button style="color: white; background-color: blue; width: 100px; height: 30px"><b>GỞI</b></button>
    </form>
    <br>
    <h5>Bước 2: Nhập mã OTP và mật khẩu mới</h5>
    <form action="verify" method="post" class="filed">
        <label>Email:</label>
        <input type="text" placeholder="" name="email" style="width: 300px"/>
        &ensp;
        <label>OTP:</label>
        <input type="text" placeholder="" name="otp" style="width: 100px"/>
        &ensp;
        <label>Mật khẩu mới:</label>
        <input type="text" placeholder="" name="pass" class="input" style="width: 200px"/>
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="eye eye-open hidden" viewBox="0 0 16 16">
            <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
            <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
        </svg>
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="eye eye-close" viewBox="0 0 16 16">
            <path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/>
            <path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/>
        </svg>
        <button style="color: white; background-color: blue; width:auto; height: 30px"><b>XÁC NHẬN</b></button>
    </form>
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
