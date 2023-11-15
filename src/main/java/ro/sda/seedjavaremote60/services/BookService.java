package ro.sda.seedjavaremote60.services;

import org.springframework.stereotype.Service;
import ro.sda.seedjavaremote60.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<Book>();

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }
    public Book removeBook(Book book) {
        books.remove(book);
        return book;
    }
}
