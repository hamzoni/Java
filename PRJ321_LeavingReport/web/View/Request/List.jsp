
<%@page import="Entities.User"%>
<%
     User user = (User) request.getAttribute("user");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../Layout/Header.jsp" %>
    <body>
        <%@ include file="../../Layout/HeaderContent.jsp" %>
        <div class="container">
            <div class="notification">
                <h1 class="title is-1">Hello <%=user.getUsername() %></h1>
            </div>
        </div>
    </body>
</html>
