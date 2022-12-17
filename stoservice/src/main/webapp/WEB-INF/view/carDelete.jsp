<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CarDelete</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <jsp:include page="header.html"/>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <button type="button" class="btn btn-lg btn-danger" data-bs-toggle="popover" data-bs-title="Warning"
            data-bs-content="Do you really want to delete the car??" aria-describedby="popover892921">Delete
    </button>
    <button type="button" class="btn btn-lg btn-success">Cancel</button>
</div>
</body>
</html>
