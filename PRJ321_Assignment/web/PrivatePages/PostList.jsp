<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Entities.Post"%>
<%@page import="java.util.ArrayList"%>
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
                    <div class="container" id="app">

                        <div class="tile is-ancestor">

                            <div class="tile is-parent">
                                <div class="tile is-child box">
                                    <!-- content start here -->
                                    <div class="box">
                                        <article class="media">
                                            <a class="button is-primary" href="${path}post/create">Create</a>
                                        </article>
                                    </div>
                                    <table class="table is-bordered is-fullwidth">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Author</th>
                                                <th>Title</th>
                                                <th>Category</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="post" items="${requestScope.posts}">
                                            <tr>
                                                <td><c:out value="${post.getId()}"/></td>
                                                <td><c:out value="${post.getAuthor().getName()}"/></td>
                                                <td><c:out value="${post.getTitle()}"/></td>
                                                <td><c:out value="${post.getCategory().getName()}"/></td>
                                                <td>
                                                    <a class="button" feature="update" target="${post.getId()}">
                                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="button" feature="delete" target="${post.getId()}">
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="button" @click="showDetail(${post.getId()})">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                    <%@ include file="/Components/Pagination.jsp" %>
                                    <!-- content end here -->
                                </div>
                            </div>
                        </div>

                    </div>
                </section>

            </div>
        </div>


        <div class="modal" id="previewer" v-bind:class="showPreviewer">
            <div class="modal-background" @click='hidePreviewer'></div>
            <div class="modal-card">
                <header class="modal-card-head">
                    <p class="modal-card-title">Post preview \#{{ id }}</p>
                    <button class="delete" aria-label="close" @click='hidePreviewer'></button>
                </header>
                <section class="modal-card-body">
                    <div class="content">
                        <h1>{{ post.title }}</h1>
                        <p>
                        <div class="title is-6">
                            <b>Author: </b>{{ post.author.name }}<br>
                            <b>Category: </b>{{ post.category.name }}<br>
                            <b>Description: </b>{{ post.description }}<br>
                        </div>
                        </p>
                        <p>
                            <img :src="post.thumbnail"/>
                            <span id="previewContent"></span>
                        </p>
                    </div>
                </section>
                <footer class="modal-card-foot">
                    <button class="button" @click='hidePreviewer'>Close</button>
                </footer>
            </div>
        </div>
        <script>
            var previewer = new Vue({
                el: "#previewer",
                data: {
                    id: 0,
                    post: {title: "", content: "", description: "", thumbnail: "", author: {name: ""}, category: {name: ""}},
                    isActive: false,
                },
                computed: {
                    showPreviewer: function () {
                        return { 'is-active' : this.isActive }
                    }
                },
                methods: {
                    hidePreviewer: function () {
                        this.isActive = false;
                    }
                    
                }
            });
            var app = new Vue({
                el: "#app",

                methods: {
                    showDetail: (id) => {
                        previewer.$data.id = id;
                        axios.post('list', {
                            id: id
                        })
                        .then(response => {
                            response = JSON.parse(response.data);
                            response.thumbnail = "${path}" + response.thumbnail;
                            previewer.$data.post = response;
                            document.querySelector("#previewContent").innerHTML = response.content;
                        })
                        .catch(error => console.log(error));
                        previewer.$data.isActive = true;
                    }
                }

            });

        </script>


        <%@ include file="Partials/Footer.jsp" %>
        <%@ include file="/Components/ActionScript.jsp" %>

    </body>
</html>
