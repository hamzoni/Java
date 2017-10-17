<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
        </thead>
        <c:forEach var="prd" items="${requestScope.list}">
            <tr>
                <td>${prd.getProduct_id()}</td>
                <td>${prd.getName()}</td>
                <td>${prd.getPrice()}</td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/order/create">
                        <input type="hidden" value="${prd.getProduct_id()}" name="id"/>
                        <input type="submit"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
