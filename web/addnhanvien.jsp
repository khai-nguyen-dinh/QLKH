<%-- 
    Document   : addnhanvien
    Created on : Nov 16, 2016, 7:59:35 PM
    Author     : khai
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="Controller?action=show"/>">HOME</a>
    <center>
        <h1>Them nhan vien moi</h1>
        <h4 style="color: red">${status}</h4>
        <form action="Controller?action=addnhanvien" method="POST">
            <input type="text" name="ma_nv" placeholder="ma nhan vien"></br>
            <input type="text" name="ten" placeholder="ten nhan vien"></br>
            <input type="text" name="username" placeholder="username"></br>
            <input type="password" name="password" placeholder="password"></br>
            <select name="ma_kh">
                <option value="0">Da nang</option>
                <option value="1">HCM</option>
            </select>
            <input type="submit" value="nhap"></br>
        </form>
    </center>
    </body>
</html>
