/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.aptech.account.entity.Role;

/**
 *
 * @author Thanh Sang
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    @Query("SELECT o.role FROM AccountRole o WHERE o.account.username=:username")
    List<Role> findRoleByUsername(@Param("username") String username);
}
