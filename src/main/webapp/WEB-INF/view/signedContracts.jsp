<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Подписанные договоры</title>
</head>
<body>
<h1>Список подписанных кредитных договоров</h1>
<table border="1">
  <tr>
    <th>ФИО клиента</th>
    <th>Сумма кредита</th>
    <th>Дата подписания</th>
    <th>Статус</th>
  </tr>
  <c:forEach var="contract" items="${signedContracts}">
    <tr>
      <td>${contract.creditApplication.client.fullName}</td>
      <td>${contract.creditApplication.approvedAmount}</td>
      <td>${contract.signDate}</td>
      <td>${contract.signatureStatus}</td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>