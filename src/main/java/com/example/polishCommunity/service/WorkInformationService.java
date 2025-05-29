package com.example.polishCommunity.service;

import com.example.polishCommunity.model.WorkInformation;
import com.example.polishCommunity.repository.WorkInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkInformationService {

    private final WorkInformationRepository workInformationRepository;

    public WorkInformationService(WorkInformationRepository workInformationRepository) {
        this.workInformationRepository = workInformationRepository;
    }

    public List<WorkInformation> getAllWorkInformation() {
        return workInformationRepository.findAll();
    }
}
