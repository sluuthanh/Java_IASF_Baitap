/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.books.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.books.entity.Book;

/**
 *
 * @author Thanh Sang
 */
public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(int id);
    Book save(Book book);
    void deleteById(int id);
}
