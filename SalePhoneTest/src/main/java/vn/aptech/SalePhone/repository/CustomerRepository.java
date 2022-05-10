/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.SalePhone.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.SalePhone.entity.Customer;

/**
 *
 * @author Administrator
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByCode(String code);
}
