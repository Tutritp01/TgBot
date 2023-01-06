<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AllCustomers</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
</head>
<body>
<h1>All Customers</h1><br/>
<a href="/customerForm" class="btn btn-primary" type="button">Add</a>
<div class="table">
    <table class="table table-light table-striped table-hover">
        <caption>All Customers</caption>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">City</th>
            <th scope="col">PhoneNumber</th>
            <th scope="col">Email</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="customer" items="${requestScope.customers}">
            <tr>
                <td><a href="/customerCard"><c:out value="${customer.id}"/></a>
                <td><c:out value="${customer.name}"/>
                <td><c:out value="${customer.city}"/>
                <td><c:out value="${customer.phoneNumber}"/>
                <td><c:out value="${customer.email}"/>
                <td>
                    <div class="d-flex justify-content-around">
                        <form action="/customerForm" method="post">
                            <button class="btn btn-primary" name="id" value="${customer.id}">Edit</button>
                        </form>
                        <form action="/customerDelete" method="get" name="id">
                            <button type="submit" class="btn btn-danger" name="id" value="${customer.id}">Delete
                            </button>
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
