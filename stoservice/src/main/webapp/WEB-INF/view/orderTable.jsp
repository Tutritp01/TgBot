<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OrderTable</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>

</head>
<body>
<h1>View all order</h1><br/>
<a href="/orderForm" class="btn btn-primary" type="button">Add</a>
<div class="table">
    <table class="table table-light table-striped table-hover">
        <caption>All order</caption>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Customer</th>
            <th scope="col">User</th>
            <th scope="col">Car</th>
            <th scope="col">OrderStatus</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="order" items="${requestScope.orders}">
            <tr>
                <td><a href="/orderCard"><c:out value="${order.id}"/></a>
                <td><c:out value="${order.customer}"/>
                <td><c:out value="${order.user}"/>
                <td><c:out value="${order.car}"/>
                <td>
                    <div class="d-flex justify-content-around">
                        <form action="/orderForm" method="post">
                            <button class="btn btn-primary" name="id" value="${order.id}">Edit</button>
                        </form>
                        <form action="/orderDelete" method="get" name="id">
                            <button type="submit" class="btn btn-danger" name="id" value="${order.id}">Delete</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
