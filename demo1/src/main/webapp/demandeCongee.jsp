<%--
  Created by IntelliJ IDEA.
  User: ycode
  Date: 11/10/2024
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demander un Congee</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <div class="navbar">
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </nav>
    </div>
    <div class="formulaire">
        <form action="submitConge" method="post">
            <label for="employe_name">Employeeee Name:</label>
            <input type="text" id="employe_name" name="employe_name" required><br>

            <label for="conge_type">Conge Type:</label>
            <input type="text" id="conge_type" name="conge_type" required><br>

            <label for="dateDebut">Start Date:</label>
            <input type="date" id="dateDebut" name="dateDebut" required><br>

            <label for="dateFin">End Date:</label>
            <input type="date" id="dateFin" name="dateFin" required><br>

            <label for="motif">Reason:</label>
            <textarea id="motif" name="motif" required></textarea><br>

            <input type="hidden" name="employeeId" value="1">


            <input type="submit" value="Submit Request">
        </form>
    </div>

</body>
</html>
