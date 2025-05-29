package com.example.skillsPage.service;

import com.example.skillsPage.model.Skills;
import com.example.skillsPage.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class SkillsService {

    private final SkillsRepository skillsRepository;

    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }
}
