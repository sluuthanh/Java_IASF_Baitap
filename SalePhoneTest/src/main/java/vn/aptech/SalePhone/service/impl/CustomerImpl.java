/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.SalePhone.entity.Customer;
import vn.aptech.SalePhone.repository.CustomerRepository;
import vn.aptech.SalePhone.service.CustomerService;

/**
 *
 * @author Administrator
 */
@Service
public class CustomerImpl implements CustomerService{

    @Autowired
    private CustomerRepository repo;
    
    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> findByCode(String code) {
        return repo.findByCode(code);
    }

    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }
    
}
