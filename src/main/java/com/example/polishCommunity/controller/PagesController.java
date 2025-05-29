package com.example.polishCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {


    @GetMapping("/FAQpage")
    public String FAQpage(Model model) {
        return "Pages/FAQpage";
    }

    @GetMapping("/contact")
    public String contact(Model model) { return "Pages/contactsPage";
    }

    @GetMapping("/signin-register")
    public String Signregister(Model model) {
        return "Pages/signin-register";
    }

    @GetMapping("/healthPage")
    public String healthPage(Model model) {
        return "Pages/healthPage";
    }

    @GetMapping("/workPage")
    public String work(Model model) {
        return "Pages/workPage";
    }

    @GetMapping("/Work-Survey")
    public String work_survey(Model model) {
        return "Pages/Work-SurveyPage";
    }

    @GetMapping("/socialConnections")
    public String socialConnections(Model model) {
        return "Pages/socialConnections";
    }
}

