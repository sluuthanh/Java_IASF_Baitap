/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.entity.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.phone.entity.Customer;

/**
 *
 * @author Thanh Sang
 */
public interface CustomerRepository extends JpaRepository<Customer, String>{
    Optional<Customer> findByCode(String code);
}
