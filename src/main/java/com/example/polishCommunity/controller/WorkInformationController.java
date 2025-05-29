package com.example.polishCommunity.controller;

import com.example.polishCommunity.service.WorkInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkInformationController {

    private final WorkInformationService workInformationService;

    @Autowired
    public WorkInformationController(WorkInformationService workInformationService) {
        this.workInformationService = workInformationService;
    }

    @GetMapping("/resources/workPage")
    public String getAllWorkInformation(Model model) {
        model.addAttribute("workInformationList", workInformationService.getAllWorkInformation());
        return "Pages/workPage";
    }
}