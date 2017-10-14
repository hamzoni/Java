
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="/Components/Header.jsp" %>
    <body>
        <%@ include file="Partials/Header.jsp" %>
        <section class="section">
            <div class="container">
                <h1 class="title">Home</h1>
                <c:set var="postCount" value="0"/>
                <c:forEach var="post" items="${requestScope.posts}">
                    <c:if test="${postCount % 4 == 0}">
                        <div class="tile is-ancestor">
                        </c:if>

                        <a class="tile is-parent" href="${path}post?id=${post.getId()}"/>
                        <article class="tile is-child box">

                            <p class="title is-5">${post.getTitle()}</p>
                            <p class="subtitle">${post.getDescription()}</p>
                            <c:if test="${post.getThumbnail().length() > 0}">
                                <figure class="image image is-1by2">
                                    <img src="${path}${post.getThumbnail()}">
                                </figure>
                            </c:if>
                        </article>
                        </a>

                        <c:if test="${postCount % 4 == 3}">                    
                        </div>
                    </c:if>
                    <c:set var="postCount" value="${postCount + 1}"/>
                </c:forEach>
                <%@ include file="/Components/Pagination.jsp" %>
            </div>
        </section>
        <%@ include file="Partials/Footer.jsp" %>
    </body>
</html>
