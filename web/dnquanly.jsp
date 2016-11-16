<%-- 
    Document   : dnquanly
    Created on : Nov 16, 2016, 5:40:33 AM
    Author     : khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Quan ly dang nhap</h1>
        <h4 style="color: red">${status}</h4>
        <form action="Controller?action=dnquanly" method="POST">
            <input type="text" name="username" placeholder="user name"></br>
            <input type="password" name="password" placeholder="password"></br>
            <input type="submit" value="Login"></br>
        </form>
    </center>
    </body>
</html>
