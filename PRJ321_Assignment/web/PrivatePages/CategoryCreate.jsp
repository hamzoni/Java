<%@page import="Config.PathConfig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    application.setAttribute("path", PathConfig.ROOT);
%>
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
                                    <form method="POST" action="<c:out value="${applicationScope.path}category/create"/>">
                                        <div class="field">
                                            <label class="label">Name</label>
                                            <div class="control">
                                                <input name="name" class="input" type="text" placeholder="Category name">
                                            </div>
                                        </div>
                                        <div class="field is-grouped">
                                            <div class="control">
                                                <button class="button is-primary">Submit</button>
                                            </div>
                                            <div class="control">
                                                <button class="button is-text">Cancel</button>
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
