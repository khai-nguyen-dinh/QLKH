<%-- 
    Document   : dnnhanvien
    Created on : Nov 16, 2016, 5:40:24 AM
    Author     : khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <p>Chon kho hang</p>
            <select name="kho_id" id="kho_id">
                <c:forEach items="${khos}" var="kho">
                    <option value="${kho.ma_kh}">${kho.ten_kh}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Login"></br>
        </form>
    </center>
    </body>
</html>
