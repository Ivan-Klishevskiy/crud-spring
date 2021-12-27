package by.tms.crudspring.controller;

import by.tms.crudspring.dto.AuthorizationUserDto;
import by.tms.crudspring.dto.RegistrationUserDto;
import by.tms.crudspring.entity.User;
import by.tms.crudspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("regUser", new RegistrationUserDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(RegistrationUserDto registrationUserDto, Model model) {
        if (userService.save(registrationUserDto.getName(), registrationUserDto.getUsername(), registrationUserDto.getPassword())) {
            return "redirect:/user/auth";
        } else {
            model.addAttribute("message", "The user is already registered!");
            return "reg";
        }
    }

    @GetMapping("/auth")
    public String authorization(Model model) {
        model.addAttribute("authUser", new RegistrationUserDto());
        return "auth";
    }

    @PostMapping("/auth")
    public String authorization(AuthorizationUserDto authUserDto, Model model, HttpSession httpSession) {
        User byUsername = userService.findByUsername(authUserDto.getUsername());
        if (byUsername != null) {
            if (byUsername.getPassword().equals(authUserDto.getPassword())) {
                httpSession.setAttribute("user", byUsername.getUsername());
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
                return "auth";
            }
        } else {
            model.addAttribute("message", "User not found!");
            return "auth";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
