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
<a href="carForm.jsp" class="btn btn-primary" type="button">Add</a>
<div class="table">
    <table class="table table-light table-striped table-bordered border-primary">
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
        <c:forEach var="car" items="${requestScope.cars}">
            <tbody>
            <tr>
                <td><a href="carForm.jsp"><c:out value="${car.id}"/></a>
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
                        <a href="carForm.jsp" class="btn btn-primary" type="button">Edit</a>
                        <a href="carDelete.jsp" class="btn btn-danger" type="button">Delete</a>
                    </div>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
