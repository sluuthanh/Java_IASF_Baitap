/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.staff.entity.Department;

/**
 *
 * @author namng
 */
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    
}
