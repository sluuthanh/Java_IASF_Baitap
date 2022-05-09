/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demo_jwt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.demo_jwt.entity.Role;

/**
 *
 * @author Thanh Sang
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByName(String name);
}
