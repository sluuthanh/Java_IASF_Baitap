/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.student.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.student.entity.Student;
import vn.aptech.student.repository.StudentRepository;
import vn.aptech.student.service.StudentService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class StudentServiceImpl implements StudentService{

    //inject doi tuong repo
    @Autowired
    private StudentRepository repo;
    
    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Student save(Student stu) {
        return repo.save(stu);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
