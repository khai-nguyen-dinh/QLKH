/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author khai
 */
public class interactiveDB {

    public static Quanly checkQuanly(Quanly user) {
        Connection c = Connectdb.getConnection();
        String sql = "select * from QUAN_LY where username = ? and password = ?";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_ql");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                String bo_phan_quan_ly = rs.getString("bo_phan_quan_ly");
                Quanly q = new Quanly(id, username, password, ten, bo_phan_quan_ly);
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(interactiveDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static Nhanvien checkNhanvien(Nhanvien user) {
        Connection c = Connectdb.getConnection();
        String sql = "select * from NHAN_VIEN where username = ? and password = ?";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_nv");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                int ma_kh = rs.getInt("ma_kh");
                int ma_ql = rs.getInt("ma_ql");
                Nhanvien n = new Nhanvien(ma_ql, ten, username, password, ma_kh, ma_ql);
                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(interactiveDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<Nhanvien> allNhanvien() {
        ArrayList<Nhanvien> user = new ArrayList<>();
        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from NHAN_VIEN";
            PreparedStatement ps =  c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_nv");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                int ma_kh = rs.getInt("ma_kh");
                int ma_ql = rs.getInt("ma_ql");
                Nhanvien n = new Nhanvien(ma_ql, ten, username, password, ma_kh, ma_ql);
                user.add(n);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static ArrayList<Khohang> allKhohang() {
        ArrayList<Khohang> listkh = new ArrayList<>();
        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from KHO_HANG";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_kh");
                String ten_kh = rs.getString("ten_kh");
                String chi_nhanh = rs.getString("chi_nhanh");
                Khohang k = new Khohang(id, ten_kh, chi_nhanh);
                listkh.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }
    
    public static ArrayList<Sanpham> allSanpham() {
        ArrayList<Sanpham> listsp = new ArrayList<>();
        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from SAN_PHAM";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_sp = rs.getInt("ma_sp");
                String ten_sp = rs.getString("ten_sp");
                float gia_sp = rs.getFloat("gia_sp");
                String nha_sx = rs.getString("nha_sx");
                int so_luong = rs.getInt("so_luong");
                int ma_kh = rs.getInt("ma_kh");
                int ma_l = rs.getInt("ma_l");
                Sanpham s = new Sanpham(ma_sp, ten_sp, gia_sp, nha_sx, so_luong, ma_kh, ma_l);
                listsp.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsp;
    }
    
    
    public static ArrayList<loai_sp> allLoai_sp() {
        ArrayList<loai_sp> listlsp = new ArrayList<>();
        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from LOAI_SP";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_l = rs.getInt("ma_l");
                String ten_l = rs.getString("ten_l");
                String mota = rs.getString("mota");
                
                loai_sp l = new loai_sp(ma_l, ten_l, mota);
                listlsp.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listlsp;
    }
    
    public static ArrayList<ls_xuat> allLs_xuat() {
        ArrayList<ls_xuat> listlx = new ArrayList<>();
        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from LS_XUAT";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_ls = rs.getInt("ma_ls");
                int so_luong = rs.getInt("so_luong");
                String ngay_xuat = rs.getString("ngay_xuat");
                int ma_sp = rs.getInt("ma_sp");
                ls_xuat ls = new ls_xuat(ma_ls, so_luong, ngay_xuat, ma_sp);
                listlx.add(ls);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listlx;
    }
    
}
