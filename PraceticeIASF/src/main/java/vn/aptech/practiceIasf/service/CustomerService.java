/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.practiceIasf.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.practiceIasf.entity.Customer;

/**
 *
 * @author Jack
 */
public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findByCode(Integer code);
    Customer findByName(String name);
    void deleteByCode(Integer code);
    Customer save(Customer customer);
}
