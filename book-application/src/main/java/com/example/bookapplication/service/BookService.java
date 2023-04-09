package com.example.bookapplication.service;


import com.example.bookapplication.model.Book;
import com.example.bookapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(int id){
        Book b = bookRepository.findById(id).orElseThrow(null);
        return b;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

}
