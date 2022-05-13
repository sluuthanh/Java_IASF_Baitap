/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.BankSpring.entity.Transactions;
import vn.aptech.BankSpring.repository.TransactionsRepository;
import vn.aptech.BankSpring.service.TransactionsService;

/**
 *
 * @author namng
 */
@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository repo;
    
    @Override
    public List<Transactions> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Transactions> findByAccountname(String name) {
        return repo.findByAccountname(name);
    }
    
}
