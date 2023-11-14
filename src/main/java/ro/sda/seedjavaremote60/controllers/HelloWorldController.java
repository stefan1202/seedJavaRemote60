package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.seedjavaremote60.models.Author;


@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld(@RequestParam(required = false) String name,  Model model){
        model.addAttribute("name",name);
        model.addAttribute("formObject", new Author());
        return "hello";
    }

    @PostMapping("/process")
    public String helloWorld(@ModelAttribute("formObject") @Valid Author author, Errors errors, Model model){
        if (errors.hasErrors()){
            return "hello";
        }
        model.addAttribute("author",author);
        return "display";
    }
}
