package com.example.polishCommunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for now
                .authorizeHttpRequests(authorize -> authorize
                        // Allow public access to these URLs
                        .requestMatchers("/", "/signin-register", "/register",
                                "/login", "/home", "/news", "/events",
                                "/EventsPage", "/contact", "/FAQpage",
                                "resources/education", "/healthPage",
                                "/health", "/health-survey", "/health/submit", "/workPage", "/housing",
                                "/rights/{id}", "/housing-questionnaire", "/housing", "/housing/housing-questionnaire", "/dashboard/AddEvents", "/dashboard/AddEvent",
                                "/housing", "/housing/housing-questionnaire", "/safetyPage",
                               "/EventsPage", "/housing/submit-reply", "/Work-Survey", "/work-survey", "/organisations",
                                "/profile", "/profileLogin", "/dashboard/metrics","/addNewPolicy",
                                "/dashboard/users", "/dashboard/users/delete", "/dashboard/users/toggle-status", "/latestNews"
                                ,"/editNewPolicy/{sub_title_id}","/editNewPolicy",
                                "/deletePolicy/{id}","/rightsView/{id}","/dashboard/EventsTable", "/socialConnections", "/dashboard/AddSafetyInfo",
                                 "/dashboard/approve-comment", "/dashboard/approve-reply", "/dashboard/pending-comments",
                                  "/dashboard/reject-comment", "/dashboard/reject-reply")

                        .permitAll()
                        // Allow static resources
                        .requestMatchers("/static/**", "/stylesheet/**", "/JavaScript/**", "/images/**", "/templates/**").permitAll()
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/signin-register") // Custom login page
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
    }
}
