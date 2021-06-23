<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Dashboard</title>
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

<div class="container-flight-dashboard">
    <h1>Flight Dashboard</h1>
    <div class="container-flight-dashboard">
        <table id="table-container">
            <thead>
            <tr class="flex-table header">
                <th class="flex-row">From</th>
                <th class="flex-row">To</th>
                <th class="flex-row">Flight Number</th>
                <th class="flex-row">Departure time</th>
                <th class="flex-row">Arrive time</th>
                <th class="flex-row">Ticket Price</th>
                <th class="flex-row">Capacity</th>
                <th class="flex-row">Action 1</th>
                <th class="flex-row">Action 2</th>
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
                <td class="flex-row">150</td>
                <td class="flex-row"><button class="btn btn-warning">Edit</button></td>
                <td class="flex-row"><button class="btn btn-danger">Delete</button></td>
            </tr>


            <tr class="flex-table">
                <td class="flex-row">Catar</td>
                <td class="flex-row">Berlim</td>
                <td class="flex-row">XP123</td>
                <td class="flex-row">2021-10-01 09AM</td>
                <td class="flex-row">2021-11-02 11PM</td>
                <td class="flex-row">2.000</td>
                <td class="flex-row">150</td>
                <td class="flex-row"><button class="btn btn-warning">Edit</button></td>
                <td class="flex-row"><button class="btn btn-danger">Delete</button></td>
            </tr>

            <tr class="flex-table">
                <td class="flex-row">Milan</td>
                <td class="flex-row">New York</td>
                <td class="flex-row">XP123</td>
                <td class="flex-row">2021-10-01 09AM</td>
                <td class="flex-row">2021-11-02 11PM</td>
                <td class="flex-row">2.000</td>
                <td class="flex-row">150</td>
                <td class="flex-row"><button class="btn btn-warning">Edit</button></td>
                <td class="flex-row"><button class="btn btn-danger">Delete</button></td>
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