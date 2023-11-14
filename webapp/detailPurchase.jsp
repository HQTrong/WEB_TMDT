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

</head>

<body>

<div class="container">
    <%@ include file="header.jsp" %>
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
