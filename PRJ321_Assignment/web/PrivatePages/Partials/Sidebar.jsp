<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="menu">
    <p class="menu-label">
        Menu
    </p>
    <ul class="menu-list">
        <li><a href="${pageContext.request.contextPath}/category/list">Category</a></li>
        <li><a href="${pageContext.request.contextPath}/post/list">Post</a></li>
        <li><a href="${pageContext.request.contextPath}/user/list">User</a></li>
        <li><a href="${pageContext.request.contextPath}/profile">Account</a></li>
    </ul>
</aside>
