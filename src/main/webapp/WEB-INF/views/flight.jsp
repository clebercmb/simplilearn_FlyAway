<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight</title>
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

    <div class="container-flight">
        <h1>Flight</h1>
         <form class="container-flight-data">
             <div>
                 <label for="flightNumber">Flight Number</label>
                 <input type="text" id="flightNumber" name="flightNumber"/>
             </div>

             <div>
                 <label for="from">From</label>
                 <input type="text" id="from" name="from"/>
             </div>

             <div>
                 <label for="to">To</label>
                 <input type="text" id="to" name="to"/>
             </div>

             <div>
                 <label for="departureTime">Departure time</label>
                 <input type="datetime-local" id="departureTime" name="departureTime"/>
             </div>

             <div>
                 <label for="arriveTime">Arrive time</label>
                 <input type="datetime-local" id="arriveTime" name="arriveTime"/>
             </div>

             <div>
                 <label for="seatsCapacity">Seats capacity</label>
                 <input type="number" id="seatsCapacity" name="seatsCapacity"/>
             </div>

             <div>
                 <label for="ticketPrice">Ticket Price</label>
                 <input type="number" id="ticketPrice" name="ticketPrice"/>
             </div>


             <input type="submit"/>

         </form>

    </div>
    <!-- JavaScript Bundle with Popper -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>
</html>