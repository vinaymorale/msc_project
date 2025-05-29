package com.example.polishCommunity.service;

import com.example.polishCommunity.model.SurveyResponse;
import com.example.polishCommunity.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public void saveSurveyResponse(SurveyResponse surveyResponse) {
        surveyRepository.save(surveyResponse);
    }
}

