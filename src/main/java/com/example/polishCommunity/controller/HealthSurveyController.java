package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HealthSurveyResponse;
import com.example.polishCommunity.service.HealthSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HealthSurveyController {

    @Autowired
    private HealthSurveyService healthSurveyService;

    @PostMapping("/health-survey")
    public String handleHealthSurveySubmission(@RequestParam(name = "name") String name,
                                               @RequestParam(name = "email") String email,
                                               @RequestParam(name = "location") String location,
                                               @RequestParam(name = "gpRegistered") String gpRegistered,
                                               @RequestParam(name = "q2queries") String q2queries,
                                               Model model) {
        try {

            HealthSurveyResponse healthSurveyResponse = new HealthSurveyResponse(name, email, location, gpRegistered, q2queries);

            healthSurveyService.saveSurveyResponse(healthSurveyResponse);

            model.addAttribute("successMessage", "Thank you for submitting the health survey!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
            e.printStackTrace();
        }
        return "Pages/healthPage";
    }
}
