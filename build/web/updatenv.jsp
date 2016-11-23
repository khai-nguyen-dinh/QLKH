<%-- 
    Document   : updatenv
    Created on : Nov 22, 2016, 6:33:30 PM
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
    <centet><h1>Update nhan vien</h1>
    
        <form action="Controller?action=updatenhanvien" method="POST">
            <input type="hidden" name="ma_nv" value="${nv.ma_nv}"></br>
            <input type="text" name="ten" value="${nv.ten}"></br>
            <input type="text" name="username" value="${nv.username}"></br>
            <input type="password" name="password" value="${nv.password}"></br>
            <select name="ma_kh">
                <option value="0">Da nang</option>
                <option value="1">HCM</option>
            </select>
            <input type="submit" value="nhap"></br>
        </form>
    </centet>
    </body>
</html>
