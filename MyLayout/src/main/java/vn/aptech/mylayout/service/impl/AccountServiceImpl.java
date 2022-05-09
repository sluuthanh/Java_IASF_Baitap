/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.mylayout.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.aptech.mylayout.entity.Account;
import vn.aptech.mylayout.entity.Role;
import vn.aptech.mylayout.repository.AccountRepository;
import vn.aptech.mylayout.repository.RoleRepository;
import vn.aptech.mylayout.service.AccountService;

/**
 *
 * @author Thanh Sang
 */

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService{

    @Autowired
    private AccountRepository repo;
    
    @Autowired
    private RoleRepository repoRole;
    
    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Account findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc= repo.findByUsername(username);
        if(acc==null){
            throw new UsernameNotFoundException("Username: "+username+"not exist" );
        }
        List<GrantedAuthority> authoritys = new ArrayList<>();
        List<Role> roles = repoRole.findRoleByUsername(username);
        roles.forEach(r->{
            authoritys.add(new SimpleGrantedAuthority(r.getName()));
        });
        
        boolean enable=true;
        boolean accountNonExpired=true;
        boolean cridentialNonExpired=true;
        boolean accountNonLocked=true;
        
        return new User(username, acc.getPassword(), enable, accountNonExpired, cridentialNonExpired, accountNonLocked, authoritys);
    }
    
}
