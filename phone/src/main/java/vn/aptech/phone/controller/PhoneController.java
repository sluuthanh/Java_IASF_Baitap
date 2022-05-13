/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.phone.entity.Order;
import vn.aptech.phone.service.CustomerService;
import vn.aptech.phone.service.OrderService;

/**
 *
 * @author Thanh Sang
 */
@Controller
@RequestMapping(value="/phone")
public class PhoneController {
    
    @Autowired
    private CustomerService serviceCustomer;
    @Autowired
    private OrderService service;

//    @GetMapping(value = {"/"})
//    public String index(Model model) {
//        model.addAttribute("customers",serviceCustomer.findAll());
//        model.addAttribute("orders", service.findAll());
//            return "phone/index";
//    }
//    
//    @GetMapping(value = {"/search"})
//    public String filter(Model model,@RequestParam("name") String code) {
//        model.addAttribute("customers",serviceCustomer.findAll());
//        model.addAttribute("code", service.findByCode(code));
//            return "phone/index";
//    }
    
    @RequestMapping(path = {"/", "/search"})
    public String home(Order order, Model model, String code) {
        if (code != null) {
            List<Order> orders = service.findByCode(code);
            model.addAttribute("orders", orders);
        } else {
            List<Order> orders = service.findAll();
            model.addAttribute("orders", orders);
        }
        model.addAttribute("customers", serviceCustomer.findAll());
        return "phone/index";
    }
    
    @GetMapping(value="/create")
    public String create(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("customers", serviceCustomer.findAll());
        return "phone/create";
    }
    
    @PostMapping(value="/save")
    public String save(Model model, @ModelAttribute("order") Order order,
            BindingResult result, final RedirectAttributes attributes){
        if(result.hasErrors()){
            return "phone/create";
        }
        service.save(order);
        return "redirect:/";
    }
    @GetMapping(value="/update")
    public String showUpdate(@RequestParam int id, Model model){
        model.addAttribute("order", service.findById(id));
        model.addAttribute("customers", serviceCustomer.findAll());
        return "phone/create";
    }
    
    @GetMapping(value="/delete")
    public String delete(@RequestParam int id){
        service.deleteById(id);
        return "redirect:/";
    }
}