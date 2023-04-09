package com.example.bookapplication.controller;

import com.example.bookapplication.model.Book;
import com.example.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/post")
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping("/getAll")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id){
        return bookService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        bookService.deleteById(id);
    }

    @PutMapping("/update/")
    public Book update(@RequestBody Book book){
        Book existingBook = bookService.findById(book.getId());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setPubYear(book.getPubYear());
        return bookService.save(existingBook);
    }

}




