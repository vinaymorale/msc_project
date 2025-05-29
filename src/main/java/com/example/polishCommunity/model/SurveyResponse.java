package com.example.polishCommunity.model;

import lombok.Getter;
import lombok.Setter;

public class SurveyResponse {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String question1;
    @Setter
    @Getter
    private String question2;
    @Setter
    @Getter
    private String question3;
    @Setter
    @Getter
    private String question4;
    @Setter
    @Getter
    private String question5;
    @Setter
    @Getter
    private String question6;
    @Setter
    @Getter
    private String question7;
    @Setter
    @Getter
    private String question8;
    @Setter
    @Getter
    private String question9;
    @Setter
    @Getter
    private String question10;

    // Constructors

    public SurveyResponse(String name, String email, String question1, String question2, String question3,
                          String question4, String question5, String question6, String question7,
                          String question8, String question9, String question10) {
        this.name = name;
        this.email = email;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
        this.question6 = question6;
        this.question7 = question7;
        this.question8 = question8;
        this.question9 = question9;
        this.question10 = question10;
    }

    // Getters and setters

}
