<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous"/>

    <style><%@include file="/WEB-INF/css/custom.css"%></style>
    <style><%@include file="/WEB-INF/css/custom2.css"%></style>

    <!--link href="../css/custom.css" rel="stylesheet" type="text/css"-->

</head>
<body>

<%@include file="header.jsp"%>


<div class="container-booking">
    <h1>Booking</h1>

    <div class="user-information">
        <h4>Flight Information</h4>
        <div>
            <label><Strong>Flight Number :</Strong><span>XP123</span></label>
            <label><Strong>Price :</Strong><span>2.000</span></label>
        </div>
        <div>
            <label><Strong>From :</Strong><span>Toronto</span></label>
            <label><Strong>To :</Strong><span>New York</span></label>
        </div>
        <div>
            <label><Strong>Departure Time :</Strong><span>2021-10-01 09AM</span></label>
            <label><Strong>Arrive Time :</Strong><span>2021-10-01 10P</span></label>
        </div>
        <div>
            <label><Strong>Available seats :</Strong><span>10</span></label>
        </div>

    </div>

    <div class="passengers-information">
        <h4>Passengers Information</h4>


        <div class="passenger">
            <label class="header"><b>#</b></label>
            <label class="header"><b>First name:</b></label>
            <label class="header"><b>Last name:</b></label>
            <label class="header"><b>Email:</b></label>

        </div>
        <form>
            <div class="passenger">
                <label for="fname1">#1</label>
                <input type="text" id="fname1" name="fname1"/>
                <input type="text" id="lname1" name="lname1"/>
                <input type="email" id="email1" name="email1"/>
            </div>
            <div class="passenger">
                <label for="fname2">#2</label>
                <input type="text" id="fname2" name="fname2"/>
                <input type="text" id="lname2" name="lname2"/>
                <input type="email" id="email2" name="email2"/>
            </div>
            <div class="passenger">
                <label for="fname2">#3</label>
                <input type="text" id="fname2" name="fname2"/>
                <input type="text" id="lname2" name="lname2"/>
                <input type="email" id="email2" name="email2"/>
            </div>

            <input type="submit" value="Submit">

        </form>
    </div>


</div>
<!-- JavaScript Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>