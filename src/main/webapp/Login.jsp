<%--
  Created by IntelliJ IDEA.
  User: gaikw
  Date: 18-11-2021
  Time: 05:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page JSP</title>
    <link rel="stylesheet" href="Login.css" />
</head>
<body class="container">
<div class="login_box">

    <h1>Login Servlet</h1>
    <form action="LoginServlet" method="post" autocomplete="off">
        <div class="input_box">
            <label for="username">Username : </label>
            <input type="text" name="username" id="username" class="input" />
        </div>
        <div class="input_box">
            <label for="password">Password : </label>
            <input type="text" name="password" id="password" class="input" />
        </div>
        <div>
            <p style="color: red; font-size: 13px; text-align: center;">
                <%= request.getAttribute("error") != null ? request.getAttribute("error")  : "" %>
            </p>
        </div>
        <div>
            <input type="submit" value="Login" class="btn" />
        </div>
    </form>
</div>

</body>
</html>
