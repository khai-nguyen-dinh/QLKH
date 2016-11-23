<%-- 
    Document   : addsanpham
    Created on : Nov 24, 2016, 1:50:01 AM
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
        <h1>Them san pham</h1>

        <form action="Controller?action=addedsanpham" method="POST">
            <input type="text" name="ma_sp" placeholder="ma sp"></br>
            <input type="text" name="ten_sp" placeholder="ten sp"></br>
            <input type="text" name="gia_sp" placeholder="gia sp"></br>
            <input type="text" name="nha_sx" placeholder="nha san xuat"></br>
            <input type="text" name="so_luong" placeholder="so luong"></br>
            <h3>loai san pham</h3>
            <select name="ma_l" id="ma_l">
                <c:forEach items="${loaisp}" var="loai">
                    <option value="${loai.ma_l}">${loai.ten_l}</option>
                </c:forEach>
            </select></br>
            <h3>chi nhanh</h3>
            <select name="ma_kh">
                <option value="0">Ha Noi</option>
                <option value="1">HCM</option>
            </select></br>
            <input type="submit" value="nhap"></br>
        </form>
    </center>
    </body>
</html>
