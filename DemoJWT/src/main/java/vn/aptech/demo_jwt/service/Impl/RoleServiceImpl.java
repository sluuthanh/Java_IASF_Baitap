/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demo_jwt.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.demo_jwt.entity.Role;
import vn.aptech.demo_jwt.repository.RoleRepository;
import vn.aptech.demo_jwt.service.RoleService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository repo;
    
    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return repo.save(role);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
