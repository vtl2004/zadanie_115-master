<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 10.05.2020
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "add" method="post">
   NAME:  <input  type="text" name="name">
    PASSWORD: <input  type="text" name="password">
    AGE: <input  type="text" name="age"><br>
   ROLE ADMIN:  <input  type="radio" name="role"  value="admin" >
ROLE USER: <input  type="radio" name="role" value="user">
    <input type="submit" value="SUBMIT"><br>

</form>
</body>
</html>
