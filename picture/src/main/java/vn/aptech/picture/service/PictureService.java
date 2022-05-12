/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.picture.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.picture.entity.Picture;

/**
 *
 * @author namng
 */
public interface PictureService {
    List<Picture> findAll();
    Optional<Picture> findById(int id);
    Picture save(Picture picture);
    void deleteById(int id);
}
