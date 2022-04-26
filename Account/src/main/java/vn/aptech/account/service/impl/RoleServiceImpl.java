/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import vn.aptech.account.entity.Role;
import vn.aptech.account.repo.RoleRepository;
import vn.aptech.account.service.RoleService;

/**
 *
 * @author Thanh Sang
 */
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository repo;
    
    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }
    
}
