
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="/Components/Header.jsp" %>
    <body>
        <%@ include file="Partials/Header.jsp" %>
        <section class="section">
            <div class="container">

                <div class="content">
                    <h1>${requestScope.post.getTitle()}</h1>
                    <p>
                        <div class="title is-6">
                            <b>Author:</b> ${requestScope.post.getAuthor().getName()}</br>
                            <b>Category:</b> ${requestScope.post.getCategory().getName()}
                        </div>
                    </p>
                    <p>${requestScope.post.getContent()}</p>
                </div>

            </div>
        </section>
        <%@ include file="Partials/Footer.jsp" %>
    </body>
</html>
