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
        <style>
            .fixed_headers {
                width: 950px;
                table-layout: fixed;
                border-collapse: collapse;
            }
            .fixed_headers th {
                text-decoration: underline;
            }
            .fixed_headers th,
            .fixed_headers td {
                padding: 5px;
                text-align: left;
            }
            .fixed_headers td:nth-child(1),
            .fixed_headers th:nth-child(1) {
                min-width: 200px;
            }
            .fixed_headers td:nth-child(2),
            .fixed_headers th:nth-child(2) {
                min-width: 200px;
            }
            .fixed_headers td:nth-child(3),
            .fixed_headers th:nth-child(3) {
                width: 350px;
            }
            .fixed_headers thead {
                background-color: highlight;
                color: #fdfdfd;
            }
            .fixed_headers thead tr {
                display: block;
                position: relative;
            }
            .fixed_headers tbody {
                display: block;
                overflow: auto;
                width: 100%;
                height: 100px;
            }
            .fixed_headers tbody tr:nth-child(even) {
                background-color: #dddddd;
            }
            .old_ie_wrapper {
                height: 300px;
                width: 350px;
                overflow-x: hidden;
                overflow-y: auto;
            }
            .old_ie_wrapper tbody {
                height: auto;
            }
        </style>
    </head>
    <body>

        <!--           private int ma_sp;
            private String ten_sp;
            private float gia_sp;
            private String nha_sx;
            private int so_luong;
            private int ma_kh;
            private int ma_l;-->

        <h3>xin chao <span style="color: springgreen">${user.username} </span></h3>
        <a href="<c:url value="Controller?action=logout"/>">Logout</a>
    <center>
        <h3>Danh sách sản phẩm</h3>

        <form action="Controller" method="GET">
            <input type="hidden" name="action" value="addProduct"/>
            <input type="submit" value="Add product">
        </form>

        <table class="fixed_headers">
            <thead>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá sản phẩm</th>
                    <th>Nhà sản xuất</th>
                    <th>Số lượng</th>
                    <th>Mã khách hàng</th>
                    <th>Mã loại</th>
                </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>
    </center>
</body>
</html>
