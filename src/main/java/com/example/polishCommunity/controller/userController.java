package com.example.polishCommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dashboard")
public class userController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Fetch and display all users
    @GetMapping("/users")
    public String showUsers(Model model) {
        String query = "SELECT id, name, surname, email, DATE_FORMAT(registration_date, '%Y-%m-%d') AS registration_date, is_active FROM users";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(query);

        model.addAttribute("users", users);
        return "admin/userManagement";
    }

    // Handle user deletion
    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int userId, RedirectAttributes redirectAttributes) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(deleteQuery, userId);

        if (rowsAffected > 0) {
            redirectAttributes.addFlashAttribute("message", "User deleted successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to delete user.");
        }

        return "redirect:/dashboard/users";
    }

    // Handle toggling user status
    @PostMapping("/users/toggle-status")
    public String toggleUserStatus(@RequestParam("id") int userId, RedirectAttributes redirectAttributes) {
        String toggleStatusQuery = "UPDATE users SET is_active = NOT is_active WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(toggleStatusQuery, userId);

        if (rowsAffected > 0) {
            redirectAttributes.addFlashAttribute("message",
                    "User status updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error",
                    "Failed to update user status.");
        }

        return "redirect:/dashboard/users";
    }
}

