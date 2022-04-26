/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") int id){
        return service.findById(id).orElseThrow(RuntimeException::new);
    }
    
    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account) throws URISyntaxException{
        Account savedAccount = service.save(account);
        return ResponseEntity.created(new URI("/api/account/"+savedAccount.getId())).body(savedAccount);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable("id") int id, @RequestBody Account account){
        Account curAccount =  service.findById(id).orElseThrow(RuntimeException::new);
        curAccount.setUsername(account.getUsername());
        curAccount.setUsername(account.getFullname());
        curAccount = service.save(curAccount);
        return ResponseEntity.ok(curAccount);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id") int id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
