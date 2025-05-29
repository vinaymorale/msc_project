package com.example.polishCommunity.controller;

import com.example.polishCommunity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String email,
                               @RequestParam String password,
                               RedirectAttributes redirectAttributes) {  // Use RedirectAttributes to pass messages
        try {
            userService.registerUser(name, surname, email, password);
            redirectAttributes.addFlashAttribute("successMessage", "Account created successfully! Please log in.");
            return "redirect:/signin-register"; // Redirect to signin-register with successMessage
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("registerErrorMessage", e.getMessage());
            return "redirect:/signin-register";  // Redirect to the same page with errorMessage
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            RedirectAttributes redirectAttributes) {
        if (userService.authenticateUser(email, password)) {
            return "redirect:/home"; // Successful login
        } else {
            redirectAttributes.addFlashAttribute("loginErrorMessage", "Invalid email or password. Please try again.");
            return "redirect:/signin-register"; // Redirect back to login page
        }
    }

}