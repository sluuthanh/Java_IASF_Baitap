/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.login.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.aptech.login.entity.Users;
import vn.aptech.login.model.UserModel;

/**
 *
 * @author Thanh Sang
 */
public interface UserRepository extends JpaRepository<Users, Integer>{
    Users findByUsername(String username);
    @Query("SELECT o FROM Users o WHERE o.username=:username")
    Users findRoleByUsername(@Param("username")String username);
}
