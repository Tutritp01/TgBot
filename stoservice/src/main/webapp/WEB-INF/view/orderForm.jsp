<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OrderForm</title>
    <jsp:include page="/WEB-INF/view/header.html"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="needs-validation was-validated" action="/orderForm" method="POST" novalidate>

        <div class="col-md-12">
            <label for="customer" class="form-label">Customer</label>
            <input type="text" class="form-control" id="customer" required placeholder="customer" value="${requestScope.customer}">
        </div>
        <div class="col-md-12">
            <label for="user" class="form-label">User</label>
            <input type="text" class="form-control" id="user" required placeholder="user" value="${requestScope.user}">
        </div>
        <div class="col-md-12">
            <label for="car" class="form-label">Car</label>
            <input type="text" class="form-control" id="car" required placeholder="car" value="${requestScope.car}">
        </div>
        <div class="col-md-12">
            <label for="engineers" class="form-label">Engineers</label>
            <input type="text" class="form-control" id="engineers" required placeholder="engineers" value="${requestScope.engineers}">
        </div>
        <div class="col-md-12">
            <label for="orderStatus" class="form-label">OrderStatus</label>
            <input type="text" class="form-control" id="orderStatus" required placeholder="orderStatus" value="${requestScope.orderStatus}">
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
