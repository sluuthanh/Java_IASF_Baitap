/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.aptech.BankSpring.entity.Transactions;

/**
 *
 * @author namng
 */
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
    
    @Query("SELECT o FROM Transactions o WHERE o.accountname = :accountname")
    List<Transactions> findByAccountname(@Param("accountname") String accountname);
}
