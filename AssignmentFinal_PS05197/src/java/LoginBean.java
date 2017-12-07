/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.ejb.PrePassivate;

/**
 *
 * 
 */
public class LoginBean implements Serializable{
    private String email;
    private String password;

    public LoginBean() {
    }

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public boolean checkLogin (String email, String password){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName=INF205Final"
                    + "HaQuyetChien_SQLLogin_1"
                    + "ramh7tocvq");
            String sql = "Select * from Login where email= ? and password= ?";          
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            boolean result = rs.next();
            rs.close();
            stm.close();
            con.close();
            if(result){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insert(String email, String password){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://INF205Final.mssql.somee.com"
                    + "databaseName=INF205Final" 
                    + "HaQuyetChien_SQLLogin_1;"
                    + "ramh7tocvq");
            String sql = "Insert Into Login(email, password) " + "Values(?, ?)";         
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            int result = stm.executeUpdate();
            rs.close();
            stm.close();
            con.close();
            if(result>=0){
            } else {
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
