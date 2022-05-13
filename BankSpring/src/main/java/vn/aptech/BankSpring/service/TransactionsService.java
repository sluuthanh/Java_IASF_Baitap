/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.BankSpring.service;

import java.util.List;
import vn.aptech.BankSpring.entity.Transactions;

/**
 *
 * @author namng
 */
public interface TransactionsService {
    List<Transactions> findAll();
    List<Transactions> findByAccountname(String name);
}
