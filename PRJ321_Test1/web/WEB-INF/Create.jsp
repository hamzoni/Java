

<%@page import="Entities.Student"%>
<%@page import="Entities.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departments");
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
                        <h1 class="title">Create</h1>
                        <form name="create" method="post">
                            <div class="field">
                                <label class="label">Name</label>
                                <div class="control">
                                    <input class="input" type="text" name="name"/>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">DOB</label>
                                <div class="control">
                                    <input class="input" type="text" name="dob"/>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Department</label>
                                <div class="control">
                                    <div class="select">
                                        <select name="department">
                                            <%! int i;%>
                                            <% for (i = 0; i < departments.size(); i++) { %>
                                            <% Department dpt = departments.get(i);%>
                                            <option value="<%= dpt.getId()%>"> 
                                                <%= dpt.getName()%>
                                            </option>
                                            <% }%>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-grouped">
                                <div class="control">
                                    <label class="radio">
                                        <input type="radio"  value="0" name="gender" checked/>
                                        Male
                                    </label>
                                    <label class="radio">
                                        <input type="radio" value="1" name="gender"/>
                                        Female
                                    </label>
                                </div>
                            </div>
                            <div class="field is-grouped">
                                <div class="control">
                                    <input class="button" type="reset"/>
                                </div>
                                <div class="control">
                                    <input class="button is-primary" type="submit"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="column"></div>
                </div>
            </div>
        </div>

    </body>
</html>
