

<%@page import="Entities.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Fruit fruit = (Fruit) request.getAttribute("fruit");
    
%>
<!DOCTYPE html>
<html>
    <%@ include file="Layout/Header.jsp" %>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1>Update Fruit</h1>
                    <form method="post" action="update">
                        <input type="hidden" name="id" value="<%= fruit.getId() %>"/>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" name="name" class="form-control" value="<%= fruit.getName() %>"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <input type="text" name="price" class="form-control" value="<%= fruit.getPrice() %>"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
                
    </body>
</html>
