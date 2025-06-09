package com.FeedbackPage.Modules;


import com.FeedbackPage.Modules.Model.Feedback;
import com.FeedbackPage.Modules.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    public List<Feedback> getAllFeedback() {
        return repo.findAll();
    }
}