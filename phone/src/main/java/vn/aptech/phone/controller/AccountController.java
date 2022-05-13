/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.phone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.aptech.phone.service.AccountService;
/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value="/account")
public class AccountController {
    @Autowired
    private AccountService service;
    
     @GetMapping(value="")
    public String index(Model model){
        model.addAttribute("accounts", service.findAll());
        return "account/index";
    }
    @GetMapping(value="/login")
    public String login(Model model){
        return "login";
    }
    
}