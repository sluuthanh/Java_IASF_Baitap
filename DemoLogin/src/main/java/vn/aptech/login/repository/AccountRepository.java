/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vn.aptech.login.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.aptech.login.entity.Account;

/**
 *
 * @author nhta1
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    Account findByUsername(String username);
    @Query("SELECT o FROM Account o WHERE o.username=:username")
    Account findRoleByUsername(@Param("username") String username);
    
}
