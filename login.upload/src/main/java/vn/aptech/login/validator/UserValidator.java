/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.aptech.login.entity.Users;
import vn.aptech.login.service.UserService;

/**
 *
 * @author Thanh Sang
 */

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz  == Users.class; 
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "acc.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "acc.password");
    }
    
}

