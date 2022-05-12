/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.picture.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.picture.entity.Picture;
import vn.aptech.picture.repository.PictureRepository;
import vn.aptech.picture.service.PictureService;

/**
 *
 * @author namng
 */
@Service
public class PictureServiceImpl implements PictureService {
    
    @Autowired
    private PictureRepository repo;

    @Override
    public List<Picture> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Picture> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Picture save(Picture picture) {
        return repo.save(picture);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
