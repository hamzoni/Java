<%@page import="Entities.User"%>
<%@page import="Entities.User"%>
<%@page import="Config.RoleConfig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    RoleConfig roles = new RoleConfig();
    User user = (User) request.getAttribute("user");
%>

<c:set var="user" value="${requestScope.user}" scope="page"/>
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
                        <h3 class="title is-3">Profile</h3>
                        <div class="tile is-ancestor">
                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <form method="post" action="<c:out value="${path}profile"/>">
                                        <div class="field">
                                            <label class="label">Username</label>
                                            <div class="control has-icons-left has-icons-right">
                                                <input name="username" class="input" type="text"  value="${user.getUsername()}">
                                                <span class="icon is-small is-left">
                                                    <i class="fa fa-user"></i>
                                                </span>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <label class="label">Password</label>
                                            <div class="control has-icons-left has-icons-right">
                                                <input name="password" class="input" type="password" value="${user.getPassword()}">
                                                <span class="icon is-small is-left">
                                                    <i class="fa fa-key"></i>
                                                </span>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <label class="label">Name</label>
                                            <div class="control has-icons-left has-icons-right">
                                                <input name="name" class="input" type="text" value="${user.getName()}">
                                                <span class="icon is-small is-left">
                                                    <i class="fa fa-user-o"></i>
                                                </span>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <label class="label">Email</label>
                                            <div class="control has-icons-left has-icons-right">
                                                <input name="email" class="input" type="email" value="${user.getEmail()}">
                                                <span class="icon is-small is-left">
                                                    <i class="fa fa-envelope"></i>
                                                </span>
                                            </div>
                                        </div>
                                        
                                        <div class="field">
                                            <label class="label">Roles</label>
                                            <div class="select">
                                                <select disabled>
                                                    <option value="<%= roles.roles[0] %>" 
                                                        <% if (user.getPrivilege() == roles.roles[0]) { %>
                                                            selected
                                                        <% } %>
                                                    >Admin</option>
                                                    <option value="<%= roles.roles[1] %>"
                                                        <% if (user.getPrivilege() == roles.roles[1]) { %>
                                                            selected
                                                        <% } %>
                                                    >Mod</option>
                                                    <option value="<%= roles.roles[2] %>"
                                                        <% if (user.getPrivilege() == roles.roles[2]) { %>
                                                            selected
                                                        <% } %>
                                                    >Author</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="field is-grouped">
                                            <div class="control">
                                                <button class="button is-primary">Submit</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- content end here -->
                                </div>
                            </div>
                        </div>

                    </div>
                </section>

            </div>
        </div>

        <%@ include file="Partials/Footer.jsp" %>
    </body>
</html>
