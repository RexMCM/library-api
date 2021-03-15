package com.matheusMedeiros.libraryapi.service.impl;

import com.matheusMedeiros.libraryapi.api.model.entity.Book;
import com.matheusMedeiros.libraryapi.model.repository.BookRepository;
import com.matheusMedeiros.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
