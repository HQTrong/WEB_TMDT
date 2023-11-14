
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <title> Mô tả sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<h5 style="color: red">${status}</h5>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="container-fluid" style="width:100%;">
        <div class="row">
            <div class="col-4">
                <a  href="home.jsp">Trang chủ/</a>
                <a href="cart.jsp" >Giỏ hàng</a>

            </div>
            <div class="col-8" >

            </div>
        </div>
    </div>
    <hr>

    <div class="container">
        <div class="row">
            <div class="col-4"><img src="${product.img}"  style=" width:350px; height: 350px; max-height: 350px ;overflow:hidden;"></div>
            <div class="col-8" style="padding-right: -10%; font-family: 'Times New Roman'; font-size: 20px;">
                <h2>Thông tin chi tiết</h2>
                <p>Tên sản phẩm:
                    ${product.name}
                </p>
                <p>Giá:
                    ${product.price} đồng
                </p>
                <p>
                    - ${product.description}
                </p>

            </div>
        </div>
    </div>
</div>
</body>
</html>