/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.picture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.picture.entity.Picture;

/**
 *
 * @author namng
 */
public interface PictureRepository extends JpaRepository<Picture,Integer> {
    
}
