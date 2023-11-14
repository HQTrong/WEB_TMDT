
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
</head>
<body>
<h5 style="color: red">${status}</h5>
<div class="container">
  <%@ include file="header.jsp" %>
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
      else if(phone.length != 10)
      {
        alert("Số điện thoại không hợp lệ");
      }else
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
    </div>
</body>
</html>