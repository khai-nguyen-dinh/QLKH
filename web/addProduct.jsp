<%-- 
    Document   : addProduct
    Created on : Nov 16, 2016, 9:11:30 PM
    Author     : tuann
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
        <div class="centerText">
            <h2>Thêm sản phẩm</h2>
        </div>
        <form action="Controller?action=addProduct" method="POST">
            <td><span style="color:red">${error}</span></td>
            <table align="center">
                <tr>
                    <td>Mã sản phẩm</td>
                    <td>  <input type="text" name="ma_sp" value="${ma_sp}"/></td>
                </tr>
                <!--                  private int ma_sp;
                    private String ten_sp;
                    private float gia_sp;
                    private String nha_sx;
                    private int so_luong;
                    private int ma_kh;
                    private int ma_l;-->

                <tr>
                    <td>Tên sản phẩm</td>
                    <td>  <input type="text" name="ten_sp" value="${ten_sp}"/></td>
                </tr>
                <tr>
                    <td>Giá sản phẩm</td>
                    <td><input type="text" name="gia_sp" value="${gia_sp}"/></td>
                </tr>
                <tr>
                    <td>Nhà sản xuất</td>
                    <td><input type="text" name="nha_sx" value="${nha_sx}"/></td>
                </tr>

                <tr>
                    <td>Số lượng</td>
                    <td><input type="text" name="so_luong" value="${so_luong}"/></td>
                </tr>
                <tr>
                    <td>Chọn kho hàng</td>
                    <td>
                        <select name="kho_id" id="kho_id">
                            <c:forEach items="${khohang}" var="kho">
                                <option  value="${kho.ma_kh}">${kho.ten_kh}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Chọn loại sản phẩm</td>
                    <td>  
                        <select name="loai_id" id="loai_id">
                            <c:forEach items="${loaisp}" var="loai">
                                <option value="${loai.ma_l}">${loai.ten_l}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

              
                <tr>
                    <td></td>
                    <td><input type="submit" value="Thêm sản phẩm"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
