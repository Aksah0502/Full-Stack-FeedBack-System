package com.FeedbackPage.Modules.Controller;

import com.FeedbackPage.Modules.FeedbackService;
import com.FeedbackPage.Modules.Model.Feedback;
import com.FeedbackPage.Modules.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
        try {
            feedbackRepo.save(feedback);
            return ResponseEntity.ok("Saved"); // This is what JS will check for
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Something went wrong on server.");
        }
    }

    @GetMapping("/admin/feedbacks")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedback();
    }
}