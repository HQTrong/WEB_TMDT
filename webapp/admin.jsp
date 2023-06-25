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
    <h1>CHÀO MỪNG BẠN ĐẾN VỚI TRANG ADMIN</h1>
    <h3>${status}</h3>
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
    <table style="margin-top: 20px;">
        <tr>
            <th>ID sản phẩm</th>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
        </tr>
        <c:choose>
        <c:when test="${list!=null}">
        <c:forEach items="${list}" var="sp" >
            <tr>
                <td>${sp.id}</td>
                <td>${sp.anh}</td>
                <td>${sp.ten}</td>
                <td>${sp.gia}</td>
                <td>
                    <button style="background-color: blue;"><a href="update?Id=${sp.id}"><b>Update</b></a>
                    </button>
                    <button style="background-color: red;"><a href="#" onclick="ShowMess('${sp.id}')"><b>Delete</b></a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:when test="${product!=null}">
        <tr>
            <td>${product.id}</td>
            <td>${product.anh}</td>
            <td>${product.ten}</td>
            <td>${product.gia}</td>
            <td>
                <button style="background-color: blue;"><a
                        href="update?Id=${product.id}"><b>Update</b></a></button>
                <button style="background-color: red;"><a href="#" onclick="ShowMess('${product.id}')"><b>Delete</b></a>
                </button>
            </td>
        </tr>

        </table>
    </c:when>
    <c:otherwise>
    </c:otherwise>
    </c:choose>

</center>

</body>
<script type="text/javascript">
    function ShowMess(id) {
        var option = confirm('Bạn có đồng ý xóa sản phẩm!!');
        if (option === true) {
            window.location.href = 'remove?Id=' + id;
        }
    }

</script>

</html>
