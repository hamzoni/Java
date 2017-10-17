
<%@page import="Entities.Role"%>
<%@page import="Entities.Account"%>
<%@page import="Entities.Feature"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Config.FeaturesConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account acc = (Account) request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/Layout/Header.jsp"></jsp:include>
        <body>
        <jsp:include page="/WEB-INF/Layout/HeaderContent.jsp"></jsp:include>
            <div class="container">
                <div class="notification">
                    <h1 class="title">Update Account <%= acc.getUsername() %></h1>
                    <form name="update" method="post">
                        <input type="hidden" name="usernameRoot" value="<%= acc.getUsername() %>"/>
                        <div class="field">
                            <label class="label">Username</label>
                            <div class="control">
                                <input class="input" type="text" name="login" value="<%= acc.getUsername() %>"/>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Password</label>
                            <div class="control">
                                <input class="input" type="password" name="password" value="<%= acc.getPassword()%>"/>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Features</label>
                            <div class="control">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="5">Account</th>
                                        </tr>
                                        <tr>
                                            <th><i class="fa fa-star" aria-hidden="true"></i></i></th>
                                            <th><i class="fa fa-eye" aria-hidden="true"></i></th>
                                            <th><i class="fa fa-plus" aria-hidden="true"></i></th>
                                            <th><i class="fa fa-pencil" aria-hidden="true"></i></th>
                                            <th><i class="fa fa-trash-o" aria-hidden="true"></i></i></th>
                                        </tr>
                                    </thead>
                                    <tr>
                                        <td><input type="checkbox" id="allAccountFeatures"/></td>
                                        <% int i; int ftr[] = FeaturesConfig.Account.ACCF; %>
                                        <% for (i = 0; i < ftr.length; i++) { %>
                                        <td><input type="checkbox" name="features" acc-ft 
                                            value="<%= ftr[i] %>"
                                            
                                            <% if (acc.hasRole(ftr[i])) { %>
                                                checked="true"
                                            <% } %>
                                            
                                            />
                                        </td>
                                        <% } %>
                                    </tr>
                                </table>
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
            </div>
        <jsp:include page="/WEB-INF/Layout/FooterContent.jsp"></jsp:include>
        <script>
            document.querySelector("#allAccountFeatures").onclick = function () {
                let inputs = document.querySelectorAll("input[acc-ft]");
                inputs.forEach(input => {
                    input.checked = this.checked;
                });
            }
        </script>
    </body>
</html>
