package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.ejb.PrePassivate;

/**
 *
 * 
 */
public class LoginBean3 implements Serializable{
    public LoginBean3(){
        
    }
    private String username;
    private String password;

    public LoginBean3(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    
    
    public boolean insert(String lastname, String firstname,String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName= INF205Final"
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq");
            String sql = "Insert Into Login(lastname,firstname,username, password) "
                    + "Values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, lastname);
            stm.setString(2, firstname);
            stm.setString(3, username);
            stm.setString(4, password);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteRecord() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName= INF205Final"
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq");
            String sql = "Delete from Login Where username =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


