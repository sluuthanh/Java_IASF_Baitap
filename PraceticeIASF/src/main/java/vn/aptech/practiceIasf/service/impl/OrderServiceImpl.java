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
import vn.aptech.practiceIasf.entity.Order;
import vn.aptech.practiceIasf.repository.OrderRepository;
import vn.aptech.practiceIasf.service.OrderService;

/**
 *
 * @author Jack
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repo;
    @Override
    public List<Order> findAll() {
        return repo.findAll(); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public Order save(Order order) {
        return repo.save(order); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> findByCode(String code) {
        return repo.findByCode(code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Order> findById(int id) {
        return repo.findById(id); //To change body of generated methods, choose Tools | Templates.
    }




}
