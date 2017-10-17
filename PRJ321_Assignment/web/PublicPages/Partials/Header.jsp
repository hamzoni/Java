<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="hero is-info is-small">
    <div class="hero-head">
        <nav class="navbar">
            <div class="container">
                <div class="navbar-brand">
                    <a class="navbar-item" href="${path}home">
                        <img src="${path}Assets/images/logo.png" alt="Logo">
                    </a>
                    <span class="navbar-burger burger" data-target="navbarMenuHeroB">
                        <span></span>
                        <span></span>
                        <span></span>
                    </span>
                </div>
                <div id="navbarMenuHeroB" class="navbar-menu">
                    <div class="navbar-end">
                        <span class="navbar-item">
                            <a class="button is-info is-inverted" href="${path}login">
                                <span class="icon">
                                    <i class="fa fa-sign-in"></i>
                                </span>
                                <span>Login</span>
                            </a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </div>

    <div class="hero-body">
        <div class="container has-text-centered">
            <p class="title">
                <img src="${path}Assets/images/logo.png" alt="Logo">
            </p>
            <p class="subtitle">
                PRJ321 ASSIGNMENT: MULTIUSERS BLOG
            </p>
        </div>
    </div>

    <div class="hero-foot">
        <nav class="tabs is-boxed is-fullwidth">
            <div class="container">
                <ul>
                    <li
                        <c:if test="${param.id == null}">
                            class="is-active"
                        </c:if>
                    >
                        <a href="${path}home">Home</a>
                    </li>
                    <c:forEach var="category" items="${requestScope.categories}">
                        <li 
                            <c:if test="${param.id == category.getId()}">
                                class="is-active"
                            </c:if>
                            <c:if test="${requestScope.post != null}">
                                <c:if test="${category.getId() == requestScope.post.getCategory().getId()}">
                                    class="is-active"
                                </c:if>
                            </c:if>
                        >
                            <a href="${path}category?id=${category.getId()}">
                                ${category.getName()}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
    </div>
</section>