package by.tms.crudspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model, HttpSession httpSession) {
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "home";
    }
}
