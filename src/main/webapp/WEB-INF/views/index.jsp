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

    <div class="container-search-flights-list">
        <form class="container-flights"  action="search-flights">
            <div id="type-trip">
                <input type="radio" id="roundTrip" name="tripType" value ="0"/>
                <label id="label_round_trip"  for="roundTrip">
                    Round trip
                </label>

                <input type="radio" id="oneWay" name="tripType" value ="0"/>
                <label id="label_one_way" for="oneWay">
                    One way
                </label>

            </div>

            <div class="container-flights-level-1">
                <div>
                    <label>
                        From
                        <input type="text" id="from" name="from" placeholder="City or airport"/>
                    </label>
                </div>
                <div>
                    <label>
                        To
                        <input type="text" id="to" name="to" placeholder="City or airport"/>
                    </label>
                </div>

                <div>
                    <label>
                        Number of passengers
                        <select name="numberOfPassengers" id="numberOfPassengers">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </select>
                    </label>
                </div>

            </div>


            <div class="container-flights-level-1">
                <label>
                    Depart
                    <input type="date" id="depart" name="depart" />
                </label>
                <label>
                    Return
                    <input type="date" id="return" name="return"/>
                </label>
                <input type="submit"/>
            </div>

        </form>

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
                    <tr class="flex-table">
                        <td class="flex-row"><a href="booking" title="Click here to book a trip">Toronto</a></td>
                        <td class="flex-row">Sao Paulo</td>
                        <td class="flex-row">XP123</td>
                        <td class="flex-row">2021-10-01 09AM</td>
                        <td class="flex-row">2021-11-02 11PM</td>
                        <td class="flex-row">2.000</td>
                    </tr>


                    <tr class="flex-table">
                        <td class="flex-row">Catar</td>
                        <td class="flex-row">Berlim</td>
                        <td class="flex-row">XP123</td>
                        <td class="flex-row">2021-10-01 09AM</td>
                        <td class="flex-row">2021-11-02 11PM</td>
                        <td class="flex-row">2.000</td>
                    </tr>

                    <tr class="flex-table">
                        <td class="flex-row">Milan</td>
                        <td class="flex-row">New York</td>
                        <td class="flex-row">XP123</td>
                        <td class="flex-row">2021-10-01 09AM</td>
                        <td class="flex-row">2021-11-02 11PM</td>
                        <td class="flex-row">2.000</td>
                    </tr>
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