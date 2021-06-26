<%@ page import="com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand" %>
<header>
    <%
        HttpSession session2 = request.getSession(false);
        String userEmail= null;
        String userId="";

        UserCommand user= (UserCommand) session2.getAttribute("user");
        if(user  != null) {
            userEmail= user.getEmail();
            userId = user.getUserId()+"";

        }
    %>

    <nav class="nav-header fly-header">
        <div class="nav-header-left">

            <%
                if( user == null || !user.getGroupName().equals("admin")) {
            %>
                <a class="nav-link active" aria-current="page" href="home">Home</a>
            <%
                }
            %>


            <%
                if( user != null && !user.getGroupName().equals("admin")) {
            %>
                <a class="nav-link" href="booking-tickets">Book Tickets</a>
            <%
                }
            %>

            <%
                if( user != null && user.getGroupName().equals("admin")) {
            %>
                <a class="nav-link active" aria-current="page" href="flight-dashboard">Flights DashBoard</a>
                <a class="nav-link" href="booking-dashboard">Place Dashboard</a>
            <%
                }
            %>


        </div>

        <div class="nav-header-right">

            <%
                if(userEmail == null) {
            %>
                <a class="nav-link" href="login">Login</a>
            <%
                }
            %>

            <%
                if(userEmail != null) {
            %>
                <a class="nav-link" href="<%=request.getContextPath()%>/profile?id=<%=userId%>"><%=userEmail%></a>
                <a class="nav-link" href="logout">Logout</a>

            <%
                }
            %>

        </div>
    </nav>
</header>