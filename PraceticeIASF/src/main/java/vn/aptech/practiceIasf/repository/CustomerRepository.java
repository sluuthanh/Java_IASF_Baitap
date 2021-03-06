/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.practiceIasf.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.practiceIasf.entity.Customer;

/**
 *
 * @author Jack
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByCode(int code);
}
