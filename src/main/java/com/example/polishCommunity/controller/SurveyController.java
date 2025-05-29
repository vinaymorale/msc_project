package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.SurveyResponse;
import com.example.polishCommunity.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping("/work-survey")
    public String handleFormSubmission(@RequestParam(name = "name") String name,
                                       @RequestParam(name = "email") String email,
                                       @RequestParam(name = "question1") String question1,
                                       @RequestParam(name = "question2") String question2,
                                       @RequestParam(name = "question3") String question3,
                                       @RequestParam(name = "question4") String question4,
                                       @RequestParam(name = "question5") String question5,
                                       @RequestParam(name = "question6") String question6,
                                       @RequestParam(name = "question7") String question7,
                                       @RequestParam(name = "question8") String question8,
                                       @RequestParam(name = "question9") String question9,
                                       @RequestParam(name = "question10") String question10,
                                       Model model) {
        try {
            // Create SurveyResponse object
            SurveyResponse surveyResponse = new SurveyResponse(name, email, question1, question2, question3, question4,
                    question5, question6, question7, question8, question9,
                    question10);

            System.out.println(surveyResponse.getEmail());

            // Save the response via service
            surveyService.saveSurveyResponse(surveyResponse);

            // Add success message
            model.addAttribute("successMessage", "Thank you for submitting the survey!");
        } catch (Exception e) {
            // Add error message
            model.addAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
        }

        return "Pages/Work-SurveyPage";
    }
}

//
//            // Create a new SurveyResponse object using the data from the form
//            SurveyResponse surveyResponse = new SurveyResponse(name, email, question1, question2, question3, question4, question5, question6, question7, question8, question9, question10);
//            surveyRepository.save(surveyResponse);
//
//            // Add success message to model to display it on the page
//            model.addAttribute("successMessage", "Thank you for submitting the survey!");
//        }   catch (Exception e) {
//            model.addAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
//        }
//        // Return to the survey page with a success message
//        return "redirect:/Work-Survey";
//    }
//                }
