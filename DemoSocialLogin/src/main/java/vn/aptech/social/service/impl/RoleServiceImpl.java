/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.social.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.social.entity.AppRole;
import vn.aptech.social.repository.RoleRepository;
import vn.aptech.social.service.RoleService;

/**
 *
 * @author Thanh Sang
 */

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository repo;
    
    @Override
    public List<AppRole> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<AppRole> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public AppRole save(AppRole user) {
        return repo.save(user);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
