/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.dal;

import aithongminhhon.entity.Cauhoi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author namng
 */
public class CauhoiDal {
     private Connection connectDb() throws ClassNotFoundException, SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=AiThongMinhHon";
        return DriverManager.getConnection(url, "sa", "1");
    }
     
      public ArrayList<Cauhoi> findAll(){
        ArrayList<Cauhoi> danh_sach_cau_hoi=new ArrayList();
        try{
            Connection con=connectDb();
            String query="SELECT * FROM cauhoi";
            PreparedStatement stm=con.prepareStatement(query);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Cauhoi cauhoi=new Cauhoi(rs.getInt("id"),rs.getString("cau_hoi"),rs.getString("cau_a"),
                                         rs.getString("cau_b"),rs.getString("cau_c"),rs.getString("cau_d"),
                                         rs.getString("dap_an"),rs.getString("dap_an_chi_tiet"),
                                         rs.getInt("chu_de_id"));
                danh_sach_cau_hoi.add(cauhoi);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return danh_sach_cau_hoi;
    }
     
    public ArrayList<Cauhoi> findAll(int chu_de_id){
        ArrayList<Cauhoi> danh_sach_cau_hoi=new ArrayList();
        try{
            Connection con=connectDb();
            String query="SELECT * FROM cauhoi WHERE chu_de_id=?";
            PreparedStatement stm=con.prepareStatement(query);
            stm.setInt(1, chu_de_id);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Cauhoi cauhoi=new Cauhoi(rs.getInt("id"),rs.getString("cau_hoi"),rs.getString("cau_a"),
                                         rs.getString("cau_b"),rs.getString("cau_c"),rs.getString("cau_d"),
                                         rs.getString("dap_an"),rs.getString("dap_an_chi_tiet"),
                                         rs.getInt("chu_de_id"));
                danh_sach_cau_hoi.add(cauhoi);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return danh_sach_cau_hoi;
    }
    
    
    public boolean create(Cauhoi ch) {
        boolean check = false;
        try {
            Connection con = connectDb();
            String query = "INSERT INTO cauhoi VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, ch.getCau_hoi());
            stm.setString(2, ch.getCau_a());
            stm.setString(3, ch.getCau_b());
            stm.setString(4, ch.getCau_c());
            stm.setString(5, ch.getCau_d());
            stm.setString(6, ch.getDap_an());
            stm.setString(7, ch.getDap_an_chi_tiet());
            stm.setInt(8, ch.getChu_de_id());
            check = stm.executeUpdate() > 0;
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
}
