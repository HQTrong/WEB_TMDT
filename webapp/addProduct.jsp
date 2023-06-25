<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 6/24/2023
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ADD PRODUCT</title>
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
        }

        h2 {
            padding-top: 80px;
            text-align: center;
            font-size: 50px;
        }
        h3{
            color: red;
        }
    </style>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<h2>Thêm sản phẩm</h2>
<form action="add" method="post">
    <div class="add">

        <label>Tên sản phẩm: </label>
        <input type="text" placeholder="" name="tensp"/>

        <label>Giá sản phẩm: </label>
        <input type="text" name="giasp">

        <label> Ảnh: </label>
        <input type="text" name="anh">

        <label>Mô tả: </label>
        <input type="text" name="mota">
  <br>
        <button style="color: white; background-color: blue; width: 100px; height: 30px"><b>ADD</b></button>
    </div>
    <center>
        <h3>${status}</h3>
    </center>
</form>
</body>
</html>
