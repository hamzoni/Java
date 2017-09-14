
<%@page import="Entities.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    </head>
    <body>

<table class="table table-bordered table-inverse">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Skills</th>
        </tr>
    </thead>
    <tbody>
        <% for (Employee emp : emps) {%>
            <tr>
                <td rowspan="<%= emp.skill.size()%>"><%= emp.id%></td>
                <td rowspan="<%= emp.skill.size()%>"><%= emp.name%></td>
                <td rowspan="<%= emp.skill.size()%>"><%= emp.dob%></td>
                
            </tr>
            <% for (int i = 1; i < emp.skill.size(); i++) {%>
            <tr>
                <td><%= emp.skill.get(i) %></td>
            </tr>
            <% }%>
        <% }%>
    </tbody>
</table>
</body>
</html>
