<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String title = (String) request.getAttribute("title"); 
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%= title %></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.5.3/css/bulma.css"/>
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