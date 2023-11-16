package ro.sda.seedjavaremote60.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.seedjavaremote60.models.Author;
import ro.sda.seedjavaremote60.services.AuthorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAuthors();
    }
}
