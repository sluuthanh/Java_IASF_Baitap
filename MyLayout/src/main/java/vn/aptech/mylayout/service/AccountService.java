/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.mylayout.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.mylayout.entity.Account;

/**
 *
 * @author Thanh Sang
 */
public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(Integer id);
    Account findByUsername(String username);
    Account save(Account account);
}
