<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <label><Strong>Flight Number :</Strong><span>${flight.flightNumber}</span></label>
            <label><Strong>Ticket Price :</Strong><span>${flight.ticketPrice}</span></label>
        </div>
        <div>
            <label><Strong>From :</Strong><span>${flight.from}</span></label>
            <label><Strong>To :</Strong><span>${flight.to}</span></label>
        </div>
        <div>
            <label><Strong>Departure Time :</Strong><span>${flight.departureTime}</span></label>
            <label><Strong>Arrive Time :</Strong><span>${flight.arriveTime}</span></label>
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

        <sform:form method="post" action="create-booking" modelAttribute="bookingCommand" class="container-booking-data">
            <input type="hidden" id="flightId" name="flightId" value="${flight.flightId}"/>

            <c:forEach var = "i" begin = "0" end = "${numberOfPassengers-1}">
                <div class="passenger">
                    <label for="fname${i}">${i+1}</label>
                    <input type="text" id="fname${i}" name="passengersList[${i}].firstName"/>
                    <input type="text" id="lname${i}" name="passengersList[${i}].lastName"/>
                    <input type="email" id="email${i}" name="passengersList[${i}].email"/>
                </div>
            </c:forEach>



            <!--div class="passenger">
                <label for="fname1">#1</label>
                <input type="text" id="fname1" name="passengersList[0].firstName"/>
                <input type="text" id="lname1" name="passengersList[0].lastName"/>
                <input type="email" id="email1" name="passengersList[0].email"/>
            </div-->

            <input type="submit" value="Submit">
        </sform:form>
    </div>


</div>
<!-- JavaScript Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>