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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sanpham;

/**
 *
 * @author tuann
 */
public class SanPhamDaoImpl implements SanPhamDao {

    @Override
    public void saveSanPham(Sanpham sp) {
        try {
            Connection con = Connectdb.getConnection();
            if (sp.getMa_kh() == 1) {
                con = Connectdb.getConnection(sp.getMa_kh());
            } else {
                con = Connectdb.getConnection(sp.getMa_kh());
            }
            PreparedStatement ps = con.prepareStatement("INSERT INTO SAN_PHAM(ma_sp, ten_sp, gia_sp, nha_sx, so_luong, ma_kh, ma_l) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, sp.getMa_sp());
            ps.setString(2, sp.getTen_sp());
            ps.setFloat(3, sp.getGia_sp());
            ps.setString(4, sp.getNha_sx());
            ps.setInt(5, sp.getSo_luong());
            ps.setInt(6, sp.getMa_kh());
            ps.setInt(7, sp.getMa_l());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteSanPham(int ma_sp, int ma_kh) {
        try {
            Connection con = Connectdb.getConnection(ma_kh);
            PreparedStatement ps = con.prepareStatement("DELETE FROM SAN_PHAM WHERE ma_sp = ?");
            ps.setInt(1, ma_sp);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Sanpham> getAllSanPham(int ma_kh) {
        List<Sanpham> list = new ArrayList<>();
        try {
            Connection con = Connectdb.getConnection();
            if (ma_kh == 0) {
                con = Connectdb.getConnection(ma_kh);
            } else {
                con = Connectdb.getConnection(ma_kh);
            }

            PreparedStatement ps = con.prepareStatement("SELECT * FROM SAN_PHAM");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
