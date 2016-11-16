/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Connectdb;
import dao.interactiveDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    
    //bat su kien
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("quanly")) {
            qlDangnhap(request, response);
        }
        if (action.equals("nhanvien")) {
            nvDangnhap(request, response);
        }
        if (action.equals("addnhanvien")) {
            addnhanvien(request, response);
        }
        if (action.equals("addsanpham")) {
            addsanpham(request, response);
        }
        if (action.equals("logout")) {
            logout(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("dnquanly")) {
            dnQuanly(request, response);
        }
        if (action.equals("dnnhanvien")) {
            dnNhanvien(request, response);
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
        if(interactiveDB.checkQuanly(ql) ==null){
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

    protected void dnNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Nhanvien n = new Nhanvien(username, password);
        if (interactiveDB.checkNhanvien(n) == null) {
            request.setAttribute("status", "sai tai khoan hoac mat khau!");
            getServletContext().getRequestDispatcher("/dnnhanvien.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", n);
        getServletContext().getRequestDispatcher("/mainnv.jsp").forward(request, response);
    }
    
    protected void addnhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addnhanvien.jsp").forward(request, response);
    }
    protected void addsanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addsanpham.jsp").forward(request, response);
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/logout.jsp").forward(request, response);
    }
}
