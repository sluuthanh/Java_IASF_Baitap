/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aithongminhhon.admin;

import aithongminhhon.dal.ChudeDal;
import aithongminhhon.entity.Chude;
import java.util.ArrayList;

/**
 *
 * @author namng
 */
public class QuanLiChude {
    ChudeDal cddal;

    public QuanLiChude() {
        cddal=new ChudeDal();
    }
    
    public ArrayList<Chude> findAll(){
        return cddal.findAll();
    }
    public void create(Chude cd){
        cddal.create(cd);
    }
    
    public void update(Chude cd){
        cddal.update(cd);
    }
    
    public void remove(int id){
        cddal.remove(id);
    }
    
}
