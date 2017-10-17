<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                        <nav class="breadcrumb" aria-label="breadcrumbs">
                            <ul>
                                <li><a href="${path}category/list">Category Manager</a></li>
                                <li class="is-active"><a href="${path}category/update" aria-current="page">Update Category</a></li>
                            </ul>
                        </nav>
                        
                        <div class="tile is-ancestor">

                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <form method="POST" action="<c:out value="${applicationScope.path}category/update"/>">
                                        <input type="hidden" name="id" value="${requestScope.category.getId()}"/>
                                        <div class="field">
                                            <label class="label">Name</label>
                                            <div class="control">
                                                <input name="name" class="input" type="text" value="${requestScope.category.getName()}">
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
