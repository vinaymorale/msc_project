package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Safety;
import com.example.polishCommunity.repository.SafetyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SafetyService {
    private final SafetyRepository safetyRepository;
    public SafetyService(SafetyRepository safetyRepository){
        this.safetyRepository = safetyRepository;
    }
    public List<Safety> getAllSafetyItems(){
        return safetyRepository.getAllSafetyItems();
    }
}