<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title> Cửa hàng của Trọng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>

<body>

<div class="container-fluid">
    <nav class="navbar " style="background-color:white ;">

        <div class="container-fluid">
            <a class="navbar-brand">

                <img src="Image/logo.jpg" style="width:130px; height:100px;" class="img-fluid" alt="Logo">

            </a>

            <form class="d-flex" style="font-family: 'DejaVu Sans';font-size: 18px">
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
                                        <a href="login.jsp" class="btn btn-primary" aria-current="page">Welcome, ${sessionScope.user}!</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="login.jsp" class="btn btn-primary" aria-current="page">Đăng nhập</a>
                                    </c:otherwise>
                                </c:choose>
                                &nbsp;
                                <a href="cart.jsp" class="btn btn-success" > <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg> Giỏ hàng</a>

                            </div>

                        </form>

                    </ul>
                </div>

            </form>
        </div>
    </nav>
    <h3 class="text" style="text-align:center;  color:red;">Chào mừng đến với tiệm của Trọng</h3>
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="Image/slide1.jpg" style="height:600px" class="d-block w-100" alt="slide1">
            </div>
            <div class="carousel-item">
                <img src="Image/slide2.jpg" style="height:600px" class="d-block w-100" alt="slide2">
            </div>
            <div class="carousel-item">
                <img src="Image/slide3.jpg" style="height:600px" class="d-block w-100" alt="slide3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

</div>
</body>
</html>
