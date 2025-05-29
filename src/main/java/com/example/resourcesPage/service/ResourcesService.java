package com.example.resourcesPage.service;

import com.example.resourcesPage.model.Resources;
import com.example.resourcesPage.repository.ResourcesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesService {

    private final ResourcesRepository resourcesRepository;

    public ResourcesService(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    public List<Resources> getAllResources() {
        return resourcesRepository.findAll();
    }
}
