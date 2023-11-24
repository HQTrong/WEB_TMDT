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
</head>
<body>
<div class="container" style="font-family: 'DejaVu Serif';">
    <%@ include file="header.jsp" %>
    <div class="container-fluid" style="width:100%;">
        <div class="row">
            <div class="col-9">
                <a href="home.jsp">Trang chủ/</a>
                <a href="show">Menu</a>
            </div>
            <div class="col-3">
                <form class="d-flex" action="show" method="post">
                    <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="tensp" style="max-width: 200px;">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
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
                        window.location.href ="cart";
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
