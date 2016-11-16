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
}
