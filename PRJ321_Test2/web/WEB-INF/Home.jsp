
<%@page import="Entities.Account"%>
<%
     Account account = (Account) request.getAttribute("account");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="Layout/Header.jsp" %>
    <body>
        <%@ include file="Layout/HeaderContent.jsp" %>
        <div class="container">
            <div class="notification">
                <h1 class="title is-3">Hello <%= account.getUsername() %></h1>
            </div>
        </div>
        <%@ include file="Layout/FooterContent.jsp" %>
    </body>
</html>
