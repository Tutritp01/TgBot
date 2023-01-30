<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CarForm</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="was-validated" action="/carCard" method="post">
        <div class="col-md-12">
            <input type="text" class="form-control" name="id" required placeholder="id"
                   value="${requestScope.get("id")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="owner" required placeholder="owner"
                   value="${requestScope.get("owner")}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="vin" required placeholder="vin"
                   value="${requestScope.get("vin")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="plateNumber" required placeholder="plate number"
                   value="${requestScope.get("plateNumber")}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="brand" required placeholder="brand"
                   value="${requestScope.get("brand")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="model" required placeholder="model"
                   value="${requestScope.get("model")}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="generation" required placeholder="generation"
                   value="${requestScope.get("generation")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="modification" required placeholder="modification"
                   value="${requestScope.get("modification")}">
        </div>
        <div>
            <input type="text" class="form-control" name="engine" required placeholder="engine"
                   value="${requestScope.get("engine")}">
        </div>
        <div class="col-md-12 py-1">
            <select class="form-select" required name="year" aria-label="Choose year">
                <option value="${requestScope.get("year")}">${requestScope.get("year")}</option>
                <c:forEach var="index" begin="1990" end="2022">
                    <option value="${index}">${index}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            <div class="col order-first">
                <button class="btn btn-success" type="submit">Save</button>
            </div>
            <div class="col">
                <button class="btn btn-primary" type="reset">Clear</button>
            </div>
            <div class="col order-last">
                <a href="/carTable" class="btn btn-danger" type="button">Cancel</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
