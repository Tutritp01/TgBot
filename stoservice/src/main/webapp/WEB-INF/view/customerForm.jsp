<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <form class="was-validated" action="/customerCard" method="post">
        <div class="col-md-12">
            <input type="text" class="form-control" name="id" required placeholder="id"
                   value="${requestScope.get("id")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="name" required placeholder="name"
                   value="${requestScope.get("name")}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="city" required placeholder="city"
                   value="${requestScope.get("city")}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="phoneNumber" required placeholder="phoneNumber"
                   value="${requestScope.get("phoneNumber")}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="email" required placeholder="email"
                   value="${requestScope.get("email")}">
        </div>
        <br><br>
        <div class="row">
            <div class="col order-first">
                <form action="/customerCard" method="post">
                    <button class="btn btn-danger" value="${param.get("id")}
                     ${param.get("name")}
                     ${param.get("phoneNumber")}
                     ${param.get("city")}
                     ${param.get("email")}"
                    >Save
                    </button>
                </form>
            </div>

            <div class="col">
                <a href="/customerForm" class="btn btn-danger" type="button">Clear</a>
            </div>
            <div class="col order-last">
                <a href="/customerTable" class="btn btn-danger" type="button">Cancel</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
