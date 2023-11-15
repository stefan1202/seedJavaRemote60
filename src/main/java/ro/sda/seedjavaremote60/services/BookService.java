package ro.sda.seedjavaremote60.services;

import org.springframework.stereotype.Service;
import ro.sda.seedjavaremote60.entities.BookEntity;
import ro.sda.seedjavaremote60.mappers.BookMapper;
import ro.sda.seedjavaremote60.models.Book;
import ro.sda.seedjavaremote60.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Book createBook(Book book) {
        BookEntity entity= bookMapper.toEntity(book);
        bookRepository.save(entity);

        return bookMapper.toDto(entity);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//    public Book removeBook(Book book) {
//        books.remove(book);
//        return book;
//    }
}
