<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String title = (String) request.getAttribute("title"); 
%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%= title %></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.5.3/css/bulma.css"/>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <style>
        table thead tr th,
        .text-center
        {
            text-align: center !important;
        }
        a {
            text-decoration: none !important;
        }
        
    </style>
</head>