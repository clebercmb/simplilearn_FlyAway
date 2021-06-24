<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="container-place-dashboard">
    <div class="container-place-dashboard-header">
        <h1>Place Dashboard</h1>
        <a href="place"  class="btn btn-primary" >New Place</a>
    </div>
    <div class="container-place-dashboard">
        <table id="table-container">
            <thead>
            <tr class="flex-table header">
                <th class="flex-row">Id</th>
                <th class="flex-row">Name</th>
                <th class="flex-row">Action 1</th>
                <th class="flex-row">Action 2</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="place"  items="${places}">
                    <tr class="flex-table">
                        <td class="flex-row">${place.placeId}</td>
                        <td class="flex-row">${place.name}</td>
                        <td class="flex-row"><a class="btn btn-warning" href="<%=request.getContextPath()%>/updatePlace?id=<c:out value="${place.placeId}"/>">Edit</a></td>
                        <td class="flex-row"><a class="btn btn-danger" href="<%=request.getContextPath()%>/deletePlace?id=<c:out value="${place.placeId}"/>">Delete</a></td>
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