<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <jsp:include page="header.html"/>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="px-4 py-3" action="" method="post">
        <div class="mb-3">
            <label for="exampleDropdownFormEmail1" class="form-label">Login</label>
            <input type="login" class="form-control" id="exampleDropdownFormEmail1" placeholder="login">
        </div>
        <div class="mb-3">
            <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="password">
        </div>
        <div class="mb-3">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="dropdownCheck">
                <label class="form-check-label" for="dropdownCheck">
                    Remember me
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
    <div class="dropdown-divider"></div>
</div>
</body>
</html>
