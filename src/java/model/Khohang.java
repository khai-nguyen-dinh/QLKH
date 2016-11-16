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
public class Khohang {
    private int ma_kh;
    private String ten_kh;
    private String chi_nhanh;

    public Khohang(int ma_kh, String ten_kh, String chi_nhanh) {
        this.ma_kh = ma_kh;
        this.ten_kh = ten_kh;
        this.chi_nhanh = chi_nhanh;
    }

    public int getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(int ma_kh) {
        this.ma_kh = ma_kh;
    }

    public String getTen_kh() {
        return ten_kh;
    }

    public void setTen_kh(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    public String getChi_nhanh() {
        return chi_nhanh;
    }

    public void setChi_nhanh(String chi_nhanh) {
        this.chi_nhanh = chi_nhanh;
    }


}
