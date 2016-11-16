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
public class Sanpham {
    private int ma_sp;
    private String ten_sp;
    private float gia_sp;
    private String nha_sx;
    private int so_luong;
    private int ma_kh;
    private int ma_l;

    public Sanpham(int ma_sp, String ten_sp, float gia_sp, String nha_sx,  int so_luong, int ma_kh, int ma_l) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.nha_sx = nha_sx;
        this.so_luong = so_luong;
        this.ma_kh = ma_kh;
        this.ma_l = ma_l;
    }

    public int getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(int ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public float getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(float gia_sp) {
        this.gia_sp = gia_sp;
    }

    public String getNha_sx() {
        return nha_sx;
    }

    public void setNha_sx(String nha_sx) {
        this.nha_sx = nha_sx;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(int ma_kh) {
        this.ma_kh = ma_kh;
    }

    public int getMa_l() {
        return ma_l;
    }

    public void setMa_l(int ma_l) {
        this.ma_l = ma_l;
    }
    
}
