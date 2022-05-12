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
import vn.aptech.login.entity.User;
import vn.aptech.login.model.UserModel;

/**
 *
 * @author Thanh Sang
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    @Query("SELECT o FROM User o WHERE o.roleId=:roleId")
    List<User> findUserByRoleId(@Param("roleId") int roleId);
}
