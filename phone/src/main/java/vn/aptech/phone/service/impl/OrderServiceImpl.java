/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.phone.entity.Order;
import vn.aptech.phone.entity.repository.OrderRepository;
import vn.aptech.phone.service.OrderService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repo;
    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Order> findByCode(String code) {
        return repo.findByCode(code);
    }

    @Override
    public Order save(Order order) {
        return repo.save(order);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Order> findById(int id) {
        return repo.findById(id);
    }
    
}
