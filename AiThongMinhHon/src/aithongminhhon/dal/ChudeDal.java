/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.dal;

import aithongminhhon.entity.Chude;
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
public class ChudeDal {

    private Connection connectDb() throws ClassNotFoundException, SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1500;databaseName=AiThongMinhHon";
        return DriverManager.getConnection(url, "sa", "1");
    }

    public ArrayList<Chude> findAll() {
        ArrayList<Chude> danh_sach_chu_de = new ArrayList();
        try {
            Connection con = connectDb();
            String query = "SELECT * FROM chude";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chude chude = new Chude(rs.getInt(1), rs.getString(2));
                danh_sach_chu_de.add(chude);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danh_sach_chu_de;
    }

    public boolean create(Chude cd) {
        boolean check = false;
        try {
            Connection con = connectDb();
            String query = "INSERT INTO chude VALUES (?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, cd.getTen_chu_de());
            check = stm.executeUpdate() > 0;
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    public boolean update(Chude cd) {
        boolean check = false;
        try {
            Connection con = connectDb();
            String query = "UPDATE chude SET ten_chu_de=? WHERE id=?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, cd.getTen_chu_de());
            stm.setInt(2, cd.getId());
            check = stm.executeUpdate() > 0;
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
     public boolean remove(int id) {
        boolean check = false;
        try {
            Connection con = connectDb();
            String query = "DELETE chude WHERE id=?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);   
            check = stm.executeUpdate() > 0;
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
}
