package ro.sda.seedjavaremote60;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld(@RequestParam(required = false) String name, Model model){
        model.addAttribute("time",System.currentTimeMillis());
        model.addAttribute("name",name);
        return "hello";
    }
}
