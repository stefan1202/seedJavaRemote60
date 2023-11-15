package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.seedjavaremote60.models.Book;
import ro.sda.seedjavaremote60.services.BookService;

@Controller
@RequestMapping("/book")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showBookForm(Model model) {
        model.addAttribute("bookForm", new Book());
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("bookForm") @Valid Book book, Errors validationErrors, Model model){
        if(validationErrors.hasErrors()) return "bookForm";

        bookService.createBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "displayBooks";
    }
}
