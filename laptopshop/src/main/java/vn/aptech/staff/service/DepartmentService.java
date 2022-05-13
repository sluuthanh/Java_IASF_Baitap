/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.service;

import java.util.List;
import vn.aptech.staff.entity.Department;

/**
 *
 * @author namng
 */
public interface DepartmentService {
    List<Department> findAll();
    Department save(Department department);
}
