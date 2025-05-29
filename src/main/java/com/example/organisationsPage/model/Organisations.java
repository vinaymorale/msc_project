package com.example.organisationsPage.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Organisations {
    private String name;
    private String description;
    private String logo;

    public Organisations(String name, String description, String logo) {
        this.name = name;
        this.description = description;
        this.logo = logo;
    }
}
