

<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

    ArrayList<Fruit> fruits = (ArrayList<Fruit>) request.getAttribute("fruitsList");

%>
<!DOCTYPE html>
<html>
    <%@ include file="Layout/Header.jsp" %>
    <body>
        <div class="container">
            <h1><%= request.getAttribute("title") %></h1>
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <%! int i; %>
                <% for (i = 0; i < fruits.size(); i++) { %>
                    <tr>
                        <td><%= fruits.get(i).getId() %></td>
                        <td><%= fruits.get(i).getName() %></td>
                        <td><%= fruits.get(i).getPrice() %></td>
                        <td>
                            <a href="update?id=<%= fruits.get(i).getId() %>">
                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </a>
                            <form name="delete_<%= fruits.get(i).getId() %>" method="get" action="delete">
                                <input type="hidden" value="<%= fruits.get(i).getId() %>" name="id"/>
                                <a href="javascript:{}" onclick="window.delete_<%= fruits.get(i).getId() %>.submit();">
                                    <i class="fa fa-times" aria-hidden="true"></i>
                                </a>
                            </form>
                        </td>
                    </tr>
                <% }; %>
            </table>
        </div>
    </body>
</html>
