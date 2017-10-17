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
            <th>Name</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Date</th>
        </thead>
        <c:forEach var="item" items="${sessionScope.cart}">
            <tr>
                <td>${item.getPrd().getName()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getQuantity()}</td>
                <td>${sessionScope.order.getOrder_date()}</td>
            </tr>
        </c:forEach>
    </table>
    <a>Save</a>
</body>
</html>
