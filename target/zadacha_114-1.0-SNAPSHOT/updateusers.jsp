<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 10.05.2020
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="update" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}">
    <input type="text" name="password" value="${param.password}">
    <input type="text" name="age" value="${param.age}">
    role: ${param.role} <br>
 admin: <input type="radio" name="role" value="admin">
    user: <input type="radio" name="role" value="user"><br>
    <%--   <input type="hidden" name="_method" value="put">--%>
    <input type="submit" value="Обновить">
</form>

</body>
</html>
