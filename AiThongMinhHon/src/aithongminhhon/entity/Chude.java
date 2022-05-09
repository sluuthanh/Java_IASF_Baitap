/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.entity;

import javax.swing.JOptionPane;

/**
 *
 * @author namng
 */
public class Chude {
    private int id;
    private String ten_chu_de;

    public Chude() {
    }

    public Chude(int id, String ten_chu_de) {
        this.id = id;
        this.ten_chu_de = ten_chu_de;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ten_chu_de
     */
    public String getTen_chu_de() {
        return ten_chu_de;
    }

    /**
     * @param ten_chu_de the ten_chu_de to set
     */
    public void setTen_chu_de(String ten_chu_de) {
        this.ten_chu_de = ten_chu_de;
    }

    @Override
    public String toString() {
        return id+"."+ten_chu_de;
    }
    
    public void input(){
        ten_chu_de=JOptionPane.showInputDialog("Tên chủ đề:");
    }
    
    
}
