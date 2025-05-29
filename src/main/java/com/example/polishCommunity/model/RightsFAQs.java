package com.example.polishCommunity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightsFAQs {
    private int queId;
    private String que;
    private String answer;
    private int titleId;
}
