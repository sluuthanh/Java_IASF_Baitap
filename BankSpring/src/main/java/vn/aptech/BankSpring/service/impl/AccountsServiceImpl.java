/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.BankSpring.entity.Accounts;
import vn.aptech.BankSpring.repository.AccountsRepository;
import vn.aptech.BankSpring.service.AccountsService;

/**
 *
 * @author namng
 */
@Service
public class AccountsServiceImpl implements AccountsService {
    
    @Autowired
    private AccountsRepository repo;

    @Override
    public List<Accounts> findAll() {
       return repo.findAll();
    }


    @Override
    public boolean checkLogin(String accountname, String pincode) {
        Optional<Accounts> acc=repo.findByAccountnameAndPincode(accountname, pincode);
        boolean check=false;
        if(!(acc.isEmpty())){
            check=true;
        }
       return check;
    }

  
    
}
