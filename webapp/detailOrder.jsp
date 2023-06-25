<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 6/24/2023
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
    <style>
        a{
            text-decoration: none;
            color: white;
        }

        button {
            border-radius: 15px 15px 15px 15px;
        }

        table, th, td {
            border: 1px solid black;
            /*border-collapse: collapse;*/
        }
        label
        {
            font-weight: 600;
        }
    </style>
    <script type="text/javascript"></script>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<center style="padding-top: 30px">
    <h1>CHI TIẾT ĐƠN HÀNG ${id}</h1>
    <table style="margin-top: 20px;">
        <tr>
            <th>ID giỏ hàng</th>
            <th>ID đơn hàng</th>
            <th>ID sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Giá sản phẩm</th>
            <th>Số lượng</th>
        </tr>
        <c:choose>
        <c:when test="${list!=null}">
        <c:forEach items="${list}" var="sp" >
            <c:set var="total" value="${total + sp.giasp*sp.soLuong}" />
            <tr>
                <td>${sp.idCart}</td>
                <td>${sp.idDonHang}</td>
                <td>${sp.idProduct}</td>
                <td>${sp.tensp}</td>
                <td>${sp.giasp}</td>
                <td>${sp.soLuong}</td>
            </tr>
        </c:forEach>
        </c:when>
        </c:choose>
    </table>

    <p style="font-size: 30px;"><b>Số tiền đã thanh toán: ${total} đồng</b></p>
</center>

</body>


</html>