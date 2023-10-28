<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <title>Contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>


</head>

<body style="background-color:gainsboro">

<div class="container" style="width:100%;">
    <div style="margin-left:27px; padding-top:10px; ">
        <a href="home.jsp">Trang chủ/</a>
        <a href="shop">Liên hệ</a>
    </div>

    <form action="contact" method="get">
    <div class="container">
        <!-- The div element where the map will be displayed -->
        <div id="googleMap" style="width: 100%; height: 400px;"></div>

        <!-- Include the Google Maps JavaScript API with the correct libraries parameter -->
        <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyD5-rVNAlQoow6sr6hM4U5lhIYcU6zjUT4"></script>

        <script>
            // Initialize the map and add a marker
            function initMap() {
                var geocoder = new google.maps.Geocoder();
                var address = '${shop.address}';

                geocoder.geocode({ 'address': address }, function (results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        var mapOptions = {
                            center: results[0].geometry.location, // Use the first result's coordinates
                            zoom: 15, // Adjust the zoom level as needed
                        };

                        var map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);

                        // Add a marker at the geocoded location
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location,
                            title: 'Cửa hàng của chúng tôi' // Customize the marker title as needed
                        });
                    } else {
                        console.error("Geocoding was not successful for the following reason: " + status);
                    }
                });
            }

            // Call the initMap function when the page has loaded
            initMap();
        </script>
<%--        <img src="Image/map.jpg" style="height:450px; width:1255px; margin-left:25px; margin-top:30px; ">--%>

        <div class="row">
            <div class="col-sm-4">
                <br>
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                     class="bi bi-pin-map-fill" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z" />
                    <path fill-rule="evenodd"
                          d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z" />
                </svg>
                <br>
                <h5>Địa chỉ</h5>
                <p style="margin-right:50px;">${shop.address}</p>
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                     class="bi bi-stopwatch" viewBox="0 0 16 16">
                    <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5V5.6z" />
                    <path
                            d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64a.715.715 0 0 1 .012-.013l.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354a.512.512 0 0 1-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5zM8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3z" />
                </svg>
                <h5>Giờ mở cửa</h5>
                <p>${shop.day}<br>${shop.time}</p>

            </div>
            <div class="col-sm-8">
                <div class="row">
                    <div class="col">
                        <br>
                        <label>Username (*)</label>
                        <input type="text" class="form-control" name="username" value="${sessionScope.user}" readonly>
                    </div>
                    <div class="col">
                        <br>
                        <label>Số điện thoaị</label>
                        <input type="text" class="form-control"  name = "phone">
                    </div>
                </div>
                <br>
                <div class="mb-3">
                    <label>Góp ý (*)</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Lời nhắn"
                                  rows="3" name="complaint"></textarea>
                    <label>(*): Bắt buộc</label>
                </div>

                <button type="submit" class="btn btn-warning" style="color: white;font-size: 20px;" >
                    GỞI
                </button>
                <br>
                <h4 style="color: red;">${status}</h4>
            </div>

        </div>
    </div>
    </form>

</div>

</body>

</html>
