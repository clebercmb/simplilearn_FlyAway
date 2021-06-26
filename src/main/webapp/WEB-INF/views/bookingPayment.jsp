<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Payment</title>
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
    <h1>Booking Payment</h1>

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
            <label><Strong>Total Price :</Strong><span>${flight.ticketPrice * passengers.size()}</span></label>
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

        <c:forEach var="passenger"  items="${passengers}" varStatus="loop">

            <div class="passenger">
                <label>${loop.index+1}</label>
                <label>${passenger.firstName}</label>
                <label>${passenger.lastName}</label>
                <label>${passenger.email}</label>
            </div>
        </c:forEach>

            <br/>
            <a class="btn btn-warning" href="<%=request.getContextPath()%>/create-booking?id=<c:out value="${flight.flightId}"/>">Confirm Payment</a>
            <a class="btn btn-danger" href="cancelBooking">Cancel the Booking</a>

    </div>


</div>
<!-- JavaScript Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>