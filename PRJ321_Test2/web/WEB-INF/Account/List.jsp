
<%@page import="Config.FeaturesConfig"%>
<%@page import="Entities.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Account> accounts = (ArrayList<Account>) request.getAttribute("accounts");
%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/Layout/Header.jsp"></jsp:include>
        <body>
        <jsp:include page="/WEB-INF/Layout/HeaderContent.jsp"></jsp:include>
            <div class="container">
                <div class="notification">

                    <nav class="breadcrumb" aria-label="breadcrumbs">
                        <ul>
                            <li><a>Users</a></li>
                            <li class="is-active"><a aria-current="page">Listing</a></li>
                        </ul>
                    </nav>

                    <h1 class="title">Listing</h1>
                    <table class="table is-bordered is-striped is-narrow is-fullwidth">
                        <thead>
                            <tr>
                                <th rowspan="2">Username</th>
                                <th colspan="4">Role</th>
                                <th rowspan="2" colspan="2">Action</th>
                            </tr>
                            <tr>
                                <th><i class="fa fa-eye" aria-hidden="true"></i></th>
                                <th><i class="fa fa-plus" aria-hidden="true"></i></th>
                                <th><i class="fa fa-pencil" aria-hidden="true"></i></th>
                                <th><i class="fa fa-trash-o" aria-hidden="true"></i></i></th>
                            </tr>
                        </thead>
                    <% for (Account account : accounts) {%>
                    <tr>
                        <td><%= account.getUsername()%></td>

                        <td class="text-center">
                            <% if (account.hasRole(FeaturesConfig.Account.READ)) { %>
                            <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <% } %>
                        </td>
                        <td class="text-center">
                            <% if (account.hasRole(FeaturesConfig.Account.WRITE)) { %>
                            <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <% } %>
                        </td>
                        <td class="text-center">
                            <% if (account.hasRole(FeaturesConfig.Account.UPDATE)) { %>
                            <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <% } %>
                        </td>
                        <td class="text-center">
                            <% if (account.hasRole(FeaturesConfig.Account.DELETE)) { %>
                            <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <% } %>
                        </td>

                        <td class="text-center">
                            <form action="update" action="get">
                                <input type="hidden" name="username" value="<%= account.getUsername() %>"/>
                                <button type="submit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            </form>
                        </td>
                        <td class="text-center">
                            <form action="delete" method="post">
                                <input type="hidden" name="username" value="<%= account.getUsername() %>"/>
                                <button type="submit"><i class="fa fa-times" aria-hidden="true"/></i></button>
                            </form>
                        </td>
                    </tr>
                    <% }%>
                </table>

                <a class="button is-primary" href="create">Add</a>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/Layout/FooterContent.jsp"></jsp:include>
</body>
</html>
