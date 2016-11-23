/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Sanpham;

/**
 *
 * @author tuann
 */
public interface SanPhamDao {
    
    void saveSanPham(Sanpham sp);
    
    void deleteSanPham(int ma_sp, int ma_kh);
    
    List<Sanpham> getAllSanPham(int ma_kh);
}
