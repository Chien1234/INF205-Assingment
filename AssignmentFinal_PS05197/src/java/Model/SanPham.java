package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * 
 */
public class SanPham {
    private int ID;
    private String TenSP;
    private String imagesSP;
    private String GiaSP;
    private String MoTaSP;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getImagesSP() {
        return imagesSP;
    }

    public void setImagesSP(String imagesSP) {
        this.imagesSP = imagesSP;
    }

    public String getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(String GiaSP) {
        this.GiaSP = GiaSP;
    }

    public String getMoTaSP() {
        return MoTaSP;
    }

    public void setMoTaSP(String MoTaSP) {
        this.MoTaSP = MoTaSP;
    }

    public SanPham() {
    }

    public SanPham(int ID, String TenSP, String imagesSP, String GiaSP, String MoTaSP) {
        this.ID = ID;
        this.TenSP = TenSP;
        this.imagesSP = imagesSP;
        this.GiaSP = GiaSP;
        this.MoTaSP = MoTaSP; 
    }
    public ArrayList<SanPham> getConnectSanPham(){
        ConnectionData c = new ConnectionData();
        Connection conn = c.connectData("INF205FINAL");
        String sql = "Select * from SanPham";
        ArrayList<SanPham> arr = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                SanPham sp = new SanPham();
                sp.setID(rs.getInt("ID"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setImagesSP(rs.getString("imagesSP"));
                sp.setGiaSP(rs.getString("GiaSP"));
                sp.setMoTaSP(rs.getString("MoTaSP"));
                arr.add(sp);
            }
        }catch (Exception e){
            
        }
        return arr;
    }
    public ArrayList<SanPham> getlist(ArrayList<SanPham> arr, int start, int end){
        ArrayList<SanPham> list = new ArrayList<>();
        for ( int i =start ; i<end ; i++){
            list.add(arr.get(i));
        }
        return list;
    
    }
}
