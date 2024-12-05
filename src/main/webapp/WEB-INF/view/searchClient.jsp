<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Поиск клиента</title>
</head>
<body>
<h1>Поиск клиента</h1>
<form action="<c:url value='/searchClient'/>" method="get">
  <label>Введите ФИО, телефон(в формате +7XXXXXXXXXX) или паспортные данные:</label>
  <input type="text" name="query" required>
  <input type="submit" value="Найти">
</form>

<c:if test="${not empty searchClient}">
  <h2>Результаты поиска:</h2>
  <table border="1">
    <tr>
      <th>ФИО</th>
      <th>Паспортные данные</th>
      <th>Телефон</th>
      <th>Адрес</th>
      <th>Семейное положение</th>
    </tr>
    <tr>
      <c:forEach var="client" items="${searchClient}">
      <td>${client.fullName}</td>
      <td>${client.passportData}</td>
      <td>${client.phone}</td>
      <td>${client.address}</td>
      <td>${client.maritalStatus}</td>
    </tr>
    </c:forEach>
  </table>
</c:if>
<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>