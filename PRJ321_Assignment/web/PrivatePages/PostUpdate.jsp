
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                        <nav class="breadcrumb" aria-label="breadcrumbs">
                            <ul>
                                <li><a href="${path}post/list">Post Manager</a></li>
                                <li class="is-active"><a href="${path}post/update" aria-current="page">Update Post</a></li>
                            </ul>
                        </nav>
                        
                        <div class="tile is-ancestor">

                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <form method="POST" action="<c:out value="${applicationScope.path}post/update"/>" enctype="multipart/form-data">
                                        <c:set var="post" value="${requestScope.post}"/>
                                        <input type="hidden" name="author_id" value="${post.getAuthor().getId()}"/>
                                        <input type="hidden" name="post_id" value="${param.id}"/>
                                        <div class="tile is-ancestor">
                                            <div class="tile is-parent">
                                                <article class="tile is-child">
                                                    <div class="field">
                                                        <label class="label">Thumbnail</label>
                                                        <div class="file has-name is-right">
                                                            <label class="file-label">
                                                                <figure class="image" style="height:200px;width: 200px" class="file-cta">
                                                                    <c:set var="thumbnailImage" value="http://bulma.io/images/placeholders/256x256.png"/>
                                                                    <c:choose>
                                                                        <c:when test="${post.getThumbnail().length() > 0}">
                                                                            <c:set var="thumbnailImage" value="${path}${post.getThumbnail()}"/>
                                                                        </c:when>
                                                                    </c:choose>
                                                                    <input type="hidden" name="oldThumbnail" value="${post.getThumbnail()}"/>
                                                                    <img id="prvImg" style="height:200px;width: 200px" src="${thumbnailImage}">
                                                                </figure>
                                                                <input class="file-input" type="file" name="thumbnail">
                                                            </label>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>

                                            <div class="tile is-vertical is-10">
                                                <div class="tile">
                                                    <div class="tile is-parent">
                                                        <article class="tile is-child">
                                                            <div class="field">
                                                                <label class="label">Title</label>
                                                                <div class="control">
                                                                    <input name="title" class="input" type="text" value="${post.getTitle()}">
                                                                </div>
                                                            </div>
                                                            <div class="field">
                                                                <label class="label">Description</label>
                                                                <div class="control">
                                                                    <textarea name="description" class="textarea">${post.getDescription()}</textarea>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>


                                        <div class="field">
                                            <label class="label">Content</label>
                                            <div class="control">
                                                <textarea name="content" id="editor" class="textarea">${post.getContent()}</textarea>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <label class="label">Category</label>
                                            <div class="control">
                                                <div class="select">
                                                    <select name="category">
                                                        <c:forEach var="category" items="${requestScope.categories}">
                                                            <option value="${category.getId()}" 
                                                                    <c:if test="${post.getCategory().getId() == category.getId()}">
                                                                        selected
                                                                    </c:if>
                                                                    >
                                                                ${category.getName()}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="field is-grouped">
                                            <div class="control">
                                                <button class="button is-primary">Submit</button>
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
        <script>
            document.querySelector("[name=thumbnail]").onchange = function () {
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.querySelector("#prvImg").src = e.target.result;
                };
                reader.readAsDataURL(this.files[0]);
            };
        </script>
        <%@ include file="Partials/Footer.jsp" %>
        <%@ include file="Partials/PostCreateScript.jsp" %>
    </body>
</html>
