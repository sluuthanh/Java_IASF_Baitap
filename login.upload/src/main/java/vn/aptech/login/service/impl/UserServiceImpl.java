/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.aptech.login.entity.Users;
import vn.aptech.login.model.UserModel;
import vn.aptech.login.repository.UserRepository;
import vn.aptech.login.service.UserService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<UserModel> findAll() {
        return repo.findAll().stream().map(r -> new UserModel(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> findById(int id) {
        if (repo.findById(id).isPresent()) {
            Users r = repo.findById(id).get();
            return Optional.of(new UserModel(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRole()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public UserModel save(UserModel r) {
        Users user = new Users(r.getId(), r.getUsername(), r.getPassword(), r.getImage(), r.getRole());
        Users savedUser = repo.save(user);
        return new UserModel(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword(), savedUser.getImage(), savedUser.getRole());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users u = repo.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Users userRoles = repo.findRoleByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (userRoles != null && authorities.size() > 0) {
            GrantedAuthority au = new SimpleGrantedAuthority(userRoles.getRole());
            authorities.add(au);
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        boolean enabled = true;
        boolean acccountNonExpired = true;
        boolean createdentialNonExpired = true;
        boolean accountNonLocked = true;
        return new User(u.getUsername(), u.getPassword(), enabled, acccountNonExpired, createdentialNonExpired, accountNonLocked, authorities);
    }

}
