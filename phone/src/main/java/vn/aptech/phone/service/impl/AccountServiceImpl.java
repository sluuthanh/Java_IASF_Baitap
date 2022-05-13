/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.phone.service.impl;

/**
 *
 * @author Administrator
 */
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
import vn.aptech.phone.entity.Account;
import vn.aptech.phone.entity.repository.AccountRepository;
import vn.aptech.phone.service.AccountService;

/**
 *
 * @author nhta1
 */
@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository repo;

    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Account> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account save(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc = repo.findByUsername(username);
        if (acc == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
            GrantedAuthority au = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(au);
//        Account userRoles = repo.findRoleByUsername(username);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (userRoles != null && authorities.size() > 0) {
//            GrantedAuthority au = new SimpleGrantedAuthority(userRoles.getRole());
//            authorities.add(au);
//        } else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean creadentialNonExpired = true;
        boolean accountNonLocked = true;

        return new User(acc.getUsername(), acc.getPassword(), enabled,
                accountNonExpired, creadentialNonExpired, accountNonExpired, authorities);
    }

}
