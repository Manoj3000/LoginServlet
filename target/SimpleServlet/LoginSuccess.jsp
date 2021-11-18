<%--
  Created by IntelliJ IDEA.
  User: gaikw
  Date: 17-11-2021
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success page</title>
    <link rel="stylesheet" href="Login.css" />
</head>
<body>
    <div class="container">
        <div class="box">
            <h2>Hi <%= request.getAttribute("user") %>, Login Success</h2>
            <a href="Login.html">Login Page</a>
        </div>
    </div>
</body>
</html>
