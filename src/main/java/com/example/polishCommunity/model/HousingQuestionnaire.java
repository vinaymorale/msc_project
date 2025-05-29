package com.example.polishCommunity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "housing_questionnaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HousingQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(nullable = false)
    private String message;



    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HousingReply> replies = new ArrayList<>();
    public HousingQuestionnaire(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
    // Helper method to add a reply
    public void addReply(HousingReply reply) {
        replies.add(reply);
        reply.setQuestion(this);
    }

    // Helper method to remove a reply
    public void removeReply(HousingReply reply) {
        replies.remove(reply);
        reply.setQuestion(null);
    }
}
