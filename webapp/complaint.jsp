<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 6/25/2023
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Góp ý từ khách hàng</title>
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
    <h1>GÓP Ý CỦA KHÁCH HÀNG</h1>
    <table style="margin-top: 20px;">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Điện thoại</th>
            <th>Góp ý</th>
        </tr>
        <c:choose>
        <c:when test="${list!=null}">
        <c:forEach items="${list}" var="sp" >
            <tr>
                <td>${sp.id}</td>
                <td>${sp.username}</td>
                <td>${sp.phone}</td>
                <td>${sp.complaint}</td>
            </tr>
        </c:forEach>
    </table>
    </table>
    </c:when>
    </c:choose>
</center>

</body>

</html>