<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Config.RoleConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    RoleConfig cf = new RoleConfig();
%>
<!DOCTYPE html>
<html>
    <%@ include file="/Components/Header.jsp" %>
    <body>
        <%@ include file="Partials/Header.jsp" %>

        <div class="columns">
            <%@ include file="Partials/Sidebar.jsp" %>
            <div class="column">

                <section class="section">
                    <div class="container">
                        <h3 class="title is-3">User Manager</h3>
                        <div class="tile is-ancestor">

                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <div class="box">
                                        <!-- start of navigator -->
                                        <nav class="level">
                                            <!-- Left side -->
                                            <div class="level-left">
                                                <div class="level-item">
                                                    <a class="button is-primary" href="${path}user/create">Create</a>
                                                </div>
                                            </div>

                                            <!-- Right side -->
                                            <div class="level-right">
                                                <form method="get" action="${path}user/list">
                                                    <div class="field has-addons is-horizontal">
                                                        <div class="control">
                                                            <button type="submit" class="button is-primary">Role: </button>
                                                        </div>
                                                        <div class="control is-expanded">
                                                            <div class="select is-fullwidth">
                                                                <select name="privilege">
                                                                    <option value="-1">All</option>
                                                                    <option value="<%= RoleConfig.ADMIN %>">Administrator</option>
                                                                    <option value="<%= RoleConfig.MOD %>">Moderator</option>
                                                                    <option value="<%= RoleConfig.AUTHOR %>">Author</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <p class="control">
                                                            <input class="input" type="text" name="search" placeholder="Find an user" value="${param["search"]}">
                                                        </p>
                                                        <p class="control">
                                                            <button class="button">
                                                                Search
                                                            </button>
                                                        </p>
                                                    </div>
                                                </form>
                                            </div>
                                        </nav>
                                        <!-- end of navigator -->   
                                    </div>

                                    <table class="table is-bordered is-fullwidth">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Username</th>
                                                <th>Role</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="user" items="${requestScope.users}">
                                            <tr>
                                                <td><c:out value="${user.getId()}"/></td>
                                                <td><c:out value="${user.getName()}"/></td>
                                                <td><c:out value="${user.getEmail()}"/></td>
                                                <td><c:out value="${user.getUsername()}"/></td>
                                                <td>
                                                    <c:set var="role" value = "${user.getPrivilege()}"/>
                                                    <c:choose>
                                                        <c:when test="${role == 0}">
                                                            <c:out value="Admin"/>
                                                        </c:when>
                                                        <c:when test="${role == 1}">
                                                            <c:out value="Mod"/>
                                                        </c:when>
                                                        <c:when test="${role == 2}">
                                                            <c:out value="Author"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:out value="No Role"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
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
