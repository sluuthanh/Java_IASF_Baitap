/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.social.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thanh Sang
 */
@Controller
public class HomeController {
    @GetMapping(value = "")
    public String index(){
        return "index";
    }
    @GetMapping(value = "home")
    public String home(){
        return "home";
    }
}
