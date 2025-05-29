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
public class DashboardController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/metrics")
    public String showMetrics(Model model) {
        try {
            // Query total users
            int totalUsers = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);

            // Query active users
            int activeUsers = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE is_active = true", Integer.class);

            // Query total news
            int totalNews = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM news", Integer.class);

            // Query total organisations
            int totalOrganisations = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM organisations", Integer.class);
            int totalEvents = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM eventss", Integer.class);


            // Query total comments
            int totalComments = jdbcTemplate.queryForObject(
                    "SELECT (SELECT COUNT(*) FROM housing_questionnaire) + (SELECT COUNT(*) FROM housing_replies) AS totalComments",
                    Integer.class);

            // Add metrics to the model
            model.addAttribute("totalUsers", totalUsers);
            model.addAttribute("activeUsers", activeUsers);
            model.addAttribute("totalNews", totalNews);
            model.addAttribute("totalOrganisations", totalOrganisations);
            model.addAttribute("totalComments", totalComments);
            model.addAttribute("totalEvents", totalEvents);

            return "admin/metrics";
        } catch (Exception e) {
            // Log the error and provide an error message to the model
            model.addAttribute("errorMessage", "Failed to load dashboard metrics. Please try again later.");
            e.printStackTrace(); // Log the stack trace for debugging
            return "admin/metrics"; // Redirect to the metrics page with an error message
        }
    }

    @GetMapping("/pending-comments")
    public String showPendingComments(Model model) {
        String commentsQuery = "SELECT id, name, email, message FROM housing_questionnaire WHERE status = 'pending'";
        List<Map<String, Object>> pendingComments = jdbcTemplate.queryForList(commentsQuery);

        String repliesQuery = "SELECT id, name, message, question_id FROM housing_replies WHERE status = 'pending'";
        List<Map<String, Object>> pendingReplies = jdbcTemplate.queryForList(repliesQuery);

        model.addAttribute("pendingComments", pendingComments);
        model.addAttribute("pendingReplies", pendingReplies);
        return "admin/pendingComments";
    }

    @PostMapping("/approve-comment")
    public String approveComment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            String query = "UPDATE housing_questionnaire SET status = 'approved' WHERE id = ?";
            jdbcTemplate.update(query, id);
            redirectAttributes.addFlashAttribute("successMessage", "Comment approved successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to approve the comment.");
        }
        return "redirect:/dashboard/pending-comments";
    }

    @PostMapping("/reject-comment")
    public String rejectComment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            String query = "DELETE FROM housing_questionnaire WHERE id = ?";
            jdbcTemplate.update(query, id);
            redirectAttributes.addFlashAttribute("successMessage", "Comment rejected and deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to reject the comment.");
        }
        return "redirect:/dashboard/pending-comments";
    }

    @PostMapping("/approve-reply")
    public String approveReply(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            String query = "UPDATE housing_replies SET status = 'approved' WHERE id = ?";
            jdbcTemplate.update(query, id);
            redirectAttributes.addFlashAttribute("successMessage", "Reply approved successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to approve the reply.");
        }
        return "redirect:/dashboard/pending-comments";
    }

    @PostMapping("/reject-reply")
    public String rejectReply(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            String query = "DELETE FROM housing_replies WHERE id = ?";
            jdbcTemplate.update(query, id);
            redirectAttributes.addFlashAttribute("successMessage", "Reply rejected and deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to reject the reply.");
        }
        return "redirect:/dashboard/pending-comments";
    }
}

