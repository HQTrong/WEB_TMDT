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
        /*.table.table-blue{*/
        /*    background: lightsteelblue;*/
        /*}*/
        /*.table.table-striped tbody tr:nth-child(odd){*/
        /*    background: white;*/
        /*}*/
        table.table-striped tbody tr:hover{
            background: gainsboro;
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
    <button style="background-color: blue;"><a href="addtype"><b>Thêm loại SP</b></a></button>
    <table style="margin-top: 20px;" class ="table table-blue table-striped">
        <thead>
        <tr>
            <th>ID sản phẩm</th>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
        <c:when test="${list!=null}">
        <c:forEach items="${list}" var="sp" >
            <tr>
                <td>${sp.id}</td>
                <td>${sp.img}</td>
                <td>${sp.name}</td>
                <td>${sp.price}</td>
                <td>
                    <button style="background-color: blue;"><a href="update?Id=${sp.id}"><b>Update</b></a>
                    </button>
                    <button style="background-color: red;"><a href="#" onclick="ShowMess('${sp.id}')"><b>Delete</b></a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:when test="${product!=null}">
        <tr>
            <td>${product.id}</td>
            <td>${product.img}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <button style="background-color: blue;"><a
                        href="update?Id=${product.id}"><b>Update</b></a></button>
                <button style="background-color: red;"><a href="#" onclick="ShowMess('${product.id}')"><b>Delete</b></a>
                </button>
            </td>
        </tr>
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
    function ShowMess(id) {
        var option = confirm('Bạn có đồng ý xóa sản phẩm!!');
        if (option === true) {
            window.location.href = 'remove?Id=' + id;
        }
    }

</script>

</html>
