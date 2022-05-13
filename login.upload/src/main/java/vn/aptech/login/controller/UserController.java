/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.login.entity.Users;
import vn.aptech.login.model.UserModel;
import vn.aptech.login.service.impl.UserServiceImpl;
import vn.aptech.login.validator.UserValidator;

/**
 *
 * @author Thanh Sang
 */


@Controller
@RequestMapping(value="/user")
public class UserController {
    
    @Autowired
    private UserServiceImpl service;
    
    @Autowired
    private UserValidator validator;
    
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder){
        // lay ve doi tuong can bind de check validation
        Object target = dataBinder.getTarget();
        if(target==null){
            return;
        }
        if(target.getClass()==Users.class){
            dataBinder.setValidator(validator);
        }
    }
    
    @GetMapping()
    public String index(Model model){
        model.addAttribute("users",service.findAll());
        return "user/index";
    }
    
    @GetMapping(value="/create")
    public String create(Model model){
        model.addAttribute("user",new Users());
        return "user/create";
    }
    
    @PostMapping(value="/save")
    public String save(Model model,
            @ModelAttribute("user") @Validated UserModel user,
            BindingResult result,
            @RequestParam("images") MultipartFile image,
            final RedirectAttributes attribute)
    {
        //xu ly ket qua validate
        if(result.hasErrors()){
            return "user/create";
        }
        // xu ly upload
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
                user.setImage(image.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            if(user.getId()!=0){
                service.findById(user.getId()).ifPresent(p->{
                    user.setImage((p.getImage()));
                });
            }
        }
        // luu vao db
        service.save(user);
        return "redirect:/user";
    }
    
    @GetMapping(value="/login")
    public String login(){
        return "login";
    }
}