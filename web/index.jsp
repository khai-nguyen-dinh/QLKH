<%-- 
    Document   : index
    Created on : Nov 16, 2016, 5:26:01 AM
    Author     : khai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Quan ly nhan vien</h1>
        <table border="4">
            <tr>
                <td><a href="<c:url value="Controller?action=quanly"/>">Quan ly</a></td>
                <td><a href="<c:url value="Controller?action=nhanvien"/>">Nhan vien</a></td>
            </tr>
        </table>
    </center>
    </body>
</html>
