<%-- 
    Document   : dnnhanvien
    Created on : Nov 16, 2016, 5:40:24 AM
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
        <h1>Nhan vien dang nhap</h1>
        <h4 style="color: red">${status}</h4>
        <form action="Controller?action=dnnhanvien" method="POST">
            <input type="text" name="username" placeholder="user name"></br>
            <input type="password" name="password" placeholder="password"></br>
            <input type="submit" value="Login"></br>
        </form>
    </center>
    </body>
</html>
