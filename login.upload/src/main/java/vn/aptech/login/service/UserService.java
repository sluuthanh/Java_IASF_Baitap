/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.login.model.UserModel;

/**
 *
 * @author Thanh Sang
 */
public interface UserService {
    List<UserModel> findAll();
    Optional<UserModel> findById(int id);
    UserModel save(UserModel user);
    void deleteById(int id);
}
