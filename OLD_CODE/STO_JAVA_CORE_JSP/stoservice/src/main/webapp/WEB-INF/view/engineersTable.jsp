<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Engineers</title>
    <jsp:include page="/WEB-INF/view/header.jsp"/>
</head>
<body>
<h1>All Engineers</h1><br/>
<a href="/add-engineer" class="btn btn-primary" type="button">Add Engineer</a>
<div class="table">
    <table class="table table-light table-striped table-hover">
        <caption>All Engineers</caption>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Function</th>
            <th scope="col">Category</th>
            <th scope="col">Education</th>
            <th scope="col">Experience</th>
            <th scope="col">General Experience</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="engineer" items="${requestScope.listEngineers}">
            <tr>
                <td><a href="/engineerCard?id=${engineer.id}"><c:out value="${engineer.id}"/></a>
                <td><c:out value="${engineer.firstName}"/>
                <td><c:out value="${engineer.lastName}"/>
                <td><c:out value="${engineer.function}"/>
                <td><c:out value="${engineer.category}"/>
                <td><c:out value="${engineer.education}"/>
                <td><c:out value="${engineer.experience}"/>
                <td><c:out value="${engineer.generalExperience}"/>
                <td>
                    <div class="d-flex justify-content-around">
                        <form action="/!!!!!!!!!!!!!" method="post">
                            <button class="btn btn-primary" name="id" value="${engineer.id}">Edit</button>
                        </form>
                        <form action="/!!!!!!!" method="get" name="id">
                            <button type="submit" class="btn btn-danger" name="id" value="${engineer.id}">Delete</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
