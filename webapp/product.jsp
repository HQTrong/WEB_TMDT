<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html data-n-head-ssr lang="vi" data-n-head="%7B%22lang%22:%7B%22ssr%22:%22vi%22%7D%7D">
<head>
    <title>Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <style>
        #submenu {
            position: absolute;
            top: 100%;
            left: 0;
            opacity: 0;
            visibility: hidden;
            z-index: 1;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            border-radius: 10px;
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

    </style>
</head>
<body>
<div class="container" style="font-family: 'DejaVu Serif'; font-size: 50px;">
    <nav class="navbar " style="background-color:white ;">
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
                        <form>
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
</div>
<div class="container-fluid" style="width:85%;">
    <div class="row">
        <div class="col">
            <a href="home.jsp">Trang chủ/</a>
            <a href="show">Menu</a>
        </div>
        <div class="col">
        </div>
        <div class="col">
        </div>
            <div class="col">
                <form class="d-flex" action="show" method="post">
                    <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="tensp" style="max-width: 200px;padding-right: 10px;">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
    </div>
</div>
<br>
<center>
    <a href="show" class="btn btn-primary">ALL</a>
    <c:forEach items="${categoryList}" var="c">
    <a href="category?Id=${c.id}" class="btn btn-info">${c.typeName}</a>
    </c:forEach>
</center>
<br>

    <form action="cart" method="get">
    <div class="container">
        <div class="d-flex flex-wrap">
            <div class="container">
                <div class="d-flex flex-wrap">
                    <c:forEach items="${list}" var="sp">
                        <div class="col-4">
                            <div class="card" style="width: 95%; margin-bottom: 30px;">
                                <img src="${sp.img}" alt="${sp.name}" style="max-height: 200px ;overflow:hidden;">
                                <div class="card-body" style="background-color: gainsboro;">
                                    <center>
                                        <a href="mota?Id=${sp.id}" style="text-decoration: none; font-size: 30px;"><b>${sp.name}</b></a>
                                        <p style="font-size: 25px; color:red;"><b>${sp.price} đồng</b></p>
                                        <button type="button" class="btn btn-warning" onclick="showNotification('${sessionScope.user}','${sp.name}','${sp.price}','${sp.img}')">
                                            <a href="#" style="color: white;text-decoration: none">Thêm vào giỏ hàng</a>
                                        </button>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>

            <script>
                function showNotification(user, ten, gia, anh) {
                    if (user == null || user.trim() === "") { // Kiểm tra nếu user là null hoặc chuỗi rỗng
                        alert("Đăng nhập trước khi mua hàng");
                    } else {
                        alert("Sản phẩm đã được thêm vào giỏ hàng!");
                        addToCart(ten, gia, anh);
                    }
                }
                const btnList = document.querySelectorAll("button");
                btnList.forEach(function (button, index) {
                    button.addEventListener("click", function (event) {
                        var product = event.target.closest(".card");
                        var image = product.querySelector("img").src;
                        var name = product.querySelector("a").innerText;
                        var price = product.querySelector("p").innerText;
                    });
                });
                function addToCart(name, price, image) {
                    // Truyền thông tin qua URL
                    window.location.href = "cartproduct?name=" + encodeURIComponent(name) + "&price=" + encodeURIComponent(price) + "&image=" + encodeURIComponent(image)+"&username=" +"${sessionScope.user}";
                }
            </script>
        </div>
    </div>
    </form>
</div>
</body>

</html>