<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>АРМ менеджер по оформлению кредита</title>
</head>
<body>
<h1>АРМ менеджер по оформлению кредита</h1>
<ul>
    <li><a href="<c:url value='/newApplication'/>">Оформить заявку на кредит</a></li>
    <li><a href="<c:url value='/clientsList'/>">Список всех клиентов</a></li>
    <li><a href="<c:url value='/searchClient'/>">Поиск клиента</a></li>
    <li><a href="<c:url value='/applications'/>">Список заявок</a></li>
    <li><a href="<c:url value='/signedContracts'/>">Список подписанных договоров</a></li>
</ul>
</body>
</html>