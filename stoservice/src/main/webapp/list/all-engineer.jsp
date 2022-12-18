<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>List Engineers</title>
</head>
<body>
<button onclick="location.href='/add-engineer'">Add Engineer</button>
<h1><c:out value="${requestScope.successMessage}"/></h1>
<h5><c:out value="${requestScope.successMessageFromForward}"/></h5>
    <table>
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">firstName</th>
            <th scope="col">lastName</th>
            <th scope="col">function</th>
            <th scope="col">category</th>
            <th scope="col">education</th>
            <th scope="col">experience</th>
            <th scope="col">generalExperience</th>
        </tr>
        </thead>
        <c:forEach var="engineer" items="${requestScope.listEngineers}">
            <tbody>
            <tr>
                <td><c:out value="${engineer.idEngineer}"/></td>
                <td><c:out value="${engineer.firstName}"/></td>
                <td><c:out value="${engineer.lastName}"/></td>
                <td><c:out value="${engineer.function}"/></td>
                <td><c:out value="${engineer.category}"/></td>
                <td><c:out value="${engineer.education}"/></td>
                <td><c:out value="${engineer.experience}"/></td>
                <td><c:out value="${engineer.generalExperience}"/></td>
                <td>
                    <button name="id" value="${engineer.idEngineer}"
                            formmethod = "post" onclick="location.href='/edit-engineer'">Edit</button>
                    <button name="id" value="${engineer.idEngineer}"
                            formmethod = "post" onclick="location.href='/delete-engineer'">Delete</button>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
<button onclick="location.href='/index.html'">Back to main</button>
</body>
</html>
