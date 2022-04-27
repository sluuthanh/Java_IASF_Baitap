/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.user.entity.User;

/**
 *
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
