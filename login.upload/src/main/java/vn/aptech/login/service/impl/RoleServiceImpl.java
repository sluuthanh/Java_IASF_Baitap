/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.login.entity.Role;
import vn.aptech.login.entity.Role;
import vn.aptech.login.model.RoleModel;
import vn.aptech.login.repository.RoleRepository;
import vn.aptech.login.service.RoleService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class RoleServiceImpl implements RoleService{
    
    
    @Autowired
    private RoleRepository repo;
    
    @Override
    public List<RoleModel> findAll() {
        return repo.findAll().stream().map(r->new RoleModel(r.getId(), r.getName(),r.getUser()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleModel> findById(int id) {
        if(repo.findById(id).isPresent()) {
            Role r= repo.findById(id).get();
            return Optional.of(new  RoleModel(r.getId(), r.getName(),r.getUser()));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public RoleModel save(RoleModel r) {
        Role role = new Role(r.getId(), r.getName(), r.getUser());
        Role savedRole =  repo.save(role);
        return new RoleModel(savedRole.getId(), savedRole.getName(), savedRole.getUser());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
