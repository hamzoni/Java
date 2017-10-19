

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

                            <form method="post" action="">
                                <div class="field">
                                    <label class="label">Username</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input name="username" class="input" type="text" placeholder="Username / Email" value="">
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
                                    <label class="label">Name</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input name="name" class="input" type="text" placeholder="Name" value="">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-user-o"></i>
                                        </span>
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">Email</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input name="email" class="input" type="email" placeholder="Email" value="">
                                        <span class="icon is-small is-left">
                                            <i class="fa fa-envelope  "></i>
                                        </span>
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
