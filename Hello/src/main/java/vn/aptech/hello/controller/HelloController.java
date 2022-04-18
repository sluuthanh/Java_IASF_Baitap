/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thanh Sang
 */

@Controller
public class HelloController {
    
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";  // WEB-INF/jsp/hello.jsp
    }
}
