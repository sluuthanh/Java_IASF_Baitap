/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.controller;

import aithongminhhon.admin.QuanLiCauHoi;
import aithongminhhon.admin.QuanLiChude;
import aithongminhhon.dal.CauhoiDal;
import aithongminhhon.dal.ChudeDal;
import aithongminhhon.entity.Cauhoi;
import aithongminhhon.entity.Chude;
import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author namng
 */
public class Game {

    private static Scanner sc = new Scanner(System.in);

    public static void run() {
        int choose = 0;
        do {
            choose = Integer.parseInt(menu());
            switch (choose) {
                case 1:
                    play();
                    break;
                case 2:
                    adminPage();
                    break;
                case 3:
                    break;
            }
        } while (choose != 3);
    }

    private static void play() {
        ChudeDal cddal = new ChudeDal();
        CauhoiDal chdal = new CauhoiDal();
        String player1_name = JOptionPane.showInputDialog("Tên người chơi 1:");
        String player2_name = JOptionPane.showInputDialog("Tên người chơi 2:");
        int index = JOptionPane.showOptionDialog(null, "Lựa chọn chủ đề", "Chọn chủ đề:", 0, 0, null, cddal.findAll().toArray(), cddal.findAll().get(0));
        int chu_de_id=cddal.findAll().get(index).getId();;
        ArrayList<Cauhoi> danh_sach_cau_hoi = chdal.findAll(chu_de_id);
        int player1_score = 0;
        int player2_score = 0;
        int count = 0;
        while (danh_sach_cau_hoi.size() > 0 && count < 10) {
            count++;
            index = getRandomInteger(1, danh_sach_cau_hoi.size()) - 1;
            Cauhoi ch = danh_sach_cau_hoi.get(index);
            String dap_an = JOptionPane.showInputDialog(null,"Câu"+count+":"+ ch.getCau_hoi() + "\nA." + ch.getCau_a() + "   \tB." + ch.getCau_b()
                    + "   \nC." + ch.getCau_c() + "  \tD." + ch.getCau_d());
            dap_an = dap_an.toUpperCase();
            if (!(count % 2 == 0)) {
                if (dap_an.equals(ch.getDap_an())) {
                    player1_score++;
                    JOptionPane.showMessageDialog(null, "Đáp án chính xác\n " + ch.getDap_an_chi_tiet() + "\n " + player1_name + "có " + player1_score + " điểm");
                } else {
                    JOptionPane.showMessageDialog(null, "Đáp án" + dap_an + "là đáp án sai\n Đáp án đúng là" + ch.getDap_an_chi_tiet());
                }
            } else {
                if (dap_an.equals(ch.getDap_an())) {
                    player2_score++;
                    JOptionPane.showMessageDialog(null, "Đáp án chính xác\n" + ch.getDap_an_chi_tiet() + "\n " + player2_name + "có " + player2_score + " điểm");
                } else {
                    JOptionPane.showMessageDialog(null, "Đáp án" + dap_an + "là đáp án sai\n Đáp án đúng là" + ch.getDap_an_chi_tiet());
                }
            }
            danh_sach_cau_hoi.remove(index);
        }
        if (player1_score > player2_score) {
            JOptionPane.showMessageDialog(null, player1_name + "   chiến thắng với tổng " + player1_score + "điểm");
        }
        if (player1_score < player2_score) {
            JOptionPane.showMessageDialog(null, player2_name + "   chiến thắng với tổng " + player2_score + "điểm");
        }
        if (player1_score == player2_score) {
            JOptionPane.showMessageDialog(null, "Hòa");
        }

    }

    private static String menu() {
        return JOptionPane.showInputDialog(null, "1.Chơi\n2.AdminLTE\n3.Thoát");
    }

    private static boolean checkLogin(String user, String pass) {
        return user.equals("nam") && pass.equals("123");
    }

//    private static int getRandomInteger(int min,int max){
//        return ((int)(Math.random()*(max-min))+min);
//    }
    
    private static int getRandomInteger(int min, int max) {
        Random rd = new Random();
        return (rd.nextInt(max) + min);
    }

    private static void adminPage() {
        String user = JOptionPane.showInputDialog("Tài Khoản:");
        String password = JOptionPane.showInputDialog("Mật Khẩu:");
        if (checkLogin(user, password)) {
            int choose = 0;
            do {
                choose = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Quản lí Chủ đề\n2.Quản lí Câu hỏi\n3.Thoát"));
                switch (choose) {
                    case 1:
                        int choice = 0;
                        do {
                            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Thêm chủ đề\n2.Sửa chủ đề\n3.Danh sách\n4.Xóa chủ đề\n5.Thoát"));
                            chudeManager(choice);
                        } while (choice != 5);
                        break;
                    case 2:
                        choice = 0;
                        do {
                            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Thêm câu hỏi\n2.Sửa câu hỏi\n3.Danh sách\n4.Xóa câu hỏi\n5.Thoát"));
                            cauhoiManager(choice);
                        } while (choice != 5);
                        break;
                    case 3:
                        break;
                }
            } while (choose != 3);
        } else {
            JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
        }
    }

    private static void chudeManager(int choice) {
        QuanLiChude qlcd = new QuanLiChude();
        switch (choice) {
            case 1:
                Chude cd = new Chude();
                cd.input();
                qlcd.create(cd);
                break;
            case 2:
                int id = JOptionPane.showOptionDialog(null, "Sửa chủ đề", "Chọn chủ đề để sửa:", 0, 0, null, qlcd.findAll().toArray(), qlcd.findAll().get(0));
                id++;
                cd = new Chude();
                cd.setId(id);
                cd.input();
                qlcd.update(cd);
                break;
            case 3:
                JOptionPane.showOptionDialog(null, "Chủ đề", "Danh sách chủ đê:", 0, 0, null, qlcd.findAll().toArray(), qlcd.findAll().get(0));
                break;
            case 4:
//                id = JOptionPane.showOptionDialog(null, "Xóa chủ đề", "Chọn chủ đề để xóa:", 0, 0, null, qlcd.findAll().toArray(), qlcd.findAll().get(0));
//                id++;
//                qlcd.remove(id);
            case 5:
                break;
        }
    }

    private static void cauhoiManager(int choice) {
        QuanLiChude qlcd = new QuanLiChude();
        QuanLiCauHoi qlch = new QuanLiCauHoi();
        switch (choice) {
            case 1:
                Cauhoi ch = new Cauhoi();
                ch.input();
                qlch.create(ch);
                break;
            case 2:

                break;
            case 3:
                int id = JOptionPane.showOptionDialog(null, "Chủ đề", "Lấy danh sách câu hỏi theo chủ đề:", 0, 0, null, qlcd.findAll().toArray(), qlcd.findAll().get(0));
                id++;
                JOptionPane.showOptionDialog(null, qlcd.findAll().get(id - 1).getTen_chu_de(), "Danh sách câu hỏi", 2, 0, null, qlch.findAll(id).toArray(), qlch.findAll(id).get(0));
                break;
            case 4:

            case 5:
                break;
        }
    }
}
