/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import vn.aptech.staff.entity.Staff;

/**
 *
 * @author namng
 */
public interface StaffService {
    List<Staff> findAll();
    Optional<Staff> findById(int id);
    Staff save(Staff staff);
    void deleteById(int id);
    List<Staff> findByName(String name);
}
