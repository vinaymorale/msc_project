package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.Safety;
import com.example.polishCommunity.repository.AddSafetyInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddSafetyInfoController {
    @Autowired
    private AddSafetyInfoRepository addSafetyInfoRepository;

    //show the form to add info
    @GetMapping("/dashboard/AddSafetyInfo")
    public String showAddSafetyInfoPage(){
        return "admin/AddSafetyInfo";
    }
    //
    @PostMapping("/dashboard/AddSafetyInfo")
    public String addSafetyInfo(
           @RequestParam String name,
           @RequestParam String description,
           @RequestParam String location,
           @RequestParam String link,
           @RequestParam String phone){

        //make a new piece of safet info and use the parameters set in the schema to fill it
        Safety safety = new Safety();
        safety.setName(name);
        safety.setDescription(description);
        safety.setLocation(location);
        safety.setLink(link);
        safety.setPhone(phone);

        //saves the new info into the database
        addSafetyInfoRepository.addSafetyInfo(safety);
        //will redirect to the safety page showing the new updated list of data
        return "redirect:/safetyPage";
    }
}
