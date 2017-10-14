<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="/Components/Header.jsp" %>
    <body>
        <%@ include file="Partials/Header.jsp" %>

        <div class="columns">
            <div class="column is-one-quarter">
                <%@ include file="Partials/Sidebar.jsp" %>
            </div>
            <div class="column">

                <section class="section">
                    <div class="container">

                        <div class="tile is-ancestor">

                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <div class="box">
                                        <article class="media">
                                            <a class="button is-primary" href="${path}user/create">Create</a>
                                        </article>
                                    </div>
                                    <table class="table is-bordered is-fullwidth">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Username</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="user" items="${requestScope.users}">
                                            <tr>
                                                <td><c:out value="${user.getId()}"/></td>
                                                <td><c:out value="${user.getName()}"/></td>
                                                <td><c:out value="${user.getEmail()}"/></td>
                                                <td><c:out value="${user.getUsername()}"/></td>
                                                <td>
                                                    <a class="button" feature="update" target="${user.getId()}">
                                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="button" feature="delete" target="${user.getId()}">
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                    <%@ include file="/Components/Pagination.jsp" %>
                                    <!-- content end here -->
                                </div>
                            </div>
                        </div>

                    </div>
                </section>

            </div>
        </div>

        <%@ include file="Partials/Footer.jsp" %>
        <%@ include file="/Components/ActionScript.jsp" %>
    </body>
</html>
