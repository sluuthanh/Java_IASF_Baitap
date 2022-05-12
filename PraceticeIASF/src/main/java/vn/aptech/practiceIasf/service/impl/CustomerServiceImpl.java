/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.practiceIasf.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.practiceIasf.entity.Customer;
import vn.aptech.practiceIasf.repository.CustomerRepository;
import vn.aptech.practiceIasf.service.CustomerService;

/**
 *
 * @author Jack
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repo;
    @Override
    public List<Customer> findAll() {
        return repo.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Customer> findByCode(Integer code) {
        return repo.findByCode(code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByCode(Integer code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer save(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
