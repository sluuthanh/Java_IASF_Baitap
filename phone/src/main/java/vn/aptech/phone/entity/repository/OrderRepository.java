/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.entity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.aptech.phone.entity.Order;

/**
 *
 * @author Thanh Sang
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{
    @Query("SELECT o FROM Order o WHERE o.code =:code")
    List<Order> findByCode(@Param("code") String code);
    
    
}
