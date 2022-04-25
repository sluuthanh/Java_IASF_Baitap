/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.aptech.account.entity.Account;
import vn.aptech.account.service.AccountService;

/**
 *
 * @author Thanh Sang
 */

@Component
public class AccountValidator implements Validator{

    @Autowired
    private AccountService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz  == Account.class; 
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "acc.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "acc.password");
    }
    
}
