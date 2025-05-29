package com.example.polishCommunity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false) // Ensure 'name' is not null in the database
    private String name;

    @Setter
    @Getter
    @Column(nullable = false) // Ensure 'surname' is not null in the database
    private String surname;

    @Setter
    @Getter
    @Column(unique = true, nullable = false) // Email must be unique and not null
    private String email;

    @Setter
    @Getter
    @Column(name = "password_hash", nullable = false) // Ensure password hash is not null
    private String passwordHash;

    @Setter
    @Getter
    @Column(nullable = false)
    private String role;
}