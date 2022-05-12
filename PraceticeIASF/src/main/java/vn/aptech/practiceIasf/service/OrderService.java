/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.practiceIasf.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.practiceIasf.entity.Order;

/**
 *
 * @author Jack
 */
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(int id);

    Order save(Order order);

    List<Order> findByCode(String code);
    void deleteById(int id);
}
