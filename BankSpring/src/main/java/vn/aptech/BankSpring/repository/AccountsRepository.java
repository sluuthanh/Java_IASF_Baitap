/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.BankSpring.entity.Accounts;

/**
 *
 * @author namng
 */
public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
    Optional<Accounts> findByAccountnameAndPincode(String accountname,String pincode);
}
