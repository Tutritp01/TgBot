<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Engineer</title>
</head>
<body>
<br>
<form action="/add-engineer" method="POST">
  <label for="firstName">firstName:</label><br>
  <input type="text" id="firstName" name="firstName"><br>
  <label for="lastName">lastName:</label><br>
  <input type="text" id="lastName" name="lastName"><br>
  <label for="function">function:</label><br>
  <input type="text" id="function" name="function"><br>
  <label for="category">category:</label><br>
  <input type="text" id="category" name="category"><br>
  <label for="education">education:</label><br>
  <input type="text" id="education" name="education"><br>
  <label for="experience">experience:</label><br>
  <input type="text" id="experience" name="experience"><br>
  <label for="generalExperience">generalExperience:</label><br>
  <input type="text" id="generalExperience" name="generalExperience"><br>
  <input type="submit" value="Create"><br>
</form>
<br>
<div>
  <button onclick="location.href='/index.jsp'">Back to main</button><br>
</div>
<br>
</body>
</html>
