/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demo_jwt.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demo_jwt.entity.Role;

/**
 *
 * @author Thanh Sang
 */
public interface RoleService {
    
    List<Role> findAll();
    Optional<Role> findById(int id);
    Optional<Role> findByName(String name);
    Role save(Role role);
    void deleteById(int id);
}
