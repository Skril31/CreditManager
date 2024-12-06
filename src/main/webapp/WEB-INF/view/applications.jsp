<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Заявки</title>
</head>
<body>
<h1>Заявки на кредит</h1>

<!-- Форма для фильтрации -->
<form action="<c:url value='/applications'/>" method="get">
  <label for="status">Фильтр по статусу:</label>
  <select name="status" id="status">
    <option value="">Все</option>
    <option value="Одобрен" ${param.status == 'Одобрен' ? 'selected' : ''}>Одобрен</option>
    <option value="Не одобрен" ${param.status == 'Не одобрен' ? 'selected' : ''}>Не одобрен</option>
  </select>
  <input type="submit" value="Применить фильтр">
</form>

<br>

<table border="1">
  <tr>
    <th>ФИО</th>
    <th>Паспортные данные</th>
    <th>Номер телефона</th>
    <th>Адрес</th>
    <th>Семейное положение</th>
    <th>Название организации</th>
    <th>Должность</th>
    <th>Период работы</th>
    <th>Желаемая сумма кредита</th>
    <th>Одобренная сумма кредита</th>
    <th>Срок кредита (дни)</th>
    <th>Статус</th>
  </tr>
  <c:forEach var="application" items="${applications}">
    <tr>
      <td>${application.client.fullName}</td>
      <td>${application.client.passportData}</td>
      <td>${application.client.phone}</td>
      <td>${application.client.address}</td>
      <td>${application.client.maritalStatus}</td>
      <td>${application.organizationName}</td>
      <td>${application.jobPosition}</td>
      <td>${application.employmentPeriod}</td>
      <td>${application.desiredAmount}</td>
      <td>${application.approvedAmount}</td>
      <td>${application.paymentTerm}</td>
      <td>${application.status}</td>
    </tr>
  </c:forEach>
</table>

<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>