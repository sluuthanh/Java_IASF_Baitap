/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.aptech.BankSpring.service.AccountsService;
import vn.aptech.BankSpring.service.TransactionsService;

/**
 *
 * @author namng
 */
@Controller
public class HomeController {
    @Autowired
    private AccountsService acc_service;
    
    @Autowired
    private TransactionsService tran_service;
    
    @GetMapping(value="/")
    public String index(){
        return "login";
    }
    
    @GetMapping(value="/checklogin")
    public String checklogin(@RequestParam("accountname") String accountname,@RequestParam("pincode") String pincode,Model model){
        boolean check=acc_service.checkLogin(accountname, pincode);
        if(check==true){
            model.addAttribute("list", tran_service.findByAccountname(accountname));
            model.addAttribute("accountname", accountname);
            return "trans";
        }else{
            return "error";
        }
    }
    
}
