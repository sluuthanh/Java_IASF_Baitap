/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.phone.entity.Order;

/**
 *
 * @author Thanh Sang
 */
public interface OrderService {
    List<Order> findAll();
    List<Order> findByCode(String code);
    Order save(Order order);
    Optional<Order> findById(int id);
    void deleteById(int id);
}
