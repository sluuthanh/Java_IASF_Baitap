/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.staff.entity.Staff;
import vn.aptech.staff.service.DepartmentService;
import vn.aptech.staff.service.StaffService;

/**
 *
 * @author namng
 */
@Controller
public class HomeController {
    @Autowired
    private DepartmentService dep_service;
    
    @Autowired
    private StaffService sta_service;
    
    @GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("list", sta_service.findAll());
        return "index";
    }
    
    @GetMapping(value="/create")
    public String create(Model model){
        model.addAttribute("staff", new Staff());
        model.addAttribute("deplist", dep_service.findAll());
        return "create";
    }
    
    @PostMapping(value="/save")
    public String save(@ModelAttribute("staff") Staff staff,@RequestParam("images")MultipartFile image){
        
           if(!image.isEmpty()){
            //image khong trong => co file upload
            try {
                byte[] bytes = image.getBytes(); // doc du lieu upload
                File uploadFolder= ResourceUtils.getFile("classpath:static/images");
                // bien luu thong tin duong dan vao file can luu
                Path imgPath = Paths.get(uploadFolder.getPath(), image.getOriginalFilename());
                // gui du lieu byte vao file
                Files.write(imgPath, bytes);
                //luu lai filename vao entity de ghi vao db
                staff.setImage(image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            if(staff.getId()!=0){
                sta_service.findById(staff.getId()).ifPresent(p->{
                    staff.setImage((p.getImage()));
                });
            }
        }
      
        sta_service.save(staff);
        return "redirect:/";
    }
    
    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") int id){
        sta_service.findById(id).ifPresent(sta->{
            sta_service.deleteById(id);
        });
        return "redirect:/";
    }
    
    @GetMapping(value="/update/{id}")
    public String update(@PathVariable("id") int id,Model model){
        sta_service.findById(id).ifPresent(sta->{
            model.addAttribute("staff", sta);
            model.addAttribute("deplist", dep_service.findAll());
        });
        return "create";
    }
}
