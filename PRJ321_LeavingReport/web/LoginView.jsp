
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="Layout/Header.jsp" %>
    <body>
        <div class="container">
            <div class="notification">
                <div class="columns">
                    <div class="column"></div>
                    <div class="column is-two-thirds">
                        <h1 class="title">Login Form</h1>
                        <form action="login" method="post">
                            <div class="field">
                                <label class="label">Username</label>
                                <div class="control">
                                    <input class="input" type="text" name="username"/>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Password</label>
                                <div class="control">
                                    <input class="input" type="text" name="password"/>
                                </div>
                            </div>
                            <div class="field is-grouped">
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
