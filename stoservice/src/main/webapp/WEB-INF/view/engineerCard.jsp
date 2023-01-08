<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Engineer</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
    <form class="was-validated" action="/engineerCard" method="post">
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="firstName" required placeholder="First Name"
                   value="${requestScope.engineer.firstName}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="lastName" required placeholder="Last Name"
                   value="${requestScope.engineer.lastName}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="function" required placeholder="Function"
                   value="${requestScope.engineer.function}">
        </div>
        <div class="col-md-12">
            <input type="text" class="form-control" name="category" required placeholder="Category"
                   value="${requestScope.engineer.category}">
        </div>
        <div class="col-md-12 py-1">
            <input type="text" class="form-control" name="education" required placeholder="Education"
                   value="${requestScope.engineer.education}">
        </div>
        <div class="col-md-12 py-1">
            <select class="form-select" required name="experience" aria-label="Experience">
                <option value="${requestScope.engineer.experience}">${requestScope.engineer.experience}</option>
                <c:forEach var="index" begin="0" end="80">
                    <option value="${index}">${index}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-12 py-1">
            <select class="form-select" required name="generalExperience" aria-label="General Experience">
                <option value="${requestScope.engineer.generalExperience}">${requestScope.engineer.generalExperience}</option>
                <c:forEach var="index" begin="0" end="80">
                    <option value="${index}">${index}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row">
            <div class="col order-first">
                <button class="btn btn-success" type="submit">Edit</button>
            </div>
            <div class="col">
                <a href="/engineerDelete" class="btn btn-danger" type="submit">Delete</a>
            </div>
            <div class="col order-last">
                <a href="/all-engineers" class="btn btn-success" type="button">All Engineers</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
