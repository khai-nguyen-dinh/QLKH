<%-- 
    Document   : addsanpham
    Created on : Nov 16, 2016, 7:59:55 PM
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
        <h1>Them loai san pham moi</h1>
        <h4 style="color: red">${status}</h4>
        <form action="Controller?action=addloai" method="POST">
            <input type="text" name="ma_l" placeholder="ma loai"></br>
            <input type="text" name="ten_l" placeholder="ten loại"></br>
            <input type="text" name="mota" placeholder="mo ta"></br>
            <input type="submit" value="nhap"></br>
        </form>
    </center>
    </body>
</html>
