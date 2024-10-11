<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="addEmployee" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br>

    <label for="birthDate">Birth Date:</label><br>
    <input type="date" id="birthDate" name="birthDate" required><br>

    <label for="address">Address:</label><br>
    <input type="text" id="address" name="address" required><br>

    <label for="socialSecurityNumber">Social Security Number:</label><br>
    <input type="text" id="socialSecurityNumber" name="socialSecurityNumber" required><br>

    <label for="hireDate">Hire Date:</label><br>
    <input type="date" id="hireDate" name="hireDate" required><br>

    <label for="position">Position:</label><br>
    <input type="text" id="position" name="position" required><br>

    <label for="salary">Salary:</label><br>
    <input type="number" id="salary" name="salary" step="0.01" required><br>

    <label for="children">Children:</label><br>
    <input type="number" id="children" name="children" required><br><br>

    <button type="submit">Submit</button>
</form>
</body>
</html>
