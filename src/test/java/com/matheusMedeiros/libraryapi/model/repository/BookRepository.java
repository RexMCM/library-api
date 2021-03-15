package com.matheusMedeiros.libraryapi.model.repository;

import com.matheusMedeiros.libraryapi.api.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
