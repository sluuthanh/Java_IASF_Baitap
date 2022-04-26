/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.service;

import java.util.List;
import vn.aptech.account.entity.Role;

/**
 *
 * @author Thanh Sang
 */
public interface RoleService {
    List<Role> findAll();
}
