/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.books.entity.Book;

/**
 *
 * @author Thanh Sang
 */
public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
