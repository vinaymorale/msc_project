package com.example.polishCommunity.controller;

import com.example.polishCommunity.service.SafetyService;
import com.example.polishCommunity.model.Safety;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class SafetyController {

    @Autowired
    private SafetyService safetyService;

    @GetMapping("/safetyPage")
    public String showSafetyPage(Model model){
        List<Safety> safetyItems = safetyService.getAllSafetyItems();
        model.addAttribute("safetyItems", safetyItems);
        return "Pages/safety";
    }
}
