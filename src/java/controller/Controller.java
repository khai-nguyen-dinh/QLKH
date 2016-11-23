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
            ArrayList<Khohang> listkh = interactiveDB.allKhohang();
            request.setAttribute("khos", listkh);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dnnhanvien.jsp");
            rd.forward(request, response);
//            dnNhanvien(request, response);
        }
        if (action.equals("addnhanvien")) {
            addnhanvien(request, response);
        }
        if (action.equals("addlsanpham")) {
            addlsanpham(request, response);
        }
        if (action.equals("logout")) {
            logout(request, response);
        }
        if (action.equals("show")) {
            show(request, response);
        }
        if (action.equals("addProduct")) {
            ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
            request.setAttribute("loaisp", listl);
            addProduct(request, response);
        }
        if (action.equals("deleteProduct")) {
          
            HttpSession s = request.getSession();
            Nhanvien nhanvien = (Nhanvien)s.getAttribute("user");
            spd.deleteSanPham(Integer.parseInt(request.getParameter("ma_sp")), nhanvien.getMa_kh());
            request.setAttribute("listProducts", spd.getAllSanPham(nhanvien.getMa_kh()));
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainnv.jsp");
            rd.forward(request, response);
        }
        if (action.equals("showpro")) {
            showpro(request, response);
        }
        if (action.equals("updatenhanvien")) {
            updateNhanvien(request, response);
        }
        
        if (action.equals("deletenhanvien")) {
            deleteNhanvien(request, response);
        }
        
        if (action.equals("updatesanpham")) {
            updateSanpham(request, response);
        }

        if (action.equals("deletesanpham")) {
            deleteSanpham(request, response);
        }

        if (action.equals("updatelsp")) {
            updateLsp(request, response);
        }

        if (action.equals("deletelsp")) {
            deleteLsp(request, response);
        }
        if (action.equals("addsanpham")) {
            addSanpham(request, response);
        }
        if (action.equals("updatekh")) {
            updateKh(request, response);
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
        if (action.equals("addnhanvien")) {
            addnv(request, response);
        }
        if (action.equals("addloai")) {
            addloai(request, response);
        }
        if (action.equals("addProduct")) {
            saveProduct(request, response);
        }
        if (action.equals("updatenhanvien")) {
            updatedNhanvien(request, response);
        }
        if (action.equals("updatedSanpham")) {
            updatedSanpham(request, response);
        }
        if (action.equals("updatedlsp")) {
            updatedLsp(request, response);
        }
        if (action.equals("addedsanpham")) {
            addedSanpham(request, response);
        }
        if (action.equals("updatedkh")) {
            updatedKh(request, response);
        }
    }
    
    
    //dieu huong dang nhap
    protected void qlDangnhap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
        Quanly nv = (Quanly) session.getAttribute("user");
        if (nv != null) {
            show(request, response);
        }
        getServletContext().getRequestDispatcher("/dnquanly.jsp").forward(request, response);
    }
    
//    protected void nvDangnhap(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Nhanvien nv = (Nhanvien) session.getAttribute("user");
//        if (nv != null) {
//            request.setAttribute("listProducts", spd.getAllSanPham(1));
//            showpro(request, response);
//        }
//        getServletContext().getRequestDispatcher("/dnnhanvien.jsp").forward(request, response);
//    }
    

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
        session.setAttribute("user", interactiveDB.checkQuanly(ql));
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

    protected void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quanly nv = (Quanly) session.getAttribute("user");
        if (nv == null) {
            request.setAttribute("status", "ban chua dang nhap!");
            getServletContext().getRequestDispatcher("/dnquanly.jsp").forward(request, response);
        }

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
    protected void showpro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Nhanvien nv = (Nhanvien) session.getAttribute("user");
        if (nv == null) {
            request.setAttribute("status", "ban chua dang nhap!");
            getServletContext().getRequestDispatcher("/nvquanly.jsp").forward(request, response);
        }

          request.setAttribute("listProducts", spd.getAllSanPham(kho_id));
        getServletContext().getRequestDispatcher("/mainnv.jsp").forward(request, response);
    }
    
    int kho_id;
    
    protected void dnNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        kho_id = Integer.parseInt(request.getParameterValues("kho_id")[0]);
        ArrayList<Khohang> listkh = interactiveDB.allKhohang();
        request.setAttribute("khos", listkh);
        Nhanvien n = new Nhanvien(username, password);
        Nhanvien checkUser = interactiveDB.checkNhanvien(n, kho_id) ;
        if (checkUser == null) {
            request.setAttribute("status", "sai tai khoan hoac mat khau!");
            getServletContext().getRequestDispatcher("/dnnhanvien.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", checkUser);
        request.setAttribute("listProducts", spd.getAllSanPham(kho_id));
        getServletContext().getRequestDispatcher("/mainnv.jsp").forward(request, response);
    }
    
    protected void addnhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addnhanvien.jsp").forward(request, response);
    }
    protected void addlsanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addlsanpham.jsp").forward(request, response);
    }
    protected void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addProduct.jsp").forward(request, response);
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    protected void addnv(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ma_nv"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ten = request.getParameter("ten");
        int ma_kh = Integer.parseInt(request.getParameter("ma_kh"));
        HttpSession session = request.getSession();
        Quanly nv =  (Quanly)session.getAttribute("user");
        int ma_ql = nv.getMa_ql();
        Nhanvien n = new Nhanvien(id, ten, username, password, ma_kh, ma_ql);
        interactiveDB.insertNhanvien(n);
        request.setAttribute("status", "them thanh cong");
        getServletContext().getRequestDispatcher("/addnhanvien.jsp").forward(request, response);
    }
    
    
    protected void addloai(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_l = Integer.parseInt(request.getParameter("ma_l"));
        String ten_l = request.getParameter("ten_l");
        String mota = request.getParameter("mota");
        String ten = request.getParameter("ten");
        loai_sp l = new loai_sp(ma_l, ten_l, mota);
        interactiveDB.insertLoai(l);
        request.setAttribute("status", "them thanh cong");
        getServletContext().getRequestDispatcher("/addlsanpham.jsp").forward(request, response);
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

        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
        request.setAttribute("loaisp", listl);

        boolean ok = true;
        if (ten_sp.trim().length() == 0 || ma_sp.trim().length() == 0 || gia_sp.trim().length() == 0 || nha_sx.trim().length() == 0 || so_luong.trim().length() == 0 || loai_id.trim().length() == 0) {
            request.setAttribute("error", "Hãy điền đầy đủ form");
            url = "/addProduct.jsp";
            ok = false;
        }
        int maSP = 0, soLuong = 0,  loaiId = 0;
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
            HttpSession sesstion = request.getSession();
            Nhanvien nv = (Nhanvien)sesstion.getAttribute("user");
            spd.saveSanPham(new Sanpham(maSP, ten_sp, giaSP, nha_sx, soLuong, nv.getMa_kh(), loaiId));
            request.setAttribute("listProducts", spd.getAllSanPham(nv.getMa_kh()));
            url = "/mainnv.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    
    
    
    
    
    protected void updateNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Nhanvien temp = interactiveDB.getNhanvien(id);
        request.setAttribute("nv", temp);
        getServletContext().getRequestDispatcher("/updatenv.jsp").forward(request, response);
    }
    
    protected void updatedNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ma_nv"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ten = request.getParameter("ten");
        int ma_kh = Integer.parseInt(request.getParameter("ma_kh"));
        HttpSession session = request.getSession();
        Quanly nv = (Quanly) session.getAttribute("user");
        int ma_ql = nv.getMa_ql();
        Nhanvien n = new Nhanvien(id, ten, username, password, ma_kh, ma_ql);
        interactiveDB.updateNhanvien(n);
        show(request, response);
    }
    
    
    protected void deleteNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        interactiveDB.deleteNhanvien(id);
        show(request, response);
    }
    
    
    
    protected void updateSanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Sanpham s = interactiveDB.getSanpham(id);
        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
        request.setAttribute("loaisp", listl);
        request.setAttribute("sp", s);
        
        getServletContext().getRequestDispatcher("/updatesp.jsp").forward(request, response);
    }
    protected void deleteSanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        interactiveDB.deleteSanpham(id);
        show(request, response);
    }
    
    
    protected void updatedSanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_sp = Integer.parseInt(request.getParameter("ma_sp"));
        String ten_sp = request.getParameter("ten_sp");
        float gia_sp = Float.parseFloat(request.getParameter("gia_sp"));
        String nha_sx = request.getParameter("nha_sx");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));
        int ma_kh = Integer.parseInt(request.getParameter("ma_kh"));
        int ma_l = Integer.parseInt(request.getParameter("ma_l"));
       Sanpham s = new Sanpham(ma_sp, ten_sp, gia_sp, nha_sx, so_luong, ma_kh, ma_l);
       interactiveDB.updateSanpham(s);
        show(request, response);
    }
    
    
    protected void updateLsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        loai_sp l = interactiveDB.getLsp(id);
        request.setAttribute("lsp", l);

        getServletContext().getRequestDispatcher("/updatelsp.jsp").forward(request, response);
    }

    protected void deleteLsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        interactiveDB.deleteSanpham(id);
        show(request, response);
    }
    protected void updatedLsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_l = Integer.parseInt(request.getParameter("ma_l"));
        String ten_l = request.getParameter("ten_l");
        String mota = request.getParameter("mota");
        loai_sp l = new loai_sp(ma_l, ten_l, mota);
        interactiveDB.updateLsp(l);
        show(request, response);
    }
    
    protected void addSanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<loai_sp> listl = interactiveDB.allLoai_sp();
        request.setAttribute("loaisp", listl);
        getServletContext().getRequestDispatcher("/addsanpham.jsp").forward(request, response);
    }
    
    
    
    
    protected void addedSanpham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_sp = Integer.parseInt(request.getParameter("ma_sp"));
        String ten_sp = request.getParameter("ten_sp");
        float gia_sp = Float.parseFloat(request.getParameter("gia_sp"));
        String nha_sx = request.getParameter("nha_sx");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));
        int ma_kh = Integer.parseInt(request.getParameter("ma_kh"));
        int ma_l = Integer.parseInt(request.getParameter("ma_l"));
        Sanpham s = new Sanpham(ma_sp, ten_sp, gia_sp, nha_sx, so_luong, ma_kh, ma_l);
        interactiveDB.addSanpham(s);
        show(request, response);
    }
    
    
    protected void updateKh(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Khohang k = interactiveDB.getKh(id);
        request.setAttribute("kh", k);

        getServletContext().getRequestDispatcher("/updatekh.jsp").forward(request, response);
    }
    protected void updatedKh(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma_kh = Integer.parseInt(request.getParameter("ma_kh"));
        String ten_kh = request.getParameter("ten_kh");
        String chi_nhanh = request.getParameter("chi_nhanh");
        Khohang k = new Khohang(ma_kh, ten_kh, chi_nhanh);
        interactiveDB.updateKh(k);
        show(request, response);
    }
}
