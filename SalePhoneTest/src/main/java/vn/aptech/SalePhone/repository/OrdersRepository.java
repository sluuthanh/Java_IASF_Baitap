/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.aptech.SalePhone.entity.Customer;
import vn.aptech.SalePhone.entity.Order;

/**
 *
 * @author Administrator
 */
public interface OrdersRepository extends JpaRepository<Order, Integer>{
//    @Query("SELECT o.code FROM Orders o WHERE o.customers.code=:code")
//    List<Orders> findOrdersByCodeCustomer(String code);
    @Query("SELECT o FROM Order o WHERE o.customers.code=:code")
    List<Order> findByCode(String code);
}
