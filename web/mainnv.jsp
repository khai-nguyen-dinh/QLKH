<%-- 
    Document   : mainnv
    Created on : Nov 16, 2016, 6:12:39 AM
    Author     : tuann
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

        <!--           private int ma_sp;
            private String ten_sp;
            private float gia_sp;
            private String nha_sx;
            private int so_luong;
            private int ma_kh;
            private int ma_l;-->


        <h3>Danh sách sản phẩm</h3>

        <form action="Controller" method="GET">
            <input type="hidden" name="action" value="addProduct"/>
            <input type="submit" value="Add product">
        </form>

        <table >
            <tr>
                <td>Mã sản phẩm</td>
                <td>Tên sản phẩm</td>
                <td>Giá sản phẩm</td>
                <td>Nhà sản xuất</td>
                <td>Số lượng</td>
                <td>Mã khách hàng</td>
                <td>Mã loại</td>
                <td></td>
            </tr>
            <c:forEach items="${listProducts}" var="product">
                <tr>
                    <td>${product.ma_sp}</td>
                    <td>${product.ten_sp}</td>
                    <td>${product.gia_sp}</td>  
                    <td>${product.nha_sx}</td>  
                    <td>${product.so_luong}</td>
                    <td>${product.ma_kh}</td>
                    <td>${product.ma_l}</td>
                    <td><a href="<c:url value="Controller?action=deleteProduct&ma_sp=${product.ma_sp}"/>">Xóa</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
