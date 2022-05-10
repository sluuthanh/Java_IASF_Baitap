/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.SalePhone.entity.Order;
import vn.aptech.SalePhone.repository.OrdersRepository;
import vn.aptech.SalePhone.service.OrdersService;

/**
 *
 * @author Administrator
 */
@Service
public class OrdersImpl implements OrdersService{

    @Autowired
    private OrdersRepository repo;
    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Order> findByCode(String code) {
        return repo.findByCode(code);
    }

    @Override
    public Order save(Order orders) {
        return repo.save(orders);
    }
    
}
