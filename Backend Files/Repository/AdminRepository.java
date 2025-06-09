package com.FeedbackPage.Modules.Repository;


import com.FeedbackPage.Modules.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}

