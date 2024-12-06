<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Кредитные договоры</title>
</head>
<body>
<h1>Список кредитных договоров</h1>

<!-- Форма для фильтрации -->
<form action="<c:url value='/contracts'/>" method="get">
  <label for="filter">Фильтр по статусу:</label>
  <select name="filter" id="filter">
    <option value="">Все</option>
    <option value="Подписан" ${param.filter == 'Подписан' ? 'selected' : ''}>Подписан</option>
    <option value="Не подписан" ${param.filter == 'Не подписан' ? 'selected' : ''}>Не подписан</option>
  </select>
  <input type="submit" value="Применить фильтр">
</form>

<br>

<table border="1">
  <tr>
    <th>ФИО клиента</th>
    <th>Сумма кредита</th>
    <th>Дата подписания</th>
    <th>Статус</th>
    <th>Действие</th>
  </tr>
  <c:forEach var="contract" items="${contracts}">
    <tr>
      <td>${contract.creditApplication.client.fullName}</td>
      <td>${contract.creditApplication.approvedAmount}</td>
      <td>${contract.signDate}</td>
      <td>${contract.signatureStatus}</td>
      <td>
        <c:if test="${contract.signatureStatus == 'Не подписан' && contract.creditApplication.status =='Одобрен'}">
          <form action="<c:url value='/contracts/sign'/>" method="post" style="display:inline;">
            <input type="hidden" name="contractId" value="${contract.id}">
            <input type="submit" value="Подписать">
          </form>
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>

<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>