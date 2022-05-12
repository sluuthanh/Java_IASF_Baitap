/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.practiceIasf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.practiceIasf.entity.Order;
import vn.aptech.practiceIasf.service.CustomerService;
import vn.aptech.practiceIasf.service.OrderService;

/**
 *
 * @author Jack
 */
@Controller
public class HomeController {
    @Autowired
    private OrderService service;
    @Autowired
    private CustomerService serviceCus;
//    @GetMapping(value="/")
//    public String index(Model model){
//        model.addAttribute("orders", service.findAll());
//        model.addAttribute("customers", serviceCus.findAll());
//        
//        return "index";
//    }
//    @GetMapping(value="/s/{code}")
//    public String find(Model model,@PathVariable("code") String code){
//        List<Order> orders = service.findByCode(code);
//        if(orders!=null){
//            model.addAttribute("orders", orders);
//        }
//        model.addAttribute("customers", serviceCus.findAll());
//        return "search";
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
        model.addAttribute("customers", serviceCus.findAll());
        return "index";
    }
    @GetMapping(value="/create")
    public String create(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("customers", serviceCus.findAll());
        return "create";
    }
    @PostMapping(value="/save")
    public String save(Model model, @ModelAttribute("order") Order order,
            BindingResult result, final RedirectAttributes attributes){
        if(result.hasErrors()){
            return "create";
        }
        service.save(order);
        return "redirect:/";
    }
    @GetMapping(value="/update")
    public String showUpdate(@RequestParam int id, Model model){
        model.addAttribute("order", service.findById(id));
        model.addAttribute("customers", serviceCus.findAll());
        return "create";
    }
    
    @GetMapping(value="/delete")
    public String delete(Model model,@RequestParam int id){
        service.deleteById(id);
        return "redirect:/";
    }
}
