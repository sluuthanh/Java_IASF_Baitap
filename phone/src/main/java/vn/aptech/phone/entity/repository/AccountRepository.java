/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.phone.entity.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.aptech.phone.entity.Account;
/**
 *
 * @author Administrator
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    Account findByUsername(String username);
    @Query("SELECT o FROM Account o WHERE o.username=:username")
    Account findRoleByUsername(@Param("username")String username);
}
