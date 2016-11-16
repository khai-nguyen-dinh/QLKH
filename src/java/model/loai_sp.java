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
public class loai_sp {
    private int ma_l;
    private String ten_l;
    private String mota;

    public loai_sp(int ma_l, String ten_l, String mota) {
        this.ma_l = ma_l;
        this.ten_l = ten_l;
        this.mota = mota;
    }

    public int getMa_l() {
        return ma_l;
    }

    public void setMa_l(int ma_l) {
        this.ma_l = ma_l;
    }

    public String getTen_l() {
        return ten_l;
    }

    public void setTen_l(String ten_l) {
        this.ten_l = ten_l;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
