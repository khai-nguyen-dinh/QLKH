<%-- 
    Document   : updatelsp
    Created on : Nov 24, 2016, 1:41:40 AM
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
        <h1>Update loai san pham</h1>
        <form action="Controller?action=updatedlsp" method="POST">
            <input type="hidden" name="ma_l" value="${lsp.ma_l}"></br>
            <input type="text" name="ten_l" value="${lsp.ten_l}"></br>
            <input type="text" name="mota" value="${lsp.mota}"></br>
            <input type="submit" value="nhap"></br>
        </form>
    </center>
    </body>
</html>
