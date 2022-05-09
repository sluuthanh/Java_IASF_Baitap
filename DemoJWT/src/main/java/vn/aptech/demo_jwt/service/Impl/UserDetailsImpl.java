/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demo_jwt.service.Impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vn.aptech.demo_jwt.entity.User;

/**
 *
 * @author Thanh Sang
 */
public class UserDetailsImpl implements UserDetails{
    
    private int id;
    private String username;
    
    //@JsonIgnore ko chuyen field nay ve json 
    @JsonIgnore
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authoritys;

    public UserDetailsImpl(int id, String username, String password, String email, Collection<? extends GrantedAuthority> authoritys) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authoritys = authoritys;
    }
    
    public static UserDetails build(User user) {
        List<GrantedAuthority> authos= user.getRoles()
                .stream()
                .map(u-> new SimpleGrantedAuthority(u.getName()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getId()
                , user.getEmail()
                , user.getPassword()
                , user.getUsername()
                , authos);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authoritys;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
    
    

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
