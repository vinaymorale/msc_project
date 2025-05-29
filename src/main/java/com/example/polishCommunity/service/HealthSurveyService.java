package com.example.polishCommunity.service;

import com.example.polishCommunity.model.HealthSurveyResponse;
import com.example.polishCommunity.repository.HealthSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthSurveyService{
    @Autowired
    private HealthSurveyRepository healthSurveyRepository;

    public void saveSurveyResponse(HealthSurveyResponse response) {
        healthSurveyRepository.save(response);
    }
}
