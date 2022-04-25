/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.aptech.student.entity.Student;
import vn.aptech.student.service.StudentService;

/**
 *
 * @author Thanh Sang
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    
    @GetMapping(value="/student")
    public String index(Model model){
        model.addAttribute("students",service.findAll());
        return "index";
    }
    @GetMapping(value="/student/create")
    public String create(Model model){
        model.addAttribute("student", new Student());
        return "create";
    }
    
    @PostMapping(value="/student/save")
    public String save(@ModelAttribute Student student){
        service.save(student);
        //redirect ve action /student
        return "redirect:/student";
    }
    
    
    @GetMapping(value="/student/update/{id}")
    public String update(@PathVariable("id") int id,Model model){
        service.findById(id).ifPresent(stu->{
            model.addAttribute("student",stu);
        });
        return "create";
    }
    
    @GetMapping(value="/student/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.findById(id).ifPresent(stu->{
            service.deleteById(stu.getId());
        });
        return "redirect:/student";
    }
}
