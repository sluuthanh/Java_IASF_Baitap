/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.student.entity.Student;

/**
 *
 * @author Thanh Sang
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
