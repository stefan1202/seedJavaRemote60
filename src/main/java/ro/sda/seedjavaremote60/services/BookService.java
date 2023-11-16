package ro.sda.seedjavaremote60.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.sda.seedjavaremote60.entities.AuthorEntity;
import ro.sda.seedjavaremote60.entities.BookEntity;
import ro.sda.seedjavaremote60.exceptions.EntityNotFoundException;
import ro.sda.seedjavaremote60.mappers.BookMapper;
import ro.sda.seedjavaremote60.models.Author;
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
        BookEntity entity = bookMapper.toEntity(book);
        entity = bookRepository.save(entity);

        return bookMapper.toDto(entity);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    public List<Book> getAllBooksSorted(String sort, String direction) {
        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sortBy = Sort.by(sortDirection, sort);
        return bookRepository.findAll(sortBy).stream().map(bookMapper::toDto).toList();
    }

    public void remove(Book book) throws EntityNotFoundException {
        bookRepository.findById(book.getId()).orElseThrow(()-> new EntityNotFoundException("Author with id " + book.getId() + " not found"));
        bookRepository.deleteById(book.getId());
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findAllByTitleStartingWith(title).stream().map(bookMapper::toDto).toList();
    }

    public Book findBookByID(Long id) throws EntityNotFoundException {
        BookEntity entity = bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book with id " + id + " not found"));

        return bookMapper.toDto(entity);
    }

    public void  deleteBookByID(Long id) throws EntityNotFoundException {
        BookEntity entity = bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book with id " + id + " not found"));
        bookRepository.deleteById(id);

    }
}
