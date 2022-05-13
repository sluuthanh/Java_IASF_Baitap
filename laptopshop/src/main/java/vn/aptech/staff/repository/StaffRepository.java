/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.aptech.staff.entity.Staff;

/**
 *
 * @author namng
 */
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    @Query("SELECT o FROM Staff o WHERE o.name = :name")
    List<Staff> findByName(@Param("name") String name);
}
