/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.phone.entity.Customer;
import vn.aptech.phone.entity.repository.CustomerRepository;
import vn.aptech.phone.service.CustomerService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
    
}
