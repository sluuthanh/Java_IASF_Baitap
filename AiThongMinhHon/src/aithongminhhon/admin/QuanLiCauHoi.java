/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.admin;

import aithongminhhon.dal.CauhoiDal;
import aithongminhhon.entity.Cauhoi;
import java.util.ArrayList;

/**
 *
 * @author namng
 */
public class QuanLiCauHoi {
    CauhoiDal chdal;

    public QuanLiCauHoi() {
         chdal=new CauhoiDal();
    }
    
    public ArrayList<Cauhoi> findAll(int id){
        return chdal.findAll(id);
    }
    
    public void create(Cauhoi ch){
        chdal.create(ch);
    }
    
    
}
