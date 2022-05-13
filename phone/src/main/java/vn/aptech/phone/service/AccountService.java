/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.phone.service;


import java.util.List;
import java.util.Optional;
import vn.aptech.phone.entity.Account;
/**
 *
 * @author Administrator
 */
public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(int id);
    Account save(Account account);
}

