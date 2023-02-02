<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OrderDelete</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
</head>
<body>

<div class="position-absolute top-50 start-50 translate-middle">
<h3>Are you sure delete Order?</h3>
    <form action="/orderDelete" method="post">
        <button class="btn btn-lg btn-danger" name="id" value="${param.get("id")}">Delete</button>
    </form>
    <a href="/orderCard" class="btn btn-lg btn-success" type="button">Cancel</a>
</div>
</body>
</html>