<%-- 
    Document   : updatekh
    Created on : Nov 24, 2016, 2:10:55 AM
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
        <h1>Update kho hang</h1>

        <form action="Controller?action=updatedkh" method="POST">
            <input type="hidden" name="ma_kh" value="${kh.ma_kh}"></br>
            <input type="text" name="ten_kh" value="${kh.ten_kh}"></br>
            <input type="text" name="chi_nhanh" value="${kh.chi_nhanh}"></br>
            <input type="submit" value="nhap"></br>
        </form>
    </center>
    </body>
</html>
