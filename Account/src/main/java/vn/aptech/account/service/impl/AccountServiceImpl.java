/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.service.impl;

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
import vn.aptech.account.entity.Account;
import vn.aptech.account.entity.Role;
import vn.aptech.account.repo.AccountRepository;
import vn.aptech.account.repo.RoleRepository;
import vn.aptech.account.service.AccountService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class AccountServiceImpl implements AccountService, UserDetailsService{

    @Autowired
    AccountRepository repo;
    
    @Autowired
    private RoleRepository repoRole;
    
    @Override
    public List<Account> findAll() {
    return repo.findAll();
    }

    @Override
    public Account save(Account acc) {
      return repo.save(acc);
    }

    @Override
    public Optional<Account> findById(int id) {
        return repo.findById(id);
    }
    
    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }
    
    @Override
    public Account findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc =  repo.findByUsername(username);
        if(acc ==null){
            throw new UsernameNotFoundException("User not found.");
        }
        
        
        List<Role> accountRoles = repoRole.findRoleByUsername(username);
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(accountRoles!=null && authorities.size()>0){
            for(Role r: accountRoles){
            GrantedAuthority au = new SimpleGrantedAuthority(r.getName());
            authorities.add(au);
            }
        }else{
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            
        }
            boolean enabled = true;
            boolean acccountNonExpired = true;
            boolean createdentialNonExpired = true;
            boolean accountNonLocked =  true;
            return new User(acc.getUsername(), acc.getPassword(), enabled, acccountNonExpired, createdentialNonExpired, accountNonLocked, authorities);
    }
}
