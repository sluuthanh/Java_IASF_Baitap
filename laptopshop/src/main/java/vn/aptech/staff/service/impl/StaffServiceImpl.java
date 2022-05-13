/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.staff.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.staff.entity.Staff;
import vn.aptech.staff.repository.StaffRepository;
import vn.aptech.staff.service.StaffService;

/**
 *
 * @author namng
 */
@Service
public class StaffServiceImpl implements StaffService {
    
    @Autowired
    private StaffRepository repo;

    @Override
    public List<Staff> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Staff> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Staff save(Staff staff) {
        return repo.save(staff);
    }

    @Override
    public void deleteById(int id) {
       repo.deleteById(id);
    }

    @Override
    public List<Staff> findByName(String name) {
      return repo.findByName(name);
    }
    
}
