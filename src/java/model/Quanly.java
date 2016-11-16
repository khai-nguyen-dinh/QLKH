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
public class Quanly {
    private int ma_ql;
    private String username;
    private String password;
    private String name;
    private String bo_phan_quan_ly;

    public Quanly(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Quanly(int ma_ql, String username, String password, String name, String bo_phan_quan_ly) {
        this.ma_ql = ma_ql;
        this.username = username;
        this.password = password;
        this.name = name;
        this.bo_phan_quan_ly = bo_phan_quan_ly;
    }

    
    public int getMa_ql() {
        return ma_ql;
    }

    public void setMa_ql(int ma_ql) {
        this.ma_ql = ma_ql;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBo_phan_quan_ly() {
        return bo_phan_quan_ly;
    }

    public void setBo_phan_quan_ly(String bo_phan_quan_ly) {
        this.bo_phan_quan_ly = bo_phan_quan_ly;
    }
    
}
