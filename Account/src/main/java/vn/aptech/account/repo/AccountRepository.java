/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.account.entity.Account;

/**
 *
 * @author Thanh Sang
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{
    
}
