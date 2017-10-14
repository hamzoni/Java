
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="/Components/Header.jsp" %>
    <body>
        <section class="section">
            <div class="container">
                <h2 class="subtitle">
                    <div class="columns">
                        <div class="column">
                        </div>
                        <div class="column is-half">

                            <form method="post" action="${path}/login">
                                <div class="field">
                                    <label class="label">Username</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input name="login" class="input" type="text" placeholder="Username / Email" value="">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-user"></i>
                                        </span>
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">Password</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input name="password" class="input" type="password" placeholder="Password" value="">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-key"></i>
                                        </span>
                                    </div>
                                </div>


                                <div class="field">
                                    <div class="control">
                                        <label class="checkbox">
                                            <input type="checkbox" name="remember">
                                            Remember me
                                        </label>
                                    </div>
                                </div>


                                <div class="field is-grouped">
                                    <div class="control">
                                        <button class="button is-primary">Submit</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="column">
                        </div>
                    </div>
                </h2>
            </div>
        </section>
    </body>
</html>
