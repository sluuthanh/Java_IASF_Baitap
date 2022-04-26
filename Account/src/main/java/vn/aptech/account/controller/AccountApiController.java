/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.aptech.account.entity.Account;
import vn.aptech.account.service.AccountService;

/**
 *
 * @author Thanh Sang
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/account")
public class AccountApiController {

    @Autowired
    private AccountService service;
    
    @GetMapping
    public List<Account> getAccounts(){
        return service.findAll();
    }
}
