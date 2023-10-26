<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Chi tiết đơn hàng đã mua</title>
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

    </style>
</head>

<body>

<div class="container">
    <nav class="navbar " style="background-color:white;">

        <div class="container">
            <a class="navbar-brand">

                <img src="Image/logo.jpg" style="width:130px; height:100px;" class="img-fluid" alt="Logo">

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
                                                    <li><a href="purchase?user=${sessionScope.user}">Đơn mua</a></li>
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
                                <a href="cart.jsp" class="btn btn-success" style="font-size: 20px;" > <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg> Giỏ hàng</a>

                            </div>

                        </form>

                    </ul>
                </div>

            </form>
        </div>
    </nav>
    <h3 class="text" style="text-align:center;  color:red;">Chi tiết các đơn hàng đã mua</h3>
    <br>
    <center>
        <div class="container">
            <c:forEach items="${purchase}" var="sp" varStatus="status">
                    <h4>Người nhận:${sp.fullName} --- Địa chỉ:${sp.address} --- Điện thoại:${sp.phone}</h4>
                    <br>
                <div class="row row-cols-2 row-cols-lg-3">
                    <c:forEach items="${sp.listPurchase}" var="p" varStatus="status">
                        <div class="col-4 col-lg-2 text-center">
                            <img src="${p.img}" style="height:100px; width: 100px;">
                        </div>
                        <div class="col-4 col-lg-2 text-center">
                            <p id="myField"><b>${p.productName}</b></p>
                        </div>
                        <div class="col-4 col-lg-2 text-center">
                            <p><b>SL: x${p.quantity}</b></p>
                        </div>
                        <div class="col-4 col-lg-2 text-center">
                            <p><b>Giá bán: ${p.price}</b></p>
                        </div>
                        <div class="col-4 col-lg-2 text-center">
                            <p><b>Thành tiền: ${p.price * p.quantity}</b></p>
                        </div>
                        <div class="w-100"></div>
                        <br>
                    </c:forEach>
                </div>
                <div class="container">
                    <div class="row row-cols-2 row-cols-lg-3">
                        <div class="col-4 col-lg-2"></div>
                        <div class="col-4 col-lg-2"></div>
                        <div class="col-4 col-lg-2"></div>
                        <div class="col-4 col-lg-2"></div>
                        <div class="col-4 col-lg-2">
                            <p style="font-size: 20px;">
                                <b>Tổng tiền: ${sp.total}</b>
                            </p>
                        </div>
                        <div class="col-4 col-lg-2"></div>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </div>

    </center>
</div>
</body>
</html>
