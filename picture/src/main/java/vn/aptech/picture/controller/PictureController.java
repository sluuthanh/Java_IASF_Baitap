/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.picture.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.annotation.MultipartConfig;
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
import vn.aptech.picture.entity.Picture;
import vn.aptech.picture.service.PictureService;

/**
 *
 * @author namng
 */

@Controller
public class PictureController {
    
    @Autowired
    private PictureService service;
    
    @GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("list", service.findAll());
        return "index";
    }
    
    @GetMapping(value="/create")
    public String create(Model model){
        model.addAttribute("picture", new Picture());
        return "create";
    }
    
    @PostMapping(value="/save")
    public String save(@ModelAttribute("picture") Picture picture,@RequestParam("images") MultipartFile image){
     
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
                picture.setImage(image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            if(picture.getId()!=0){
                service.findById(picture.getId()).ifPresent(p->{
                    picture.setImage((p.getImage()));
                });
            }
        }
      
        service.save(picture);
        return "redirect:/";
    }
    
    @GetMapping(value="/update/{id}")
    public String update(@PathVariable("id") int id,Model model){
        service.findById(id).ifPresent(pic->{
            model.addAttribute("picture", pic);
        });
        return "create";
    }
    
    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.findById(id).ifPresent(pic->{
            service.deleteById(id);
        });
        return "redirect:/";
    }

}