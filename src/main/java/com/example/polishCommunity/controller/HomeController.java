package com.example.polishCommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping
    public String showHomePage(Model model) {
        // Query to fetch the latest 3 events from the database
        String eventQuery = "SELECT id, title, date, location, category, image_url " +
                "FROM eventss " +
                "ORDER BY date DESC " +
                "LIMIT 3";
        List<Map<String, Object>> latestEvents = jdbcTemplate.queryForList(eventQuery);


        model.addAttribute("latestEvents", latestEvents);

        return "Pages/home";
    }
}
