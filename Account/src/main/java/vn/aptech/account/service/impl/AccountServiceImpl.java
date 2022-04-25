/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.account.entity.Account;
import vn.aptech.account.repo.AccountRepository;
import vn.aptech.account.service.AccountService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository repo;
    
    @Override
    public List<Account> findAll() {
    return repo.findAll();
    }

    @Override
    public Account save(Account acc) {
      return repo.save(acc);
    }

    @Override
    public Optional<Account> findById(int id) {
        return repo.findById(id);
    }
    
}
