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

    public static Nhanvien getNhanvien(int id) {
        Connection c = Connectdb.getConnection();
        String sql = "select * from NHAN_VIEN where ma_nv = ?";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("ma_nv");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                int ma_kh = rs.getInt("ma_kh");
                int ma_ql = rs.getInt("ma_ql");
                Nhanvien n = new Nhanvien(ma, ten, username, password, ma_kh, ma_ql);
                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(interactiveDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void updateNhanvien(Nhanvien user) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "UPDATE  NHAN_VIEN SET ten=?, username=?, password=?,ma_ql=?, ma_kh=? where ma_nv=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(6, user.getMa_nv());
            preparedStatement.setString(1, user.getTen());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getMa_ql());
            preparedStatement.setInt(5, user.getMa_kh());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNhanvien(int id) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "DELETE FROM  NHAN_VIEN where ma_nv=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Nhanvien checkNhanvien(Nhanvien user, int id_kh) {
        Connection c = Connectdb.getConnection();
        String sql = "select * from NHAN_VIEN where username = ? and password = ? and ma_kh = ?";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, id_kh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_nv");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                int ma_kh = rs.getInt("ma_kh");
                int ma_ql = rs.getInt("ma_ql");
                Nhanvien n = new Nhanvien(id, ten, username, password, ma_kh, ma_ql);
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
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_nv");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String ten = rs.getString("ten");
                int ma_kh = rs.getInt("ma_kh");
                int ma_ql = rs.getInt("ma_ql");
                Nhanvien n = new Nhanvien(id, ten, username, password, ma_kh, ma_ql);
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

    public static void updateSanpham(Sanpham sp) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "UPDATE  SAN_PHAM SET ten_sp=?, gia_sp=?, nha_sx=?,so_luong=?, ma_kh=?, ma_l=? where ma_sp=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(7, sp.getMa_sp());
            preparedStatement.setString(1, sp.getTen_sp());
            preparedStatement.setFloat(2, sp.getGia_sp());
            preparedStatement.setString(3, sp.getNha_sx());
            preparedStatement.setInt(4, sp.getSo_luong());
            preparedStatement.setInt(5, sp.getMa_kh());
            preparedStatement.setInt(6, sp.getMa_l());

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void addSanpham(Sanpham sp) {
        try {
            Connection c = Connectdb.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO SAN_PHAM(ma_sp, ten_sp, gia_sp, nha_sx, so_luong, ma_kh, ma_l) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, sp.getMa_sp());
            ps.setString(2, sp.getTen_sp());
            ps.setFloat(3, sp.getGia_sp());
            ps.setString(4, sp.getNha_sx());
            ps.setInt(5, sp.getSo_luong());
            ps.setInt(6, sp.getMa_kh());
            ps.setInt(7, sp.getMa_l());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void deleteSanpham(int id) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "DELETE FROM  SAN_PHAM where ma_sp=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Sanpham getSanpham(int id) {

        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from SAN_PHAM where ma_sp=?";
            PreparedStatement ps;
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
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
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public static void insertNhanvien(Nhanvien user) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "insert into NHAN_VIEN values(?, ?, ?, ?, ? ,?)";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, user.getMa_nv());
            preparedStatement.setString(2, user.getTen());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getMa_ql());
            preparedStatement.setInt(6, user.getMa_kh());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertLoai(loai_sp l) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "insert into LOAI_SP values(?, ?, ?)";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, l.getMa_l());
            preparedStatement.setString(2, l.getTen_l());
            preparedStatement.setString(3, l.getMota());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateLsp(loai_sp sp) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "UPDATE  LOAI_SP SET ten_l=?, mota=? where ma_l=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTen_l());
            preparedStatement.setString(2, sp.getMota());
            preparedStatement.setInt(3, sp.getMa_l());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteLsp(int id) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "DELETE FROM  LOAI_SP where ma_l=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static loai_sp getLsp(int id) {

        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from LOAI_SP where ma_l=?";
            PreparedStatement ps;
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_l = rs.getInt("ma_l");
                String ten_sp = rs.getString("ten_l");
                String mota = rs.getString("mota");
                loai_sp l = new loai_sp(ma_l, ten_sp, mota);
                return l;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public static Khohang getKh(int id) {

        try {
            Connection c = Connectdb.getConnection();
            String sql = "select * from KHO_HANG where ma_kh=?";
            PreparedStatement ps;
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_l = rs.getInt("ma_kh");
                String ten_kh = rs.getString("ten_kh");
                String chi_nhanh = rs.getString("chi_nhanh");
                Khohang k = new Khohang(ma_l, ten_kh, chi_nhanh);
                return k;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void updateKh(Khohang sp) {
        try {
            Connection c = Connectdb.getConnection();
            String sql = "UPDATE  KHO_HANG SET ten_kh=?, chi_nhanh=? where ma_kh=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTen_kh());
            preparedStatement.setString(2, sp.getChi_nhanh());
            preparedStatement.setInt(3, sp.getMa_kh());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
