/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.BankSpring.entity.Accounts;

/**
 *
 * @author namng
 */
public interface AccountsService {
    List<Accounts> findAll();
    boolean checkLogin(String accountname,String pincode);
};
