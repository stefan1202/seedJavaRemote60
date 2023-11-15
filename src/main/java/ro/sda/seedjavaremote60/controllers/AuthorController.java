package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.seedjavaremote60.models.Author;
import ro.sda.seedjavaremote60.services.AuthorService;


@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final  AuthorService authorService;

    @GetMapping("")
    public String helloWorld(@RequestParam(required = false) String name,  Model model){
        model.addAttribute("name",name);
        model.addAttribute("formObject", new Author());
        return "authorForm";
    }

    @PostMapping("/create")
    public String helloWorld(@ModelAttribute("formObject") @Valid Author author, Errors errors, Model model){
        if (errors.hasErrors()){
            return "authorForm";
        }
        authorService.create(author);
        return "redirect:/author/list";
    }

    @GetMapping("/list")
    public String listAuthors (Model model){
        model.addAttribute("authors",authorService.getAuthors());
        return "authors";
    }
}
