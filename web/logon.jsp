<%-- 
    Document   : logon
    Created on : 25.04.2018, 19:10:43
    Author     : Billy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log On</title>
    </head>
    <body>
        <h1>Log on here</h1>
        <p>Go <a href="index.html">back</a> to Mainpage</p>
        <form action="Controller" method="POST">
            UserId:
            <input type="text" name="userId"><br>
            Password:
            <input type="password" name="passwd"><br>
            <input type="submit" value="Submit"><br>
        </form>
        <p>If you don not have a account yet you can create one <a href="register.html">here</a></p>
    </body>
</html>
