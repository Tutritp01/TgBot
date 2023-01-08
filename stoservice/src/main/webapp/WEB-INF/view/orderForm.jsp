<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OrderForm</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="needs-validation was-validated" action="/orderCard" method="post" novalidate>

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
        <div class="col-md-12 py-1">
             <label for="orderStatus" class="form-label">OrderStatus</label>
             <input type="text" class="form-control" name="orderStatus" required placeholder="orderStatus" value="${requestScope.get("orderStatus")}">
        </div>
        <div class="row">
              <div class="col order-first">
                  <button class="btn btn-success" type="submit">Save</button>
              </div>
              <div class="col">
                  <button class="btn btn-primary" type="reset">Clear</button>
              </div>
              <div class="col order-last">
                  <a href="/orderTable" class="btn btn-danger" type="button">Cancel</a>
              </div>
        </div>
    </form>
</div>
</body>
</html>
