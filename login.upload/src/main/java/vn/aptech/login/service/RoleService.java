/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.login.model.RoleModel;

/**
 *
 * @author Thanh Sang
 */
public interface RoleService {
    List<RoleModel> findAll();
    Optional<RoleModel> findById(int id);
    RoleModel save(RoleModel model);
    void deleteById(int id);
}
