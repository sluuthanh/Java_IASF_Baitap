/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.user.entity.User;
import vn.aptech.user.service.UserService;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("users",service.findAll());
        return "user/index";
    }
    
    @GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }
    
    @PostMapping(value = "/save")
    public String save(Model model,
            @ModelAttribute("user") User user,
            BindingResult result,
            final RedirectAttributes attributes
    ){
        if(result.hasErrors()){
            return "user/create";
        }
        service.save(user);
        return "redirect:/user";
    }
    
    
}
