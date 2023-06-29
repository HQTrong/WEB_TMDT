<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 6/24/2023
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý đơn hàng</title>
    <style>

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
    <h1>ĐƠN HÀNG ĐÃ BÁN</h1>
    <table style="margin-top: 20px;">
        <tr>
            <th>ID đơn hàng</th>
            <th>Tổng tiền</th>
        </tr>
        <c:choose>
        <c:when test="${list!=null}">
        <c:forEach items="${list}" var="sp" >
            <c:set var="total" value="${total + sp.thanhTien}" />
            <tr>
                <td>${sp.id}</td>
                <td>${sp.thanhTien}</td>
                <td>
                    <button style="background-color: blue;"><a href="detailorder?Id=${sp.id}" style="color: white; text-decoration: none;"><b>Chi tiết</b></a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </c:when>
        </c:choose>
        <tr>

        </tr>
    </table>
    <p style="font-size: 30px;"><b>Tổng tiền: ${total} đồng</b></p>
</center>
<br>
<a href="login" style="margin-left: 700px; font-size: 25px; color: blue;"> Trang Admin <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-square-fill" viewBox="0 0 16 16">
    <path d="M16 14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12zm-4.5-6.5H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5a.5.5 0 0 0 0-1z"/>
</svg> </a>


</body>

</html>

