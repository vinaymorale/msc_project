package com.example.polishCommunity.service;

import com.example.newsPage.model.News;
import com.example.polishCommunity.model.User;
import com.example.polishCommunity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void registerUser(String name, String surname, String email, String password) {
        // Check if the email already exists in the database
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email already in use.");
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(password);

        // Create a new User object
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPasswordHash(hashedPassword);
        user.setRole("User");

        // Save the user to the database
        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
            return user;
        }
        throw new IllegalArgumentException("Invalid credentials");
    }

    // This is the method that checks if the email and password match
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Check if the entered password matches the hashed password stored in the database
            return passwordEncoder.matches(password, user.getPasswordHash());
        }
        return false; // Return false if user doesn't exist
    }

    public User getCurrentUser(String email) {
        return userRepository.findByEmail(email);
    }
}
