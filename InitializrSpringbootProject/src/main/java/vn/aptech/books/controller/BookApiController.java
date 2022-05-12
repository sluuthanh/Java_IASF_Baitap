/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.books.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.aptech.books.entity.Book;
import vn.aptech.books.service.BookService;

/**
 *
 * @author Thanh Sang
 */

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/api/book")
public class BookApiController {
    
    @Autowired
    private BookService service;
    @GetMapping
    public List<Book> getBooks(){
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id){
        return service.findById(id).orElseThrow(RuntimeException::new);
    }
    
    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book) throws URISyntaxException{
        Book savedBook = service.save(book);
        return ResponseEntity.created(new URI("/api/book/"+savedBook.getId())).body(savedBook);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable("id") int id, @RequestBody Book book){
        Book curBook =  service.findById(id).orElseThrow(RuntimeException::new);
        curBook.setPrice(book.getPrice());
        curBook.setTitle(book.getTitle());
        curBook = service.save(curBook);
        return ResponseEntity.ok(curBook);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
