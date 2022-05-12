/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.books.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.books.entity.Book;
import vn.aptech.books.repository.BookRepository;
import vn.aptech.books.service.BookService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository repo;
    
    @Override
    public List<Book> findAll() {
        return repo.findAll().stream()
                .map(b->new Book(b.getId(), b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Book save(Book book) {
        return repo.save(book);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
