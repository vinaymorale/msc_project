package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // Show events on the EventsPage
    @GetMapping("/EventsPage")
    public String showEventsPage(Model model) {
        List<Event> events = eventRepository.getAllEvents();
        model.addAttribute("events", events);
        return "Pages/EventsPage"; // Refers to EventsPage.html
    }

    // Show events table in the dashboard
    @GetMapping("/dashboard/EventsTable")
    public String showAddEventsPage(Model model) {
        List<Event> events = eventRepository.getAllEvents();
        model.addAttribute("events", events);
        return "/admin/AddEventsPage";
    }

}



