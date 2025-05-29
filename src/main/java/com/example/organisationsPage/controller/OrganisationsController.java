package com.example.organisationsPage.controller;

import com.example.organisationsPage.model.Organisations;
import com.example.organisationsPage.service.OrganisationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrganisationsController {

    private final OrganisationsService organisationsService;

    public OrganisationsController(OrganisationsService organisationsService) { this.organisationsService = organisationsService; }

    @GetMapping("/organisations")
    public String getOrganisationsPage(Model model) {
        System.out.println("TestTestTestTestTest");
        List<Organisations> organisationsList = organisationsService.getAllOrganisations();
        model.addAttribute("organisationsList", organisationsList);
        return "Pages/organisations";
    }
}
