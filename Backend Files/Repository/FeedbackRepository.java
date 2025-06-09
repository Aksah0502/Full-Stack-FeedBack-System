package com.FeedbackPage.Modules.Repository;


import com.FeedbackPage.Modules.Model.Feedback;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
