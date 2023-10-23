
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

  <title> Giỏ hàng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <style>
      #submenu {
        position: absolute;
        top: 100%;
        left: 0;
        opacity: 0;
        visibility: hidden;
        z-index: 1;
        background-color: #fff;
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
        border-radius: 10px;
        background: gainsboro;
      }

      #menu li {
        position: relative;
        display: inline-block;
        margin-right: 10px;
      }

      #menu li:hover #submenu {
        opacity: 1;
        visibility: visible;
      }
      #userWelcomeLink {
        height: 45px;
        display: inline-flex;
        align-items: center;
        justify-content: center;
      }
      #menu a{
        text-decoration: none;
      }
      .rounded-image {
        width: 130px;
        height: 130px;
        border-radius: 50%;
        object-fit: cover;
      }
    </style>
</head>
<body>
<h5 style="color: red">${status}</h5>
<div class="container">
  <nav class="navbar " style="background-color:white ;">

    <div class="container">
      <a class="navbar-brand">

        <img src="Image/logo.jpg"  class="rounded-image" alt="Logo">

      </a>
      <form class="d-flex" style="font-family: 'DejaVu Sans';font-size: 20px">
        <div id="header_home">
          <ul class="nav justify-content-center">

            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="home.jsp">Trang chủ</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="show">Sản phẩm</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="contact.jsp" tabindex="-1" aria-disabled="true">Liên hệ</a>
            </li>
            <form >

              <div class="btn-group">
                <c:choose>
                  <c:when test="${not empty sessionScope.user}">
                    <ul id="menu">
                      <li>
                        <a href="login.jsp" style="font-size: 20px;" class="btn btn-primary" aria-current="page" id="userWelcomeLink">Welcome, ${sessionScope.user}!</a>
                        <ul id="submenu">
                          <li><a href="updateAccount">Tài khoản</a></li>
                          <li><a href="purchase?user=${sessionScope.user}">Đơn mua</a></li>
                          <li><a href="logout">Đăng xuất</a></li>
                        </ul>
                      </li>
                    </ul>
                  </c:when>
                  <c:otherwise>
                    <a href="login.jsp" style="font-size: 20px;" class="btn btn-primary" aria-current="page">Đăng nhập</a>
                  </c:otherwise>
                </c:choose> &nbsp;
                <a href="cart.jsp" style="font-size: 20px;" class="btn btn-success" > <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                </svg> Giỏ hàng</a>
              </div>
            </form>
          </ul>
        </div>
      </form>
    </div>
  </nav>
  <div class="container-fluid" style="width:100%;">
    <div class="row">
      <div class="col-4">
        <a  href="home.jsp">Trang chủ/</a>
        <a href="cart.jsp" >Giỏ hàng</a>

      </div>
      <div class="col-8" >
        <label>Người nhận</label>
        <input type="text" name="fullname">
      <label>Địện thoại</label>
        <input type="text" name="phone">
      <label>Địa chỉ</label>
        <input type="text" name="address">
      </div>
    </div>
  </div>
  <hr>

  <div class="container">
    <div class="row row-cols-2 row-cols-lg-3">
      <div class="col-4 col-lg-2"></div>
      <div class="col-4 col-lg-2"><h5 class="text-center">Tên sản phẩm</h5></div>
      <div class="col-4 col-lg-2"><h5 class="text-center">Giá</h5></div>
      <div class="col-4 col-lg-2"><h5 class="text-center">Số lượng</h5></div>
      <div class="col-4 col-lg-2"><h5 class="text-center">Thành tiền</h5></div>
    </div>
    <hr>
    <c:set var="tongTien" value="0" />
    <c:set var="tien" value="0" />
    <c:forEach items="${cartItems}" var="sp" varStatus="status">
      <div class="row row-cols-2 row-cols-lg-3" id="row${status.index}">
        <div class="col-4 col-lg-2 text-center"><img src="${sp.img}" style="height:100px; width: 100px;"></div>
        <div class="col-4 col-lg-2 text-center"><p><b>${sp.name}</b></p></div>
        <div class="col-4 col-lg-2 text-center"><p id="gia${status.index}"><b>${sp.price}</b></p></div>
        <div class="col-4 col-lg-2 text-center">
          <input type="number" id="quantity${status.index}" value="${sp.quantity}" min="0" onchange="updateTotal('${status.index}','${sp.price}')" style="width: 75px">
        </div>
        <div class="col-4 col-lg-2 text-center"><p id="total${status.index}"><b>${sp.price*sp.quantity}đồng</b></p></div>
      </div>
      <div class="w-100"></div> <!-- Xuống dòng mới -->
      <c:set var="tongTien" value="${tongTien + sp.price}" />
      <br>
    </c:forEach>
    <span id ="quantity${status.index}" style="display: none" ></span>
  </div>
<br>
  <div class="container">
    <div class="row row-cols-2 row-cols-lg-3">
      <div class="col-4 col-lg-2">
        <button type="button" class="btn btn-warning"><a href="show" style="text-decoration: none; color:white">Tiếp tục mua hàng</a></button>
      </div>
      <div class="col-4 col-lg-2">
      </div>
      <div class="col-4 col-lg-2"></div>
      <div class="col-4 col-lg-2"></div>
      <div class="col-4 col-lg-2">
        <p style="font-size: 15px;">
          <b>Tổng tiền: <span id="tongTien">${tongTien} đồng</span></b>
        </p>
      </div>
      <div class="col-4 col-lg-2">
        <a href="cartproduct"  style="color:red;">Xóa tất cả</a> &nbsp
        <a href="donhang" id="donHangLink" class="btn btn-success" style="text-decoration: none; color: white" onclick="showNotification('${sessionScope.user}', ${tongTien})">
          Mua hàng
        </a>
      </div>
    </div>
  </div>
  <script>

    function showNotification(user,tongTien) {
      const fullnameInput = document.querySelector('input[name="fullname"]');
      const fullname = fullnameInput.value;

      // Lấy giá trị từ trường input Điện thoại
      const phoneInput = document.querySelector('input[name="phone"]');
      const phone = phoneInput.value;

      // Lấy giá trị từ trường input Địa chỉ
      const addressInput = document.querySelector('input[name="address"]');
      const address = addressInput.value;
      if (user == null || user.trim() === "") {
        alert("Đăng nhập trước khi mua hàng");
      } else if(tongTien==0) {
        alert("Vui lòng chọn sản phẩm cần mua");
      }
      else if(address=="" || phone=="" || fullname=="")
      {
        alert("Vui lòng điền đầy đủ thông tin giao hàng");
      }
      else
      {
        alert("Mua hàng thành công");
        calculateTotal();
      }
    }
    function updateTotal(index, gia) {
      const quantity = document.getElementById("quantity" + index).value;
      const total = quantity * gia;
      document.getElementById("total" + index).innerHTML = "<b>" + total + " đồng</b>";
      if (quantity == 0) {
        const row = document.getElementById("row" + index);
        row.style.display = "none";
      }
        calculateTotal();
    }

    function calculateTotal() {
      let tongTien = 0;
      let soLuong = [];
      const quantityFields = document.querySelectorAll('input[type="number"]');
      const giaElements = document.querySelectorAll('p[id^="gia"]');

      for (let i = 0; i < quantityFields.length; i++) {
        const quantity = parseInt(quantityFields[i].value);
        const gia = parseInt(giaElements[i].innerText);
        tongTien += quantity * gia;
        soLuong.push(quantity);
      }
      document.getElementById("tongTien").innerText = tongTien + " đồng";
      document.getElementById("quantity").innerText = soLuong.join(", ");

      updateDonHangLink(tongTien, soLuong);
    }

    function updateDonHangLink(tongTien, soLuong) {
      const donHangLink = document.getElementById("donHangLink");
      const quantityParams = soLuong.join(",");
      const fullnameInput = document.querySelector('input[name="fullname"]');
      const fullname = fullnameInput.value;

      // Lấy giá trị từ trường input Điện thoại
      const phoneInput = document.querySelector('input[name="phone"]');
      const phone = phoneInput.value;

      // Lấy giá trị từ trường input Địa chỉ
      const addressInput = document.querySelector('input[name="address"]');
      const address = addressInput.value;
      const href = "donhang?tongTien=" + tongTien + "&username=" + "${sessionScope.user}" + "&soLuong=" + quantityParams + "&fullname=" + fullname + "&address=" + address + "&phone=" + phone;

      donHangLink.setAttribute("href", href);
    }


    // Lắng nghe sự kiện onchange của các trường số lượng
    const quantityFields = document.querySelectorAll('input[type="number"]');
    quantityFields.forEach(function (field, index) {
      field.addEventListener("change", function () {
        const gia = parseInt(document.getElementById("gia" + index).innerText);
        updateTotal(index, gia);
      });
    });
    // Cập nhật đường dẫn "Mua hàng" khi trang được tải
    calculateTotal();
  </script>
    <hr>
        <script>

        </script>
    </div>
  </div>
    </div>
  </div>
</div>
</body>
</html>