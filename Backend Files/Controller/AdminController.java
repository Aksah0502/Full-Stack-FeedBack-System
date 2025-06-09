package com.FeedbackPage.Modules.Controller;
import com.FeedbackPage.Modules.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return service.isValidLogin(username, password);
    }
}