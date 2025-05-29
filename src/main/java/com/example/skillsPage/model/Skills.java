package com.example.skillsPage.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Skills {
    private String name;
    private String description;
    private String link;
    private String duration;
    private LocalDate expiryDate;

    public Skills(String name, String description, String link, String duration, LocalDate expiryDate) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.duration = duration;
        this.expiryDate = expiryDate;
    }
}
