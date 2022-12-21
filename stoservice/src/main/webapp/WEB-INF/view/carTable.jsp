<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AllCars</title>
    <jsp:include page="header.html"/>
</head>
<body>
<h1>All Cars</h1><br/>
<button type="button" class="btn btn-primary">Add</button>
<div class="table">
    <table class="table table-light table-striped table-bordered border-primary">
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
        <c:forEach var="car" items="${requestScope.cars}">
            <tbody>
            <tr>
                <td><c:out value="${car.id}"/>
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
                    <div style="text-align: center">
                        <button type="button" class="btn btn-primary">Edit</button>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
