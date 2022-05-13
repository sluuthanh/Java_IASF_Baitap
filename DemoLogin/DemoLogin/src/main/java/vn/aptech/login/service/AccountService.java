/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vn.aptech.login.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.login.entity.Account;

/**
 *
 * @author nhta1
 */
public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(int id);
    Account save(Account account);
}
