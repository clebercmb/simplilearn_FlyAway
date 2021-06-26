<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <div class="container-booking-tickets">
        <h1>My booking tickets</h1>
         <div class="container-flights-list">
            <table id="table-container">
                <thead>
                    <tr class="flex-table header">
                        <th class="flex-row">From</th>
                        <th class="flex-row">To</th>
                        <th class="flex-row">Flight Number</th>
                        <th class="flex-row">Departure time</th>
                        <th class="flex-row">Arrive time</th>
                        <th class="flex-row">Passengers</th>
                        <th class="flex-row">Price</th>
                        <th class="flex-row">Action 1</th>
                        <th class="flex-row">Action 2</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booking"  items="${bookingList}">
                        <tr class="flex-table">
                            <td class="flex-row">${booking.flightDto.from.name}</td>
                            <td class="flex-row">${booking.flightDto.to.name}</td>
                            <td class="flex-row">${booking.flightDto.flightNumber}</td>
                            <td class="flex-row">${booking.flightDto.departureTime}</td>
                            <td class="flex-row">${booking.flightDto.arriveTime}</td>
                            <td class="flex-row">${booking.passengersList.size()}</td>
                            <td class="flex-row">${booking.flightDto.ticketPrice}</td>
                            <td class="flex-row"><a class="btn btn-warning" href="<%=request.getContextPath()%>/updateBooking?id=<c:out value="${booking.bookingId}"/>">Edit</a></td>
                            <td class="flex-row"><a class="btn btn-danger" href="<%=request.getContextPath()%>/deleteBooking?id=<c:out value="${booking.bookingId}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </div>

    </div>
    <!-- JavaScript Bundle with Popper -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>
</html>