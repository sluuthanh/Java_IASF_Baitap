/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.student.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.student.entity.Student;

/**
 *
 * @author Thanh Sang
 */
public interface StudentService {
    
    List<Student> findAll();
    
    Optional<Student> findById(int id);
    
    Student save(Student stu);
    
    void deleteById(int id);
    
}
