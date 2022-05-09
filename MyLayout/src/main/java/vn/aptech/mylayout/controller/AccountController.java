/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.mylayout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.mylayout.entity.Account;
import vn.aptech.mylayout.service.AccountService;
import vn.aptech.mylayout.service.RoleService;

/**
 *
 * @author Thanh Sang
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    
    @Autowired
    private AccountService service;
    @Autowired
    private RoleService serviceRole;
    @Autowired
    private PasswordEncoder pwdEncoder;
    @GetMapping(value = "")
    public String index(Model model){
        model.addAttribute("accounts",service.findAll());
        return "account/index";
    }
    
    @GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("roles", serviceRole.findAll());
        return "account/create";
    }
    
    @PostMapping(value = "/save")
    public String save(Model model, 
            @ModelAttribute("account") Account account,
            BindingResult result, 
            final RedirectAttributes attributes){
        account.setPassword(pwdEncoder.encode(account.getPassword()));
        service.save(account);
        return "redirect:account";
    }
}
