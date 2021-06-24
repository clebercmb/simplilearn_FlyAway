<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Update</title>
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

    <div class="container-place">
        <h1>Flight Update</h1>
         <sform:form method="post" action="saveFlight" modelAttribute="flightCommand" class="container-place-data">
             <input type="hidden" id="flightId" name="flightId" value="${flight.flightId}"/>
             <div>
                 <label for="flightNumber">Flight Number</label>
                 <input type="text" id="flightNumber" name="flightNumber" value="${flight.flightNumber}"/>
             </div>

             <div>
                 <label for="from">From</label>
                 <input type="text" id="from" name="from" value="${flight.from}"/>
             </div>

             <div>
                 <label for="to">To</label>
                 <input type="text" id="to" name="to" value="${flight.to}"/>
             </div>

             <div>
                 <label for="departureTime">Departure time</label>
                 <input type="datetime-local" id="departureTime" name="departureTime" value="${flight.departureTime}"/>
             </div>

             <div>
                 <label for="arriveTime">Arrive time</label>
                 <input type="datetime-local" id="arriveTime" name="arriveTime" value="${flight.arriveTime}"/>
             </div>

             <div>
                 <label for="seatsCapacity">Seats capacity</label>
                 <input type="number" id="seatsCapacity" name="seatsCapacity" value="${flight.seatsCapacity}"/>
             </div>

             <div>
                 <label for="ticketPrice">Ticket Price</label>
                 <input type="number" id="ticketPrice" name="ticketPrice" value="${flight.ticketPrice}"/>
             </div>


             <input type="submit"/>

         </sform:form>

    </div>
    <!-- JavaScript Bundle with Popper -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>
</html>