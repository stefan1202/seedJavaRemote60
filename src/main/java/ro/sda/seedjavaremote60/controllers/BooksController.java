package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.seedjavaremote60.models.Book;

@Controller
public class BooksController {
    @GetMapping("/book")
    public String showBookForm(Model model) {
        model.addAttribute("bookForm", new Book());
        return "book";
    }

    @PostMapping("/book/create")
    public String createBook(@ModelAttribute("bookForm") @Valid Book book, Errors validationErrors, Model model){
        if(validationErrors.hasErrors()) return "book";
        model.addAttribute("bookCreated", book);
        return "displayBooks";
    }
}
