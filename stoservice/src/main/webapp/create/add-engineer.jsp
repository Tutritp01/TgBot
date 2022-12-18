<%@ page import="com.tutrit.stoservice.bean.Engineer" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Engineer</title>
</head>
<body>
<%
  Class car = new Engineer().getClass();
  Field[] fieldsCar = car.getDeclaredFields();
  out.println("<form method=\"post\">");
  for (Field field: fieldsCar) {
    String name = field.getName();
    if (name.equals("id")) continue;
    out.println("<label>" + name + ":</label><br>");
    out.println("<input type=\"text\" id=\"" + name +"\" name=\"" + name + "\"><br>");
  }
  out.println("<button type=\"submit\">Create</button>");
  out.println("</form>");
%>
<button onclick="location.href='/all-engineer'">All Engineer</button>
<div>
  <button onclick="location.href='/index.html'">Back to main</button>
</div>
</body>
</html>
