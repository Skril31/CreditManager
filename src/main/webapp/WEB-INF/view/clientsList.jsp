<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Список клиентов</title>
</head>
<body>
<h1>Список всех клиентов</h1>
<table border="1">
  <tr>
    <th>ФИО</th>
    <th>Паспортные данные</th>
    <th>Семейное положение</th>
    <th>Телефон</th>
    <th>Адрес</th>
  </tr>
  <c:forEach var="client" items="${clients}">
    <tr>
      <td>${client.fullName}</td>
      <td>${client.passportData}</td>
      <td>${client.maritalStatus}</td>
      <td>${client.phone}</td>
      <td>${client.address}</td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>