/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author khai
 */
public class Connectdb {

    public static String urlMienBac = "192.168.43.9";
    public static String urlMienNam = "192.168.1.77";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLKH;user=sa;password=1234";
            con = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection(int ma_kh) {
        Connection con = null;
        try {
            String url = "";
            if(ma_kh == 0){
                url = "jdbc:sqlserver://"+urlMienBac + ":1433;databaseName=QLMIENBAC;user=sa;password=1234";
            } else{
                url = "jdbc:sqlserver://" + urlMienNam + ":1433;databaseName=QLMIENNAM;user=sa;password=1234";
            }
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
