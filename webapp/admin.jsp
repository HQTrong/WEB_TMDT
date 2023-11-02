<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản Lý Cửa Hàng</title>
    <style>
        a{
            text-decoration: none;
            color: white;
        }

        button {
            border-radius: 15px 15px 15px 15px;
        }

        table, th, td {
            border: 2px solid black;
            border-collapse: collapse;
        }
        label
        {
            font-weight: 600;
        }
        thead{
            background: lightsteelblue;
        }
        table.table-striped tbody tr:hover{
            background: gainsboro;
        }

    </style>
    <script type="text/javascript"></script>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<center style="padding-top: 30px">
    <h1>CHÀO MỪNG BẠN ĐẾN VỚI TRANG ADMIN</h1>

    <form method="post" action="search">
        <label>ID sản phẩm: </label>
        <input type="text" placeholder="" name="product_id"/>
        <label>Tên sản phẩm: </label>
        <input type="tetx" placeholder="" name="name"/>
        <button style="background-color: greenyellow;"><b>Tìm kiếm</b></button>
    </form>
    <button style="background-color: blue;"><a href="add"><b>Thêm sản phẩm</b></a></button>
    <button style="background-color: blue;"><a href="customer"><b>Danh sách khách hàng</b></a></button>
    <button style="background-color: blue;"><a href="orderbuy"><b>Đơn hàng đã bán</b></a></button>
    <button style="background-color: blue;"><a href="complaint"><b>Góp ý của KH</b></a></button>
    <button style="background-color: blue;"><a href="addtype"><b>Thêm loại SP</b></a></button>
    <button style="background-color: blue;"><a href="updateshop"><b>Địa chỉ</b></a></button>
    <table style="margin-top: 20px;" class ="table table-blue table-striped">

        <tbody>
        <h3>${status}</h3>
        <c:choose>
        <c:when test="${listProduct!=null}">
        <h2>Danh sách sảm phẩm</h2>
        <thead>
        <tr>
            <th>ID</th>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${listProduct}" var="sp" >
            <tr>
                <td>${sp.id}</td>
                <td>${sp.img}</td>
                <td>${sp.name}</td>
                <td>${sp.price}</td>
                <td>
                    <button style="background-color: blue;"><a href="update?Id=${sp.id}"><b>Update</b></a>
                    </button>
                    <button style="background-color: red;"><a href="#" onclick="ShowMess('${sp.id},${sp.img}')"><b>Delete</b></a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:when test="${product!=null}">
        <h2>Danh sách sảm phẩm</h2>
        <thead>
        <tr>
            <th>ID</th>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th></th>
        </tr>
        </thead>
        <tr>
            <td>${product.id}</td>
            <td>${product.img}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <button style="background-color: blue;"><a
                        href="update?Id=${product.id}"><b>Update</b></a></button>
                <button style="background-color: red;"><a href="#" onclick="ShowMess('${product.id},${product.img}')"><b>Delete</b></a>
                </button>
            </td>
        </tr>
    </c:when>
        <c:when test="${listComplaint!=null}">
        <h2>Góp ý từ khách hàng</h2>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên đăng nhập</th>
            <th>Điện thoại</th>
            <th>Góp ý</th>
        </tr>
        </thead>
        <c:forEach items="${listComplaint}" var="com" >
        <tr>
            <td>${com.id}</td>
            <td>${com.username}</td>
            <td>${com.phone}</td>
            <td>${com.complaint}</td>
        </tr>
        </c:forEach>
        </c:when>

        <c:when test="${listCustomer!=null}">
        <h2>Danh sách khách hàng</h2>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Email</th>
        </tr>
        </thead>
        <c:forEach items="${listCustomer}" var="cus" >
        <tr>
            <td>${cus.id}</td>
            <td>${cus.user}</td>
            <td>${cus.pass}</td>
            <td>${cus.email}</td>
        </tr>
        </c:forEach>
        </c:when>

        <c:when test="${listOrder!=null}">
        <h2>Đơn hàng đã bán</h2>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tổng tiền</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${listOrder}" var="o" >
            <c:set var="total" value="${total + o.total}" />
        <tr>
            <td>${o.id}</td>
            <td>${o.total}</td>
            <td>
                <button style="background-color: blue;"><a href="detailorder?Id=${o.id}" style="color: white; text-decoration: none;"><b>Chi tiết</b></a>
                </button>
            </td>
        </tr>
        </c:forEach>
        <p style="font-size: 20px;"><b>Tổng tiền: ${total} đồng</b></p>
        </c:when>

        <c:when test="${listDetailOrder!=null}">
        <h2>Chi tiết đơn hàng ${id}</h2>
        <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Giá bán</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        </thead>
        <c:forEach items="${listDetailOrder}" var="sp" >
            <c:set var="total" value="${total + sp.price*sp.quantity}" />
        <tr>
            <td>${sp.name}</td>
            <td>${sp.price}</td>
            <td>${sp.quantity}</td>
            <td>${sp.quantity * sp.price}</td>
        </tr>
        </c:forEach>
        <p style="font-size: 20px;"><b>Tên người nhận: ${fullname} --- Số điện thoại: ${phone} --- Địa chỉ: ${address}</b></p>
        <p style="font-size: 20px;"><b>Số tiền đã thanh toán: ${total} đồng</b></p>
        </c:when>
        <c:when test="${shop!=null}">
        <h2>Cập nhật địa chỉ cửa hàng</h2>
        <form action="shop" method="post">

            <thead>
            <tr>
                <th>
                    <label  class="form-label">ID</label>
                </th>
                <th>
                    <label  class="form-label">Địa chỉ</label>
                </th>
                <th>
                    <label  class="form-label">Thời gian mở cửa</label>
                </th>

                <th>
                   <label  class="form-label">Ngày mở cửa</label>
                </th>
            </tr>
            </thead>
            <tr >
                <td><input type="text" class="form-label"  name="id" value="${shop.id}" style="border: none; width: 20px; " ></td>
                <td><input type="text" class="form-label"  name="address" value="${shop.address}" style="border: none; width: 500px; "></td>
                <td><input type="text" class="form-label" name="time" value="${shop.time}" style="border: none; width: 130px; "></td>
                <td><input type="text"  class="form-label" name="day" value="${shop.day}"  style="border: none; width: 90px; "></td>
                <td><button style="color: white; background-color: blue; width:auto; height: auto"><b>UPDATE</b></button></td>
            </tr>

        </form>
        </c:when>
    <c:otherwise>
    </c:otherwise>
    </c:choose>
</center>
</tbody>
</table>
<br>
<a href="login.jsp" style="font-size: 25px; margin-left: 0px; color: blue"> Login <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-square-fill" viewBox="0 0 16 16">
    <path d="M16 14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12zm-4.5-6.5H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5a.5.5 0 0 0 0-1z"/>
</svg> </a>
</body>
<script type="text/javascript">
    function ShowMess(id,img) {
        var option = confirm('Bạn có đồng ý xóa sản phẩm!!');
        if (option === true) {
            window.location.href = "remove?Id=" + id + "&img=" + img;
        }
    }

</script>

</html>
