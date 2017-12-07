package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * 
 */
public class ConnectionData {

    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ConnectionData() {
    }

    public ConnectionData(Connection con) {
        this.con = con;
    }

    public Connection connectData(String dataname) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName= INF205Final" + dataname
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq";

        } catch (Exception e) {

        }
        return con;
    }

    public boolean insert(String TenSP, String imagesSP, String GiaSP, String MoTaSP) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName=INF205Final"
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq");
            String sql = "Insert into [SanPham] (TenSP,imagesSP,GiaSP,MoTaSP)" + "Values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, TenSP);
            stm.setString(2, imagesSP);
            stm.setString(3, GiaSP);
            stm.setString(4, MoTaSP);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if (result > 0) {
                return true;
            }

        } catch (Exception e) {

        }
        return false;
    }

    public boolean delete(String TenSP) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName=INF205Final"
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq");
            String sql = " Delete from [SanPham] where TenSP=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, TenSP);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if(result>0){
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

}
