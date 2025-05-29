package com.example.polishCommunity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rights {

    private int titleId;
    private String title;
    private List<SubRights> subTitle;
    private List<RightsFAQs> que;
    private String description;

    public Rights(int titleId, String title, String description) {
        this.titleId = titleId;
        this.title = title;
        this.description = description;
    }

}
