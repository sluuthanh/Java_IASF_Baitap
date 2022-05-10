/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.SalePhone.entity.Order;

/**
 *
 * @author Administrator
 */
public interface OrdersService {
    List<Order> findAll();
    List<Order> findByCode(String code);
    Order save(Order orders);
}
