/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.aptech.welcome.entity.Customer;

/**
 *
 * @author Thanh Sang
 */
@Controller
public class WelcomeController {
    @GetMapping(value= "/")
    public String index(Model model){
        Customer cust = new Customer(1,"sang","sluuthanh@gmail.com");
        model.addAttribute("cust",cust);
        return "index";
    }
}
