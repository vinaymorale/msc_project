package com.example.polishCommunity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SubRights {
    private int subTitleId;
    private String subTitle;
    private String description;
    private int titleId;
}
