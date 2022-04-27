/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.user.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.user.entity.User;

/**
 *
 * @author Administrator
 */
public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    User save(User u);
    User findByUsername(String username);
    void deleteById(int id);
}
