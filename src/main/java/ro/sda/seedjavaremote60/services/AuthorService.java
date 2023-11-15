package ro.sda.seedjavaremote60.services;

import org.springframework.stereotype.Service;
import ro.sda.seedjavaremote60.models.Author;

import java.util.ArrayList;
import java.util.List;

@Service

public class AuthorService {
    private final List<Author> authors = new ArrayList<Author>();

    public Author create(Author book) {
        authors.add(book);
        return book;
    }
    public Author remove(Author book) {
        authors.remove(book);
        return book;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
