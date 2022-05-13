/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.aptech.login.service.AccountService;

/**
 *
 * @author nhta1
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
