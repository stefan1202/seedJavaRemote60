package ro.sda.seedjavaremote60.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.seedjavaremote60.models.ContactForm;
import ro.sda.seedjavaremote60.services.EmailService;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/")
    public String createEMail(@ModelAttribute("contactForm") @Valid ContactForm contactForm, Model model) {
        emailService.sendEmail(contactForm.getName(), contactForm.getEmail(), contactForm.getSubject(), contactForm.getNotes());
        return "redirect:/contact/";
    }

}