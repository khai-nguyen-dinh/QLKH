<%-- 
    Document   : mainql
    Created on : Nov 16, 2016, 6:06:43 AM
    Author     : khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .fixed_headers {
                width: 750px;
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
                height: 200px;
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
        <h3>xin chao <span style="color: gold">${user.username}</span></h3>
        <table border="1">
            <tr>
                <td><a href="<c:url value="Controller?action=addnhanvien"/>">Them nhan vien</a></td>
                <td><a href="<c:url value="Controller?action=addlsanpham"/>">Them loai san pham</a></td>
                <td><a href="<c:url value="Controller?action=addsanpham"/>">Them san pham</a></td>
                <td><a href="<c:url value="Controller?action=logout"/>">Logout</a></td>
                
                
            </tr>
        </table>
    <center>
        <h2>Nhan vien</h2>
        <table class="fixed_headers">
            <thead>
                <tr>
                    <th>ma_nv</th>
                    <th>ten</th>
                    <th>username</th>
                    <th>password</th>
                    <th>chi_nhanh</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${nhanviens}">
                    <tr> 
                        <td>${p.ma_nv}</td>
                        <td>${p.ten}</td>
                        <td>${p.username}</td>
                        <td>${p.password}</td>
                        <td>${p.ma_kh}</td>
                        <td><a href="<c:url value="Controller?action=updatenhanvien&id=${p.ma_nv}"/>">update</a></td>
                        <td><a href="<c:url value="Controller?action=deletenhanvien&id=${p.ma_nv}"/>">delete</a></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- kho hang -->
        <h2>Kho hang</h2>
        <table class="fixed_headers">

            <thead>
                <tr>
                    <th>ma_kh</th>
                    <th>ten_kh</th>
                    <th>chi_nhanh</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${khohangs}">
                    <tr> 
                        <td>${p.ma_kh}</td>
                        <td>${p.ten_kh}</td>
                        <td>${p.chi_nhanh}</td>
                        <td><a href="<c:url value="Controller?action=updatekh&id=${p.ma_kh}"/>">update</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- san pham -->
        <h2>SAN PHAM</h2>
        <table class="fixed_headers">

            <thead>
                <tr>
                    <th>ma_sp</th>
                    <th>ten_sp</th>
                    <th>gia_sp</th>
                    <th>nha_sx</th>
                    <th>so_luong</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${sanphams}">
                    <tr> 
                        <td>${p.ma_sp}</td>
                        <td>${p.ten_sp}</td>
                        <td>${p.gia_sp}</td>
                        <td>${p.nha_sx}</td>
                        <td>${p.so_luong}</td>
                        <td><a href="<c:url value="Controller?action=updatesanpham&id=${p.ma_sp}"/>">update</a></td>
                        <td><a href="<c:url value="Controller?action=deletesanpham&id=${p.ma_sp}"/>">delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- loai -->
        <h2>LOAI SAN PHAM</h2>
        <table class="fixed_headers">
            <thead>
                <tr>
                    <th>ma_l</th>
                    <th>ten_l</th>
                    <th>mota</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${loais}">
                    <tr> 
                        <td>${p.ma_l}</td>
                        <td>${p.ten_l}</td>
                        <td>${p.mota}</td>
                        <td><a href="<c:url value="Controller?action=updatelsp&id=${p.ma_l}"/>">update</a></td>
                        <td><a href="<c:url value="Controller?action=deletelsp&id=${p.ma_l}"/>">delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- ls_xuat -->
        <h2>LICH SU XUAT</h2>
        <table class="fixed_headers">
            <thead>
                <tr>
                    <th>ma_ls</th>
                    <th>so_luong</th>
                    <th>ngay_xuat</th>
                    <th>ma_sp</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${ls}">
                    <tr> 
                        <td>${p.ma_ls}</td>
                        <td>${p.so_luong}</td>
                        <td>${p.ngay_xuat}</td>
                        <td>${p.ma_sp}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>
</body>
</html>
