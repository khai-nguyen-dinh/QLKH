/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author khai
 */
public class Nhanvien {
    private int ma_nv;
    private String ten;
    private String username;
    private String password;
    private int ma_kh;
    private int ma_ql;

    public Nhanvien(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Nhanvien(int ma_nv, String ten, String username, String password, int ma_kh, int ma_ql) {
        this.ma_nv = ma_nv;
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.ma_kh = ma_kh;
        this.ma_ql = ma_ql;
    }

    
    
    
    public int getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(int ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(int chi_nhanh) {
        this.ma_kh = chi_nhanh;
    }

    public int getMa_ql() {
        return ma_ql;
    }

    public void setMa_ql(int ma_ql) {
        this.ma_ql = ma_ql;
    }
    
    
    
    
}
