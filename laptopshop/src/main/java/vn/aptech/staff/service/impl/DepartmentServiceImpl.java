/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.staff.entity.Department;
import vn.aptech.staff.repository.DepartmentRepository;
import vn.aptech.staff.service.DepartmentService;

/**
 *
 * @author namng
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository repo;

    @Override
    public List<Department> findAll() {
        return repo.findAll();
    }

    @Override
    public Department save(Department department) {
        return repo.save(department);
    }
    
}
