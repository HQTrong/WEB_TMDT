<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 6/27/2023
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ADD TYPE PRODUCT</title>
    <style>
        button {
            border-radius: 15px 15px 15px 15px;
        }

        table,
        th,
        td {
            border: 1px solid black;
            /*border-collapse: collapse;*/
        }

        .add {
            display: flex;
            justify-content: flex-start;
            flex-direction: column;
            padding-left: 45%;
        }

        label, input,option,select {
            height: 30px;
            width: 200px;
            text-align: left;
            font-size: 20px;
        }

        label {
            font-weight: 600;
        }

        button {
            height: 30px;
            width: 200px;
            text-align: center;
            font-size: 20px;
            margin-left: 50px;
        }

        h2 {
            padding-top: 80px;
            text-align: center;
            font-size: 50px;
        }
        h3{
            color: red;
        }
        a{
            margin-left: -300px;
            font-size: 25px;
            color: blue;
        }
    </style>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<h2>Thêm Loại SP</h2>
<form action="addtype" method="post">
    <div class="add">
        <label>Loại sản phẩm: </label>
        <input type="text" name="loaisp">
        <br>
        <button style="color: white; background-color: blue; width: 100px; height: 30px"><b>ADD</b></button>
    </div>
    <center>
        <h3>${status}</h3>

    <h3>Danh sách loại sản phẩm của cửa hàng</h3>
    <table style="margin-top: 20px;">
        <tr>
            <th>ID </th>
            <th>Loại sản phẩm</th>
        </tr>
        <c:forEach items="${list}" var="sp" >
            <tr>
                <td>${sp.id}</td>
                <td>${sp.loaisp}</td>
            </tr>
        </c:forEach>
    </center>
    </table>
</form>
<br>
<a href="login"> Trang Admin <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-square-fill" viewBox="0 0 16 16">
    <path d="M16 14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12zm-4.5-6.5H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5a.5.5 0 0 0 0-1z"/>
</svg> </a>
</body>
</html>