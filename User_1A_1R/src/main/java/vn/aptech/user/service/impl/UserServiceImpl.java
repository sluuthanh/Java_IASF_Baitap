/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.user.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import vn.aptech.user.entity.User;
import vn.aptech.user.repo.UserRepository;
import vn.aptech.user.service.UserService;

/**
 *
 * @author Administrator
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repo;
    
    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public User save(User u) {
        return repo.save(u);
    }

    @Override
    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
