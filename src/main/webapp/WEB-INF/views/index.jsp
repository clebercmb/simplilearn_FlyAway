<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>

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

    <div class="container-search-flights-list">

        <sform:form method="post" action="search-flights" modelAttribute="searchCommand" class="container-flights">
            <h1>Search Flights</h1>

            <!--div id="type-trip">
                <input type="radio" id="roundTrip" name="tripType" value ="0"/>
                <label id="label_round_trip"  for="roundTrip">
                    Round trip
                </label>

                <input type="radio" id="oneWay" name="tripType" value ="0"/>
                <label id="label_one_way" for="oneWay">
                    One way
                </label>

            </div-->

            <div class="container-flights-level-1">
                <div>
                    <label>
                        From
                        <input type="text" id="from" name="from" placeholder="City or airport"  value="${searchCommand.from}"/>
                    </label>
                </div>
                <div>
                    <label>
                        To
                        <input type="text" id="to" name="to" placeholder="City or airport" value="${searchCommand.to}"/>
                    </label>
                </div>

                <div>
                    <label>
                        Number of passengers
                        <select name="numberOfPassengers" id="numberOfPassengers">
                            <option value="1" <c:if test="${searchCommand.numberOfPassengers == 1}">selected</c:if>>1</option>
                            <option value="2" <c:if test="${searchCommand.numberOfPassengers == 2}">selected</c:if>>2</option>
                            <option value="3" <c:if test="${searchCommand.numberOfPassengers == 3}">selected</c:if>>3</option>
                            <option value="4" <c:if test="${searchCommand.numberOfPassengers == 4}">selected</c:if>>4</option>
                            <option value="5" <c:if test="${searchCommand.numberOfPassengers == 5}">selected</c:if>>5</option>
                            <option value="6" <c:if test="${searchCommand.numberOfPassengers == 6}">selected</c:if>>6</option>
                            <option value="7" <c:if test="${searchCommand.numberOfPassengers == 7}">selected</c:if>>7</option>
                            <option value="8" <c:if test="${searchCommand.numberOfPassengers == 8}">selected</c:if>>8</option>
                            <option value="9" <c:if test="${searchCommand.numberOfPassengers == 9}">selected</c:if>>9</option>
                        </select>
                    </label>
                </div>
            </div>

            <div class="container-flights-level-1">
                <label>
                    Depart
                    <input type="date" id="departureTime" name="departureTime" value="${searchCommand.departureTime}"/>
                </label>
                <label>
                    Return
                    <input type="date" id="returnTime" name="returnTime" value="${searchCommand.returnTime}"/>
                </label>
                <input type="submit"/>
            </div>
        </sform:form>



        <c:if test="${flights != null}">

            <div class="container-flights-list"0>
                <table id="table-container">
                    <thead>
                        <tr class="flex-table header">
                            <th class="flex-row">From</th>
                            <th class="flex-row">To</th>
                            <th class="flex-row">Flight Number</th>
                            <th class="flex-row">Departure time</th>
                            <th class="flex-row">Arrive time</th>
                            <th class="flex-row">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="flight"  items="${flights}">
                            <tr class="flex-table">
                                <td class="flex-row"><a href="<%=request.getContextPath()%>/booking?id=<c:out value="${flight.flightId}&passengers=${searchCommand.numberOfPassengers}"/>">${flight.from.name}</a></td>
                                <td class="flex-row">${flight.to.name}</td>
                                <td class="flex-row">${flight.flightNumber}</td>
                                <td class="flex-row">${flight.departureTime}</td>
                                <td class="flex-row">${flight.arriveTime}</td>
                                <td class="flex-row">${flight.ticketPrice}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </div>

        </c:if>

    </div>
    <!-- JavaScript Bundle with Popper -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>
</html>