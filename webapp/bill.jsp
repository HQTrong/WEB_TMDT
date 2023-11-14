<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <title> Hoa Don Thanh Toan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<script>
    document.addEventListener("DOMContentLoaded", function(event) {
        alert("Vui lòng click chuột phải và chọn 'In' hoặc nhấn tổ hợp 'Ctrl+P' để lưu hóa đơn!!")
    });
    function displayDate() {
        var dateElement = document.getElementById("date");
        var currentDate = new Date();
        var formattedDate = currentDate.toLocaleDateString();
        dateElement.innerHTML = formattedDate;
    }
</script>
<center>
    <h1>Thông tin hóa đơn - <span id="date"></span></h1>
    <script>
        displayDate();
    </script>
    <h3>Tên khách hàng: ${fullname}</h3>
    <h3>Địa chỉ: ${address}</h3>
    <h3>Điện thoại: ${phone}</h3>
</br>
</br>
<div class="container">
    <div class="row row-cols-2 row-cols-lg-3">
        <div class="col-4 col-lg-2"></div>
        <div class="col-4 col-lg-2"><h5 class="text-center">Tên sản phẩm</h5></div>
        <div class="col-4 col-lg-2"><h5 class="text-center">Giá</h5></div>
        <div class="col-4 col-lg-2"><h5 class="text-center">Số lượng</h5></div>
        <div class="col-4 col-lg-2"><h5 class="text-center">Thành tiền</h5></div>
    </div>
    <hr>
    <c:forEach items="${cart}" var="sp" varStatus="status">
        <div class="row row-cols-2 row-cols-lg-3" id="row${status.index}">
            <div class="col-4 col-lg-2 text-center"><img src="${sp.img}" style="height:100px; width: 100px;"></div>
            <div class="col-4 col-lg-2 text-center"><p><b>${sp.name}</b></p></div>
            <div class="col-4 col-lg-2 text-center"><p id="gia${status.index}"><b>${sp.price} đồng</b></p></div>
            <div class="col-4 col-lg-2 text-center">
    <p><b>${sp.quantity} </b></p>
            </div>
            <div class="col-4 col-lg-2 text-center">
               <p><b>${sp.quantity* sp.price} đồng</b></p>
            </div>
        </div>
        <div class="w-100"></div>
        <br>
    </c:forEach>

</div>
    </div>
</div>
    </br>
    <div class="container">
        <div class="row row-cols-2 row-cols-lg-3">
            <div class="col-4 col-lg-2">
                <a href="show" style="text-decoration: none">Tiếp tục mua hàng</a>
            </div>
            <div class="col-4 col-lg-2"></div>
            <div class="col-4 col-lg-2"></div>
            <div class="col-4 col-lg-2">
                <p style="font-size: 25px;">
                    <b>Tổng tiền:</b>
                </p>
            </div>
            <div class="col-4 col-lg-2">
                <p style="font-size: 25px;">
                    <b><span id="tongTien">${tongtien} đồng</span></b>
                </p>
            </div>
        </div>
    </div>
</center>
</body>
</html>
