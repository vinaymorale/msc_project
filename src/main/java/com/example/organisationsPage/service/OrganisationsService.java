package com.example.organisationsPage.service;

import com.example.organisationsPage.model.Organisations;
import com.example.organisationsPage.repository.OrganisationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationsService {

    private final OrganisationsRepository organisationsRepository;

    public OrganisationsService(OrganisationsRepository organisationsRepository) { this.organisationsRepository = organisationsRepository; }

    public List<Organisations> getAllOrganisations() {
        return organisationsRepository.findAll();
    }
}
