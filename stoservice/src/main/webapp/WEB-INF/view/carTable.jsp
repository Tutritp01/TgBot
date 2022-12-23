<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AllCars</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
</head>
<body>
<h1>All Cars</h1><br/>
<a href="/carForm" class="btn btn-primary" type="button">Add</a>
<div class="table">
    <table class="table table-light table-striped table-hover">
        <caption>All Cars</caption>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Owner</th>
            <th scope="col">Vin</th>
            <th scope="col">PlateNumber</th>
            <th scope="col">Brand</th>
            <th scope="col">Model</th>
            <th scope="col">Generation</th>
            <th scope="col">Modification</th>
            <th scope="col">Engine</th>
            <th scope="col">Year</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="car" items="${requestScope.cars}">
            <tr>
                <td><a href="/carCard"><c:out value="${car.id}"/></a>
                <td><c:out value="${car.owner}"/>
                <td><c:out value="${car.vin}"/>
                <td><c:out value="${car.plateNumber}"/>
                <td><c:out value="${car.brand}"/>
                <td><c:out value="${car.model}"/>
                <td><c:out value="${car.generation}"/>
                <td><c:out value="${car.modification}"/>
                <td><c:out value="${car.engine}"/>
                <td><c:out value="${car.year}"/>
                <td>
                    <div class="d-flex justify-content-around">
                        <form action="/carForm" method="post">
                            <button class="btn btn-primary" name="id" value="${car.id}">Edit</button>
                        </form>
                        <form action="/carDelete" method="get" name="id">
                            <button type="submit" class="btn btn-danger" name="id" value="${car.id}">Delete</button>
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
