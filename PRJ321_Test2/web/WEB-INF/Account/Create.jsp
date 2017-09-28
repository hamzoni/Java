
<%@page import="Entities.Feature"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Config.FeaturesConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/Layout/Header.jsp"></jsp:include>
        <body>
        <jsp:include page="/WEB-INF/Layout/HeaderContent.jsp"></jsp:include>
            <div class="container">
                <div class="notification">
                    <h1 class="title">Create Account</h1>
                    <form name="create" method="post">
                        <div class="field">
                            <label class="label">Username</label>
                            <div class="control">
                                <input class="input" type="text" name="username"/>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Password</label>
                            <div class="control">
                                <input class="input" type="password" name="password"/>
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
                                        <td><input type="checkbox" name="features" acc-ft value="<%= FeaturesConfig.Account.READ %>"/></td>
                                        <td><input type="checkbox" name="features" acc-ft value="<%= FeaturesConfig.Account.WRITE %>"/></td>
                                        <td><input type="checkbox" name="features" acc-ft value="<%= FeaturesConfig.Account.UPDATE %>"/></td>
                                        <td><input type="checkbox" name="features" acc-ft value="<%= FeaturesConfig.Account.DELETE %>"/></td>
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
