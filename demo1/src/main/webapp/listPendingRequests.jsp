<%--
  Created by IntelliJ IDEA.
  User: ycode
  Date: 11/10/2024
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List des demandes de congees</title>
</head>
<body>
<h1>List des demandes de congees</h1>

<table>
  <tr>
    <th>Employee</th>
    <th>Start Date</th>
    <th>End Date</th>
    <th>Reason</th>
    <th>Action</th>
  </tr>
  <c:forEach var="demande" items="${pendingRequests}">
    <tr>
      <td>${demande.employee.name}</td>
      <td>${demande.dateDebut}</td>
      <td>${demande.dateFin}</td>
      <td>${demande.motif}</td>
      <td>
        <form action="processConge" method="post">
          <input type="hidden" name="demandeId" value="${demande.id}">
          <button type="submit" name="action" value="approve">Approve</button>
          <button type="submit" name="action" value="reject">Reject</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
