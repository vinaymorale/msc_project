package com.example.resourcesPage.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Resources {
    private String name;
    private String description;
    private String access;
    private String link;
    private String address;
    private String phone;

    public Resources(String name, String description, String access, String link, String address, String phone) {
        this.name = name;
        this.description = description;
        this.access = access;
        this.link = link;
        this.address = address;
        this.phone = phone;
    }
}
