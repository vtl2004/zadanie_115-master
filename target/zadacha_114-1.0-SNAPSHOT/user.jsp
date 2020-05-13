<%@ page import="service.Service" %><%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 11.05.2020
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User</title>
</head>
<body>



<h1>Страница user : ${user.name}</h1>

id: ${user.id}<br>
name: ${user.name}<br>
password: ${user.password}<br>
age: ${user.age}<br>
role: ${user.role}


</body>
</html>
