package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.seedjavaremote60.exceptions.EntityNotFoundException;
import ro.sda.seedjavaremote60.models.Author;
import ro.sda.seedjavaremote60.services.AuthorService;


@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final  AuthorService authorService;

    @GetMapping("")
    public String createAuthor(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name",name);
        model.addAttribute("authorFormObject", new Author());
        return "authorForm";
    }

    @GetMapping("/edit/{authorID}")
    public String editAuthor(@PathVariable(name="authorID") Long id,  Model model) throws EntityNotFoundException {
        Author author = authorService.findAuthorByID(id);
        model.addAttribute("authorFormObject", author);
        return "authorForm";
    }
    @GetMapping("/delete/{authorID}")
    public String deleteAuthor(@PathVariable(name="authorID") Long id,  Model model) throws EntityNotFoundException {
        authorService.deleteAuthorByID(id);
        return "redirect:/author/list";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("authorFormObject") @Valid Author author, Errors errors, Model model){
        if (errors.hasErrors()){
            return "authorForm";
        }
        authorService.create(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/list")
    public String listAuthors (@RequestParam(name="name",required = false) String name, Model model){
        if (name!=null){
            model.addAttribute("authors", authorService.findAuthorsByName(name));
        }else {
            model.addAttribute("authors", authorService.getAuthors());
        }
        return "authors";
    }

}
