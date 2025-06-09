package com.FeedbackPage.Modules;

import com.FeedbackPage.Modules.Model.Admin;
import com.FeedbackPage.Modules.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin getByUsername(String username) {
        return repo.findByUsername(username);
    }

    public boolean isValidLogin(String username, String rawPassword) {
        Admin admin = getByUsername(username);
        return admin != null && passwordEncoder.matches(rawPassword, admin.getPassword());
    }
}