<%@ page import="java.awt.*" %>
<%@ page import="model.User" %>
<%@ page import="service.Service" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 10.05.2020
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>АВТОРИЗАЦИЯ</title>
</head>
<br>
Введите логин и пароль<br><br>



<form action = "login" method="post">

    NAME: <input type="text" name="name">

    PASSWORD: <input type="text" name="password"><br><br>


    <input type="submit" value="submit">

</form>


</body>
</html>
