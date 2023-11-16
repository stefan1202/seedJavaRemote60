package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.seedjavaremote60.exceptions.EntityNotFoundException;
import ro.sda.seedjavaremote60.models.Book;
import ro.sda.seedjavaremote60.services.BookService;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping("")
    public String createBook(Model model) {
        model.addAttribute("bookFormObject", new Book());
        return "bookForm";
    }

    @GetMapping("/edit/{bookID}")
    public String editBook(@PathVariable(name="bookID") Long id,  Model model) throws EntityNotFoundException {
        Book book = bookService.findBookByID(id);
        model.addAttribute("bookFormObject", book);
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("bookForm") @Valid Book book, Errors validationErrors, Model model){
        if(validationErrors.hasErrors()) return "bookForm";

        bookService.createBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String listBooks(@RequestParam(name="title",required = false) String title, Model model){
        if(title!=null) {
            model.addAttribute("books", bookService.findBookByTitle(title));
        }
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
