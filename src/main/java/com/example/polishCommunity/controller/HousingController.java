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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String showHousingPage(Model model) {
        // Fetch approved questions and their replies
        String query = "SELECT q.id AS question_id, q.name AS question_name, q.email AS question_email, q.message AS question_message, " +
                "r.id AS reply_id, r.name AS reply_name, r.message AS reply_message " +
                "FROM housing_questionnaire q " +
                "LEFT JOIN housing_replies r ON q.id = r.question_id " +
                "WHERE q.status = 'approved' AND (r.status = 'approved' OR r.status IS NULL)";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        // Group replies by question
        Map<Long, Map<String, Object>> questionsMap = new HashMap<>();
        for (Map<String, Object> row : result) {
            Long questionId = ((Number) row.get("question_id")).longValue();

            if (!questionsMap.containsKey(questionId)) {
                Map<String, Object> questionData = new HashMap<>();
                questionData.put("id", row.get("question_id"));
                questionData.put("name", row.get("question_name"));
                questionData.put("email", row.get("question_email"));
                questionData.put("message", row.get("question_message"));
                questionData.put("replies", new ArrayList<Map<String, Object>>());
                questionsMap.put(questionId, questionData);
            }

            if (row.get("reply_id") != null) {
                Map<String, Object> replyData = new HashMap<>();
                replyData.put("id", row.get("reply_id"));
                replyData.put("name", row.get("reply_name"));
                replyData.put("message", row.get("reply_message"));
                ((List<Map<String, Object>>) questionsMap.get(questionId).get("replies")).add(replyData);
            }
        }

        model.addAttribute("questions", new ArrayList<>(questionsMap.values()));
        return "Pages/housingPage";
    }



    @PostMapping("/housing-questionnaire")
    public String handleFormSubmission(@RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "email", required = false) String email,
                                       @RequestParam(name = "message") String message,
                                       RedirectAttributes redirectAttributes) {
        try {
            String query = "INSERT INTO housing_questionnaire (name, email, message, status) VALUES (?, ?, ?, 'pending')";
            jdbcTemplate.update(query, name, email, message);
            redirectAttributes.addFlashAttribute("successMessage", "Your comment has been submitted and is awaiting approval.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to submit your comment. Please try again.");
        }
        return "redirect:/housing";
    }

    @PostMapping("/submit-reply")
    public String handleReplySubmission(@RequestParam("questionId") Long questionId,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam("replyMessage") String replyMessage,
                                        RedirectAttributes redirectAttributes) {
        try {
            String query = "INSERT INTO housing_replies (name, message, question_id, status) VALUES (?, ?, ?, 'pending')";
            jdbcTemplate.update(query, name, replyMessage, questionId);
            redirectAttributes.addFlashAttribute("commentSuccessMessage", "Your reply has been submitted and is awaiting approval.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("commentErrorMessage", "Failed to submit your reply.");
        }
        return "redirect:/housing";
    }
}
