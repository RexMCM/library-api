package com.matheusMedeiros.libraryapi.service;


import com.matheusMedeiros.libraryapi.api.model.entity.Book;
import com.matheusMedeiros.libraryapi.model.repository.BookRepository;
import com.matheusMedeiros.libraryapi.service.impl.BookServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setUp(){
        this.service = new BookServiceImpl(repository);
    }

    @Test
    @DisplayName("should save a book")
    public void saveBookTest(){
        Book book = Book.builder().isbn("123").author("fulano").title("As aventuras").build();

        Mockito.when(repository.save(book)).thenReturn(
                Book.builder()
                        .id(1L)
                        .isbn("123")
                        .author("fulano")
                        .title("As aventuras")
                        .build()

        );

        Book savedBook = service.save(book);
        Assertions.assertThat(savedBook.getId()).isNotNull();
        Assertions.assertThat(savedBook.getIsbn()).isEqualTo("123");
        Assertions.assertThat(savedBook.getAuthor()).isEqualTo("fulano");
        Assertions.assertThat(savedBook.getTitle()).isEqualTo("As aventuras");
    }
}
