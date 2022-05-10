/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.aptech.SalePhone.service.OrdersService;

/**
 * A
 *
 * @author Administrator
 */
@Controller
public class PhoneController {

    @Autowired
    private OrdersService service;

    @GetMapping("/")
    public String index(Model model) {
//        if (code.isEmpty()) {
//            model.addAttribute("orders", service.findAll());
//            return "phone/index";
//        }else{
//            model.addAttribute("orders",service.findByCode(code));
//            return "phone/index";
//        }
        model.addAttribute("orders", service.findAll());
            return "phone/index";
    }
}
