/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.mylayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thanh Sang
 */

@Controller
public class HomeController {
    
    @GetMapping(value = {"/","/home"})
    public String index(Model model){
        return "home/index";
    }
    
    @GetMapping(value = "/login")
    public String login(Model model){
        return "authen/login";
    }
}
