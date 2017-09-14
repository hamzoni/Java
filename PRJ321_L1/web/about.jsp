<%-- 
    Document   : about
    Created on : Sep 6, 2017, 10:25:01 AM
    Author     : World
--%>
<%@page import="java.util.Date"%>

<%! 
    String intro = "This is about page"; 
    String todayDate = new Date().toLocaleString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= intro %></h1>
        <jsp:include page="contact.jsp" flush="true"/>
        <script>
            console.log("Today is <%= todayDate %>");
        </script>
    </body>
</html>
