<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <div class="container-profile">
        <h1>My Profile</h1>

        <sform:form method="post" action="change-password" modelAttribute="changePasswordCommand" class="container-profile-data">


            <div>
                <label for="name">Name</label>
                <input type="text" id="name" name="name"  value="${user.name}"/>
            </div>


            <div>
                 <label for="email">Email</label>
                 <input type="email" id="email" name="email"  value="${user.email}"/>
             </div>

             <div>
                 <label for="password">Password</label>
                 <input type="password" id="password" name="password"/>
             </div>

             <div>
                 <label for="repeatPassword">Repeat Password</label>
                 <input type="password" id="repeatPassword" name="repeatPassword"/>
             </div>

            <div class="mb-3 login_error">
                <label>${login_error}</label>
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