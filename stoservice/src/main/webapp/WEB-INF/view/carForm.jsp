<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CarForm</title>
    <jsp:include page="/WEB-INF/view/header.html"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="needs-validation was-validated" action="/carForm" method="POST" novalidate>
        <div class="col-md-20">
            <label for="id" class="form-label">Id</label>
            <input type="text" class="form-control" id="id" required placeholder="id" value="${requestScope.id}">
        </div>
        <div class="col-md-12">
            <label for="owner" class="form-label">Owner</label>
            <input type="text" class="form-control" id="owner" required placeholder="owner" value="${requestScope.owner}">
        </div>
        <div class="col-md-12">
            <label for="vin" class="form-label">Vin</label>
            <input type="text" class="form-control" id="vin" required placeholder="vin" value="${requestScope.vin}">
        </div>
        <div class="col-md-12">
            <label for="plateNumber" class="form-label">PlateNumber</label>
            <input type="text" class="form-control" id="plateNumber" required placeholder="plate number" value="${requestScope.plateNumber}">
        </div>
        <div class="col-md-12">
            <label for="brand" class="form-label">Brand</label>
            <input type="text" class="form-control" id="brand" required placeholder="brand" value="${requestScope.brand}">
        </div>
        <div class="col-md-12">
            <label for="model" class="form-label">Model</label>
            <input type="text" class="form-control" id="model" required placeholder="model" value="${requestScope.model}">
        </div>
        <div class="col-md-12">
            <label for="generation" class="form-label">Generation</label>
            <input type="text" class="form-control" id="generation" required placeholder="generation" value="${requestScope.generation}">
        </div>
        <div class="col-md-12">
            <label for="modification" class="form-label">Modification</label>
            <input type="text" class="form-control" id="modification" required placeholder="modification" value="${requestScope.modification}">
        </div>
        <div class="col-md-12">
            <label for="engine" class="form-label">Engine</label>
            <input type="text" class="form-control" id="engine" required placeholder="engine" value="${requestScope.engine}">
        </div>
        <div class="col-md-12">
            <label for="year" class="form-label">Year</label>
            <select class="form-control form-select" id="year" aria-label="Choose year">
                <option selected>Choose year</option>
                <c:forEach var="index" begin="1990" end="2022">
                    <option value="index">${index}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
