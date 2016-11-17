/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Connectdb;
import dao.SanPhamDao;
import dao.SanPhamDaoImpl;
import dao.interactiveDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Khohang;
import model.Nhanvien;
import model.Quanly;
import model.Sanpham;
import model.loai_sp;
import model.ls_xuat;

/**
 *
 * @author khai
 */
public class Controller extends HttpServlet {

    SanPhamDao spd = new SanPhamDaoImpl();

    //bat su kien
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("quanly")) {
            qlDangnhap(request, response);
        }
        if (action.equals("nhanvien")) {
            ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
            request.setAttribute("loaisp", listl);
            nvDangnhap(request, response);
        }
        if (action.equals("addnhanvien")) {
            addnhanvien(request, response);
        }
        if (action.equals("logout")) {
            logout(request, response);
        }
        if (action.equals("addProduct")) {
            ArrayList<Khohang> listkh = interactiveDB.allKhohang();
            ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
            request.setAttribute("khohang", listkh);
            request.setAttribute("loaisp", listl);
            addProduct(request, response);
        }
        if (action.equals("deleteProduct")) {
            spd.deleteSanPham(Integer.parseInt(request.getParameter("ma_sp")));
            request.setAttribute("listProducts", spd.getAllSanPham(kho_id));

            ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();

            request.setAttribute("loaisp", listl);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainnv.jsp");
            rd.forward(request, response);
        }
//        if (action.equals("mainnv")) {
//            
//            request.setAttribute("listProducts", spd.getAllSanPham(Integer.parseInt(request.getParameterValues("loai_id")[0])));
//            getServletContext().getRequestDispatcher("/mainnv.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("dnquanly")) {
            dnQuanly(request, response);
        }
        if (action.equals("dnnhanvien")) {
            ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
            request.setAttribute("loaisp", listl);
            dnNhanvien(request, response);
        }
        if (action.equals("addProduct")) {
            saveProduct(request, response);
        }
    }

    //dieu huong dang nhap
    protected void qlDangnhap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/dnquanly.jsp").forward(request, response);
    }

    protected void nvDangnhap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/dnnhanvien.jsp").forward(request, response);
    }

    //kiem tra dang nhap
    protected void dnQuanly(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Quanly ql = new Quanly(username, password);
        if (interactiveDB.checkQuanly(ql) == null) {
            request.setAttribute("status", "sai tai khoan hoac mat khau!");
            getServletContext().getRequestDispatcher("/dnquanly.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", ql);
        ArrayList<Nhanvien> listnv = interactiveDB.allNhanvien();
        ArrayList<Khohang> listkh = interactiveDB.allKhohang();
        ArrayList<Sanpham> listsp = interactiveDB.allSanpham();
        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
        ArrayList<ls_xuat> listlx = interactiveDB.allLs_xuat();

        request.setAttribute("nhanviens", listnv);
        request.setAttribute("khohangs", listkh);
        request.setAttribute("sanphams", listsp);
        request.setAttribute("loais", listl);
        request.setAttribute("ls", listlx);
        getServletContext().getRequestDispatcher("/mainql.jsp").forward(request, response);
    }

    int kho_id;

    protected void dnNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        kho_id = Integer.parseInt(request.getParameterValues("loai_id")[0]);

        Nhanvien n = new Nhanvien(username, password);
        if (interactiveDB.checkNhanvien(n) == null) {
            request.setAttribute("status", "sai tai khoan hoac mat khau!");
            getServletContext().getRequestDispatcher("/dnnhanvien.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", n);
        request.setAttribute("listProducts", spd.getAllSanPham(kho_id));
        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();

        request.setAttribute("loaisp", listl);

        getServletContext().getRequestDispatcher("/mainnv.jsp").forward(request, response);
    }

    protected void addnhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addnhanvien.jsp").forward(request, response);
    }

    protected void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addProduct.jsp").forward(request, response);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/logout.jsp").forward(request, response);
    }

    protected void saveProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String ten_sp = request.getParameter("ten_sp");
        String ma_sp = request.getParameter("ma_sp");//i
        String gia_sp = request.getParameter("gia_sp");//f
        String nha_sx = request.getParameter("nha_sx");
        String so_luong = request.getParameter("so_luong");//i
        String loai_id = request.getParameterValues("loai_id")[0];//i

        request.setAttribute("ten_sp", ten_sp);
        request.setAttribute("ma_sp", ma_sp);
        request.setAttribute("ma_sp", ma_sp);
        request.setAttribute("gia_sp", gia_sp);
        request.setAttribute("nha_sx", nha_sx);
        request.setAttribute("so_luong", so_luong);

        ArrayList<Khohang> listkh = interactiveDB.allKhohang();
        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
        request.setAttribute("khohang", listkh);
        request.setAttribute("loaisp", listl);

        boolean ok = true;
        if (ten_sp.trim().length() == 0 || ma_sp.trim().length() == 0 || gia_sp.trim().length() == 0 || nha_sx.trim().length() == 0 || so_luong.trim().length() == 0 || loai_id.trim().length() == 0) {
            request.setAttribute("error", "Hãy điền đầy đủ form");
            url = "/addProduct.jsp";
            ok = false;
        }
        int maSP = 0, soLuong = 0, loaiId = 0;
        float giaSP = 0;
        try {
            maSP = Integer.parseInt(ma_sp);
            giaSP = Float.parseFloat(gia_sp);
            soLuong = Integer.parseInt(so_luong);
            loaiId = Integer.parseInt(loai_id);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Bạn nhập sai định dạng ít nhất một trường");
            url = "/addProduct.jsp";
            ok = false;
        }

        if (ok == true) {
            spd.saveSanPham(new Sanpham(maSP, ten_sp, giaSP, nha_sx, soLuong, this.kho_id, loaiId));
            request.setAttribute("listProducts", spd.getAllSanPham(this.kho_id));

            request.setAttribute("loaisp", interactiveDB.allLoai_sp());
            url = "/mainnv.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
