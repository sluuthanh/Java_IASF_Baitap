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
public class AccountController {
    
    @GetMapping(value="/login")
    public String login(Model model){
        return "login";
    }
    
}