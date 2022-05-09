/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.entity;

import aithongminhhon.admin.QuanLiChude;
import javax.swing.JOptionPane;

/**
 *
 * @author namng
 */
public class Cauhoi {
    private int id;
    private String cau_hoi;
    private String cau_a;
    private String cau_b;
    private String cau_c;
    private String cau_d;
    private String dap_an;
    private String dap_an_chi_tiet;
    private int chu_de_id;

    public Cauhoi() {
    }

    public Cauhoi(int id, String cau_hoi, String cau_a, String cau_b, String cau_c, String cau_d, String dap_an, String dap_an_chi_tiet, int chu_de_id) {
        this.id = id;
        this.cau_hoi = cau_hoi;
        this.cau_a = cau_a;
        this.cau_b = cau_b;
        this.cau_c = cau_c;
        this.cau_d = cau_d;
        this.dap_an = dap_an;
        this.dap_an_chi_tiet = dap_an_chi_tiet;
        this.chu_de_id = chu_de_id;
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
     * @return the cau_hoi
     */
    public String getCau_hoi() {
        return cau_hoi;
    }

    /**
     * @param cau_hoi the cau_hoi to set
     */
    public void setCau_hoi(String cau_hoi) {
        this.cau_hoi = cau_hoi;
    }

    /**
     * @return the cau_a
     */
    public String getCau_a() {
        return cau_a;
    }

    /**
     * @param cau_a the cau_a to set
     */
    public void setCau_a(String cau_a) {
        this.cau_a = cau_a;
    }

    /**
     * @return the cau_b
     */
    public String getCau_b() {
        return cau_b;
    }

    /**
     * @param cau_b the cau_b to set
     */
    public void setCau_b(String cau_b) {
        this.cau_b = cau_b;
    }

    /**
     * @return the cau_c
     */
    public String getCau_c() {
        return cau_c;
    }

    /**
     * @param cau_c the cau_c to set
     */
    public void setCau_c(String cau_c) {
        this.cau_c = cau_c;
    }

    /**
     * @return the cau_d
     */
    public String getCau_d() {
        return cau_d;
    }

    /**
     * @param cau_d the cau_d to set
     */
    public void setCau_d(String cau_d) {
        this.cau_d = cau_d;
    }

    /**
     * @return the dap_an
     */
    public String getDap_an() {
        return dap_an;
    }

    /**
     * @param dap_an the dap_an to set
     */
    public void setDap_an(String dap_an) {
        this.dap_an = dap_an;
    }

    /**
     * @return the dap_an_chi_tiet
     */
    public String getDap_an_chi_tiet() {
        return dap_an_chi_tiet;
    }

    /**
     * @param dap_an_chi_tiet the dap_an_chi_tiet to set
     */
    public void setDap_an_chi_tiet(String dap_an_chi_tiet) {
        this.dap_an_chi_tiet = dap_an_chi_tiet;
    }

    /**
     * @return the chu_de_id
     */
    public int getChu_de_id() {
        return chu_de_id;
    }

    /**
     * @param chu_de_id the chu_de_id to set
     */
    public void setChu_de_id(int chu_de_id) {
        this.chu_de_id = chu_de_id;
    }

    @Override
    public String toString() {
        return  cau_hoi+"\n Đáp án chi tiết:" + dap_an_chi_tiet+"\n\n\n\n\n" ;
    }
    
    public void input(){
        QuanLiChude qlcd = new QuanLiChude();
        int index=JOptionPane.showOptionDialog(null, "Thêm câu hỏi cho chủ đề:", "Thêm câu hỏi:", 0, 0, null, qlcd.findAll().toArray(), qlcd.findAll().get(0));
        chu_de_id=qlcd.findAll().get(index).getId();
        cau_hoi=JOptionPane.showInputDialog("Nhập Câu hỏi:");
        cau_a=JOptionPane.showInputDialog("Câu A:");
        cau_b=JOptionPane.showInputDialog("Câu B:");
        cau_c=JOptionPane.showInputDialog("Câu C:");
        cau_d=JOptionPane.showInputDialog("Câu D:");
        dap_an=JOptionPane.showInputDialog("Nhập Đáp án đúng (1 kí tự A-B-C-D):");
        dap_an=dap_an.toUpperCase();
        dap_an_chi_tiet=JOptionPane.showInputDialog("Nhập Đáp án chi tiết(có thể giai thích rõ):");
          
    }
    
    
} 
