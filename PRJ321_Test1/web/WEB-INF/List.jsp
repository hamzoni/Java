
<%@page import="Entities.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
    <%@ include file="Layout/Header.jsp" %>
    <body>
        <div class="container">
            <div class="notification">
                <div class="columns">
                    <div class="column"></div>
                    <div class="column is-two-thirds">
                        <h1 class="title">Listing</h1>
                        <table class="table">
                            <thead>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>Department</th>
                                <th>Dob</th>
                                <th>Action</th>
                            </thead>
                            <% if (students.size() == 0) { %>
                            <tr>
                                <td colspan="6">No records</td>
                            </tr>
                            <% } %>
                            <%! int i;%>
                            <% for (i = 0; i < students.size(); i++) { %>
                            <% Student std = students.get(i);%>
                            <tr>
                                <td><%= std.getId()%></td>
                                <td><%= std.getName()%></td>
                                <% if (std.getGender() == 0) { %>
                                <td>Male</td>
                                <% } else { %>
                                <td>Female</td>
                                <% }%>
                                <td><%= std.getDepartment_name()%></td>
                                <td><%= std.getDob()%></td>
                                <td>
                                    <form action="update" method="get" class="is-pulled-left">
                                        <input type="hidden" value="<%= std.getId()%>" name="id"/>
                                        <button type="submit" class="button is-primary is-outlined is-small" title="update">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                    </form>
                                    <form action="delete" method="post" class="is-pulled-left">
                                        <input type="hidden" value="<%= std.getId()%>" name="id"/>
                                        <button type="submit" class="button is-primary is-outlined is-small" title="delete">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                            <% }%>
                        </table>
                        <a class="button is-primary" href="create">Add</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
