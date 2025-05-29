package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    // Constructor-based dependency injection for the repository
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}

