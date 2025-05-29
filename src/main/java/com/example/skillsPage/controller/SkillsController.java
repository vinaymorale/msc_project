package com.example.skillsPage.controller;

import com.example.skillsPage.model.Skills;
import com.example.skillsPage.service.SkillsService;
import com.example.resourcesPage.model.Resources;
import com.example.resourcesPage.service.ResourcesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SkillsController {

    private final SkillsService skillsService;
    private final ResourcesService resourcesService;

    public SkillsController(SkillsService skillsService, ResourcesService resourcesService) {
        this.skillsService = skillsService;
        this.resourcesService = resourcesService;
    }

    @GetMapping("/resources/education")
    public String getSkillsPage(Model model) {
        List<Skills> skillsList = skillsService.getAllSkills();
        List<Resources> resourcesList = resourcesService.getAllResources();
        model.addAttribute("skillsList", skillsList);
        model.addAttribute("resourcesList", resourcesList);
        return "Pages/skillsPage";
    }
}
