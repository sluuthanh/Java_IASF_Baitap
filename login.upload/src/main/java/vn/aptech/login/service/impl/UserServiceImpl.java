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
import vn.aptech.login.entity.User;
import vn.aptech.login.model.UserModel;
import vn.aptech.login.repository.UserRepository;
import vn.aptech.login.service.UserService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repo;
    
    @Override
    public List<UserModel> findAll() {
        return repo.findAll().stream().map(r->new UserModel(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRoleId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> findById(int id) {
        if(repo.findById(id).isPresent()) {
            User r= repo.findById(id).get();
            return Optional.of(new  UserModel(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRoleId()));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public UserModel save(UserModel r) {
        User user = new  User(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRoleId());
        User savedUser =  repo.save(user);
        return new UserModel(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword(), savedUser.getImage(), savedUser.getRoleId());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
