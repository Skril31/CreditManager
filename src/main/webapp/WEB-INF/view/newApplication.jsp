<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Оформить заявку на кредит</title>
</head>
<body>
<h1>Оформить заявку на кредит</h1>
<form action="<c:url value='/submitApplication'/>" method="post">
  <label>ФИО:</label>
  <input type="text" name="client.fullName" required><br><br>
  <label>Паспортные данные:</label>
  <input type="text" name="client.passportData" required pattern="^\d{10}$"
         title="Введите паспорт в формате XXXXXXXXXX где X это цифры"><br><br>
  <label>Семейное положение:</label>
  <input type="text" name="client.maritalStatus" required><br><br>
  <label>Адрес прописки:</label>
  <input type="text" name="client.address" required><br><br>
  <label>Контактный телефон:</label>
  <input type="tel" name="client.phone" required pattern="^\+7\d{10}$"
  title="Введите номер телефона в формате +7XXXXXXXXXX"><br><br>
  <label>Сведения о занятости:</label><br><br>
  <label>Период работы:</label>
  <input type="text" name="employmentPeriod" required><br><br>
  <label>Должность:</label>
  <input type="text" name="jobPosition" required><br><br>
  <label>Название организации:</label>
  <input type="text" name="organizationName" required><br><br>
  <label>Сумма желаемого кредита:</label>
  <input type="number" name="desiredAmount" required><br><br>
  <input type="submit" value="Отправить заявку">
</form>
<br>
<a href="<c:url value='/'/>">На главную</a>
</body>
</html>