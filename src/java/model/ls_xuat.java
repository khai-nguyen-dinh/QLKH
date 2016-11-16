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
public class ls_xuat {
    private int ma_ls;
    private int so_luong;
    private String ngay_xuat;
    private int ma_sp;

    public ls_xuat(int ma_ls, int so_luong, String ngay_xuat, int ma_sp) {
        this.ma_ls = ma_ls;
        this.so_luong = so_luong;
        this.ngay_xuat = ngay_xuat;
        this.ma_sp = ma_sp;
    }

    public int getMa_ls() {
        return ma_ls;
    }

    public void setMa_ls(int ma_ls) {
        this.ma_ls = ma_ls;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(String ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public int getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(int ma_sp) {
        this.ma_sp = ma_sp;
    }
    
}
